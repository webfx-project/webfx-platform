package dev.webfx.platform.async.util;

import dev.webfx.platform.async.AsyncFunction;
import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import dev.webfx.platform.console.Console;
import dev.webfx.platform.scheduler.Scheduled;
import dev.webfx.platform.scheduler.Scheduler;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Bruno Salmon
 */
public final class AsyncQueue {

    private record WaitingOperation<A, R>(A argument, Promise<R> promise, AsyncFunction<A, R> executor) {}

    private final String name;
    private final int executingQueueMaxSize;
    private final Queue<WaitingOperation<?, ?>> waitingOperations = new ArrayDeque<>();
    private final List<Object> executingOperations = new ArrayList<>();
    private long executionTimeout; // Timeout in milliseconds, 0 or negative means no timeout

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
        // Can it be executed now?
        synchronized (executingOperations) {
            if (executingOperations.size() < executingQueueMaxSize) { // Yes
                executingOperations.add(argument);
                return executeOperation(argument, executor);
            }
        }

        // No, so we put it in the waiting queue with a promise
        Promise<R> promise = Promise.promise();
        synchronized (waitingOperations) {
            waitingOperations.add(new WaitingOperation<>(argument, promise, executor));
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

    public void log(String message) {
        Console.log("[" + (name == null ? " " : name + " | ") + waitingOperationsSize() + " | " + executingOperationsSize() + " ] " + message);
    }

    private int waitingOperationsSize() {
        synchronized (waitingOperations) {
            return waitingOperations.size();
        }
    }

    private int executingOperationsSize() {
        synchronized (executingOperations) {
            return executingOperations.size();
        }
    }
}
