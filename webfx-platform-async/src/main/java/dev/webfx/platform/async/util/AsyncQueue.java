package dev.webfx.platform.async.util;

import dev.webfx.platform.async.AsyncFunction;
import dev.webfx.platform.async.Future;
import dev.webfx.platform.async.Promise;
import dev.webfx.platform.console.Console;

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

    public AsyncQueue(int executingQueueMaxSize) {
        this(executingQueueMaxSize, null);
    }

    public AsyncQueue(int executingQueueMaxSize, String name) {
        this.executingQueueMaxSize = executingQueueMaxSize;
        this.name = name;
    }

    public <A, R> Future<R> addAsyncOperation(A argument, AsyncFunction<A, R> executor) {
        // Can it be executed now?
        if (executingOperations.size() < executingQueueMaxSize) { // Yes
            return executeOperation(argument, executor);
        }
        // No, so we put it in the waiting queue with a promise
        Promise<R> promise = Promise.promise();
        waitingOperations.add(new WaitingOperation<>(argument, promise, executor));
        return promise.future();
    }

    private <A, R> Future<R> executeOperation(A argument, AsyncFunction<A, R> executor) {
        executingOperations.add(argument);
        return executor.apply(argument)
            .onComplete(ar -> {
                executingOperations.remove(argument);
                executeNext();
            });
    }

    private void executeNext() {
        if (executingOperations.size() < executingQueueMaxSize && !waitingOperations.isEmpty()) {
            WaitingOperation waitingOperation = waitingOperations.poll();
            executeOperation(waitingOperation.argument, waitingOperation.executor)
                .onComplete(waitingOperation.promise);
        }
    }

    public void log(String message) {
        Console.log("[" + (name == null ? " " : name + " | ") + waitingOperations.size() + " | " + executingOperations.size() + " ] " + message);
    }
}
