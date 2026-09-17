package dev.webfx.platform.async.util;

import dev.webfx.platform.async.AsyncFunction;
import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import dev.webfx.platform.console.Console;
import dev.webfx.platform.scheduler.Scheduled;
import dev.webfx.platform.scheduler.Scheduler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Bruno Salmon
 */
public final class AsyncQueue {

    private record WaitingOperation<A, R>(
        A argument,
        Promise<R> promise,
        AsyncFunction<A, R> executor,
        int priority,
        Object sourceId,
        long seq
    ) {}

    // Higher priority first; within the same priority band, lower seq first (preserving FIFO order)
    private static final Comparator<WaitingOperation<?, ?>> WAITING_ORDER =
        Comparator.<WaitingOperation<?, ?>>comparingInt(WaitingOperation::priority).reversed()
            .thenComparingLong(WaitingOperation::seq);

    private final String name;
    private final int executingQueueMaxSize;
    private final PriorityQueue<WaitingOperation<?, ?>> waitingOperations = new PriorityQueue<>(WAITING_ORDER);
    private final List<Object> executingOperations = new ArrayList<>();
    private long executionTimeout; // Timeout in milliseconds, 0 or negative means no timeout
    private long nextSeq; // Monotonic sequence used as a tiebreaker to preserve FIFO order within a priority band
    private int peakWaitingCount; // High-water mark of the waiting-queue size (monitoring only)
    private int shedCount; // Total operations rejected by rejectIfWouldWait admission (monitoring only)

    public AsyncQueue(int executingQueueMaxSize) {
        this(executingQueueMaxSize, null);
    }

    public AsyncQueue(int executingQueueMaxSize, String name) {
        this.executingQueueMaxSize = executingQueueMaxSize;
        this.name = name;
    }

    public long getExecutionTimeout() {
        return executionTimeout;
    }

    public AsyncQueue setExecutionTimeout(long timeoutMs) {
        executionTimeout = timeoutMs;
        return this;
    }

    public <A, R> Future<R> addAsyncOperation(A argument, AsyncFunction<A, R> executor) {
        return addAsyncOperation(argument, 0, null, executor);
    }

    /**
     * Submits an operation with an explicit priority and an optional source identifier.
     * <p>
     * Priority semantics: when picking the next operation to execute, the queue picks the one with
     * the highest priority value; ties are broken by FIFO order. Standard priority is 0.
     * <p>
     * Source semantics: when {@code sourceId} is non-null and a pending waiting operation already
     * has the same {@code sourceId}, that older operation is removed from the queue and its
     * future is failed with a {@link SupersededOperationException} — typical for "user is typing
     * in a search box" patterns where the latest input invalidates earlier in-flight queries.
     */
    public <A, R> Future<R> addAsyncOperation(A argument, int priority, Object sourceId, AsyncFunction<A, R> executor) {
        return addAsyncOperation(argument, priority, sourceId, executor, false);
    }

    /**
     * Same as {@link #addAsyncOperation(Object, int, Object, AsyncFunction)}, with a load-shedding
     * admission policy: when {@code rejectIfWouldWait} is true and the operation cannot execute
     * immediately (the executing set is at capacity), it is refused with a
     * {@link SheddedOperationException} instead of being queued — it never consumes a waiting slot.
     * <p>
     * Intended for optional work (background cache revalidations) whose callers hold a usable
     * fallback: under load, shedding it at the door costs ~nothing, whereas queueing it would both
     * delay mandatory operations and burn effort on results the caller may no longer need.
     */
    public <A, R> Future<R> addAsyncOperation(A argument, int priority, Object sourceId, AsyncFunction<A, R> executor, boolean rejectIfWouldWait) {
        // Can it be executed now?
        synchronized (executingOperations) {
            if (executingOperations.size() < executingQueueMaxSize) { // Yes
                executingOperations.add(argument);
                return executeOperation(argument, executor);
            }
        }

        // The operation would have to wait — a sheddable one is refused right here, before it
        // consumes a waiting slot. (A slot freeing up between the check above and this return is
        // benign: the caller's next attempt gets it.)
        if (rejectIfWouldWait) {
            synchronized (waitingOperations) {
                shedCount++;
            }
            return Future.failedFuture(new SheddedOperationException(
                SheddedOperationException.SERVER_BUSY_PREFIX + ": operation shed (executor at capacity)"));
        }

        // No — queue it. The "cancel any same-source pending op" step must happen in the same
        // critical section as the add, otherwise two concurrent same-source adds could each find
        // an empty queue, both insert, and silently break source coalescing.
        Promise<R> promise = Promise.promise();
        WaitingOperation<?, ?> cancelled = null;
        synchronized (waitingOperations) {
            if (sourceId != null) {
                Iterator<WaitingOperation<?, ?>> it = waitingOperations.iterator();
                while (it.hasNext()) {
                    WaitingOperation<?, ?> op = it.next();
                    if (sourceId.equals(op.sourceId())) {
                        it.remove();
                        cancelled = op;
                        // A source has at most one pending op once we hold the lock — break.
                        break;
                    }
                }
            }
            waitingOperations.add(new WaitingOperation<>(argument, promise, executor, priority, sourceId, nextSeq++));
            if (waitingOperations.size() > peakWaitingCount)
                peakWaitingCount = waitingOperations.size();
        }
        // Fail the superseded promise outside the lock — listeners may re-enter addAsyncOperation.
        if (cancelled != null) {
            cancelled.promise().tryFail(new SupersededOperationException(
                "Cancelled: superseded by a newer request from the same source"));
        }
        return promise.future();
    }

    private <A, R> Future<R> executeOperation(A argument, AsyncFunction<A, R> executor) {
        Future<R> future = executor.apply(argument);
        Scheduled scheduledTimeout;
        if (executionTimeout > 0) {
            Promise<R> promise = Promise.promise();
            scheduledTimeout = Scheduler.scheduleDelay(executionTimeout, () ->
                promise.tryFail("Timeout: the operation exceeded " + executionTimeout + " ms to execute"));
            future.onComplete(ar -> {
                if (ar.succeeded())
                    promise.tryComplete(ar.result());
                else
                    promise.tryFail(ar.cause());
            });
            future = promise.future();
        } else
            scheduledTimeout = null;
        return future
            .onComplete(ar -> {
                synchronized (executingOperations) {
                    executingOperations.remove(argument);
                }
                if (scheduledTimeout != null)
                    scheduledTimeout.cancel();
                executeNext();
            });
    }

    private void executeNext() {
        WaitingOperation waitingOperation = null;
        synchronized (executingOperations) {
            if (executingOperations.size() < executingQueueMaxSize) {
                synchronized (waitingOperations) {
                    waitingOperation = waitingOperations.poll();
                    if (waitingOperation != null) {
                        executingOperations.add(waitingOperation.argument);
                    }
                }
            }
        }

        if (waitingOperation != null) {
            executeOperation(waitingOperation.argument, waitingOperation.executor)
                .onComplete(waitingOperation.promise);
        }
    }

    /** The queue's name (e.g. "POSTGRES-QUERY"), or null. For monitoring. */
    public String getName() {
        return name;
    }

    /** Max number of operations that may execute concurrently (the concurrency cap). */
    public int getExecutingQueueMaxSize() {
        return executingQueueMaxSize;
    }

    /** Number of operations currently waiting (queued, not yet started). For monitoring. */
    public int getWaitingCount() {
        synchronized (waitingOperations) {
            return waitingOperations.size();
        }
    }

    /** Number of operations currently executing (bounded by the concurrency cap). For monitoring. */
    public int getExecutingCount() {
        synchronized (executingOperations) {
            return executingOperations.size();
        }
    }

    /** High-water mark of {@link #getWaitingCount()} since creation. For monitoring. */
    public int getPeakWaitingCount() {
        synchronized (waitingOperations) {
            return peakWaitingCount;
        }
    }

    /** Total operations refused by {@code rejectIfWouldWait} admission since creation. For monitoring. */
    public int getShedCount() {
        synchronized (waitingOperations) {
            return shedCount;
        }
    }

    public void log(String message) {
        Console.log("[" + (name == null ? " " : name + " | ") + waitingOperations.size() + " | " + executingOperations.size() + " ] " + message);
    }

}
