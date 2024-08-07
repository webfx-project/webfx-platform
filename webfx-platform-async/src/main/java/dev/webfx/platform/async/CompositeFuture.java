package dev.webfx.platform.async;

/**
 * @author Bruno Salmon
 */

import java.util.ArrayList;
import java.util.List;

/**
 * The composite future wraps a list of {@link Future futures}, it is useful when several futures
 * needs to be coordinated.
 * The handlers set for the coordinated futures are overridden by the handler of the composite future.
 *
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public interface CompositeFuture extends Future<CompositeFuture> {

    /**
     * Return a composite future, succeeded when all futures are succeeded, failed when any future is failed.
     * <p/>
     * The returned future fails as soon as one of {@code f1} or {@code f2} fails.
     *
     * @param f1 future
     * @param f2 future
     * @return the composite future
     * @deprecated instead use {@link Future#all(Future, Future)}
     */
    /*@Deprecated
    static <T1, T2> CompositeFuture all(Future<T1> f1, Future<T2> f2) {
        return CompositeFutureImpl.all(f1, f2);
    }*/

    /**
     * Like {@link #all(Future, Future)} but with 3 futures.
     * @deprecated instead use {@link Future#all(Future, Future, Future)}
     */
    /*@Deprecated
    static <T1, T2, T3> CompositeFuture all(Future<T1> f1, Future<T2> f2, Future<T3> f3) {
        return CompositeFutureImpl.all(f1, f2, f3);
    }*/

    /**
     * Like {@link #all(Future, Future)} but with 4 futures.
     * @deprecated instead use {@link Future#all(Future, Future, Future, Future)}
     */
    /*@Deprecated
    static <T1, T2, T3, T4> CompositeFuture all(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4) {
        return CompositeFutureImpl.all(f1, f2, f3, f4);
    }*/

    /**
     * Like {@link #all(Future, Future)} but with 5 futures.
     * @deprecated instead use {@link Future#all(Future, Future, Future, Future, Future)}
     */
    /*@Deprecated
    static <T1, T2, T3, T4, T5> CompositeFuture all(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4, Future<T5> f5) {
        return CompositeFutureImpl.all(f1, f2, f3, f4, f5);
    }*/

    /**
     * Like {@link #all(Future, Future)} but with 6 futures.
     * @deprecated instead use {@link Future#all(Future, Future, Future, Future, Future, Future)}
     */
    /*@Deprecated
    static <T1, T2, T3, T4, T5, T6> CompositeFuture all(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4, Future<T5> f5, Future<T6> f6) {
        return CompositeFutureImpl.all(f1, f2, f3, f4, f5, f6);
    }*/

    /**
     * Like {@link #all(Future, Future)} but with a list of futures.<p>
     *
     * When the list is empty, the returned future will be already completed.
     * @deprecated instead use {@link Future#all(List)}
     */
    /*@Deprecated
    static CompositeFuture all(List<Future> futures) {
        return CompositeFutureImpl.all(futures.toArray(new Future[0]));
    }*/

    /**
     * Return a composite future, succeeded when any futures is succeeded, failed when all futures are failed.
     * <p/>
     * The returned future succeeds as soon as one of {@code f1} or {@code f2} succeeds.
     *
     * @param f1 future
     * @param f2 future
     * @return the composite future
     * @deprecated instead use {@link Future#any(Future, Future)}
     */
    /*@Deprecated
    static <T1, T2> CompositeFuture any(Future<T1> f1, Future<T2> f2) {
        return CompositeFutureImpl.any(f1, f2);
    }*/

    /**
     * Like {@link #any(Future, Future)} but with 3 futures.
     * @deprecated instead use {@link Future#any(Future, Future, Future)}
     */
    /*@Deprecated
    static <T1, T2, T3> CompositeFuture any(Future<T1> f1, Future<T2> f2, Future<T3> f3) {
        return CompositeFutureImpl.any(f1, f2, f3);
    }*/

    /**
     * Like {@link #any(Future, Future)} but with 4 futures.
     * @deprecated instead use {@link Future#any(Future, Future, Future, Future)}
     */
    /*@Deprecated
    static <T1, T2, T3, T4> CompositeFuture any(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4) {
        return CompositeFutureImpl.any(f1, f2, f3, f4);
    }*/

    /**
     * Like {@link #any(Future, Future)} but with 5 futures.
     * @deprecated instead use {@link Future#any(Future, Future, Future, Future, Future)}
     */
    /*@Deprecated
    static <T1, T2, T3, T4, T5> CompositeFuture any(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4, Future<T5> f5) {
        return CompositeFutureImpl.any(f1, f2, f3, f4, f5);
    }*/

    /**
     * Like {@link #any(Future, Future)} but with 6 futures.
     * @deprecated instead use {@link Future#any(Future, Future, Future, Future, Future, Future)}
     */
    /*@Deprecated
    static <T1, T2, T3, T4, T5, T6> CompositeFuture any(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4, Future<T5> f5, Future<T6> f6) {
        return CompositeFutureImpl.any(f1, f2, f3, f4, f5, f6);
    }*/

    /**
     * Like {@link #any(Future, Future)} but with a list of futures.<p>
     *
     * When the list is empty, the returned future will be already completed.
     * @deprecated instead use {@link Future#any(List)}
     */
    /*@Deprecated
    static CompositeFuture any(List<Future> futures) {
        return CompositeFutureImpl.any(futures.toArray(new Future[0]));
    }*/

    /**
     * Return a composite future, succeeded when all futures are succeeded, failed when any future is failed.
     * <p/>
     * It always wait until all its futures are completed and will not fail as soon as one of {@code f1} or {@code f2} fails.
     *
     * @param f1 future
     * @param f2 future
     * @return the composite future
     * @deprecated instead use {@link Future#join(Future, Future)}
     */
    /*@Deprecated
    static <T1, T2> CompositeFuture join(Future<T1> f1, Future<T2> f2) {
        return CompositeFutureImpl.join(f1, f2);
    }*/

    /**
     * Like {@link #join(Future, Future)} but with 3 futures.
     * @deprecated instead use {@link Future#join(Future, Future, Future)}
     */
    /*@Deprecated
    static <T1, T2, T3> CompositeFuture join(Future<T1> f1, Future<T2> f2, Future<T3> f3) {
        return CompositeFutureImpl.join(f1, f2, f3);
    }*/

    /**
     * Like {@link #join(Future, Future)} but with 4 futures.
     * @deprecated instead use {@link Future#join(Future, Future, Future, Future)}
     */
    /*@Deprecated
    static <T1, T2, T3, T4> CompositeFuture join(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4) {
        return CompositeFutureImpl.join(f1, f2, f3, f4);
    }*/

    /**
     * Like {@link #join(Future, Future)} but with 5 futures.
     * @deprecated instead use {@link Future#join(Future, Future, Future, Future, Future)}
     */
    /*@Deprecated
    static <T1, T2, T3, T4, T5> CompositeFuture join(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4, Future<T5> f5) {
        return CompositeFutureImpl.join(f1, f2, f3, f4, f5);
    }*/

    /**
     * Like {@link #join(Future, Future)} but with 6 futures.
     * @deprecated instead use {@link Future#join(Future, Future, Future, Future, Future, Future)}
     */
    /*@Deprecated
    static <T1, T2, T3, T4, T5, T6> CompositeFuture join(Future<T1> f1, Future<T2> f2, Future<T3> f3, Future<T4> f4, Future<T5> f5, Future<T6> f6) {
        return CompositeFutureImpl.join(f1, f2, f3, f4, f5, f6);
    }*/

    /**
     * Like {@link #join(Future, Future)} but with a list of futures.<p>
     *
     * When the list is empty, the returned future will be already completed.
     * @deprecated instead use {@link Future#join(List)}
     */
    /*@Deprecated
    static CompositeFuture join(List<Future> futures) {
        return CompositeFutureImpl.join(futures.toArray(new Future[0]));
    }*/

    @Override
    CompositeFuture onComplete(Handler<AsyncResult<CompositeFuture>> handler);

    @Override
    default CompositeFuture onSuccess(Handler<CompositeFuture> handler) {
        Future.super.onSuccess(handler);
        return this;
    }

    @Override
    default CompositeFuture onFailure(Handler<Throwable> handler) {
        Future.super.onFailure(handler);
        return this;
    }

    /**
     * Returns a cause of a wrapped future
     *
     * @param index the wrapped future index
     */
    Throwable cause(int index);

    /**
     * Returns true if a wrapped future is succeeded
     *
     * @param index the wrapped future index
     */
    boolean succeeded(int index);

    /**
     * Returns true if a wrapped future is failed
     *
     * @param index the wrapped future index
     */
    boolean failed(int index);

    /**
     * Returns true if a wrapped future is completed
     *
     * @param index the wrapped future index
     */
    boolean isComplete(int index);

    /**
     * Returns the result of a wrapped future
     *
     * @param index the wrapped future index
     */
    <T> T resultAt(int index);

    /**
     * @return the number of wrapped future
     */
    int size();

    /**
     * @return a list of the current completed values. If one future is not yet resolved or is failed, {@code} null
     *         will be used
     */
    //@GenIgnore
    default <T> List<T> list() {
        int size = size();
        ArrayList<T> list = new ArrayList<>(size);
        for (int index = 0;index < size;index++) {
            list.add(resultAt(index));
        }
        return list;
    }

    /**
     * @return a list of all the eventual failure causes. If no future failed, returns a list of null values.
     */
    //@GenIgnore
    default List<Throwable> causes() {
        int size = size();
        ArrayList<Throwable> list = new ArrayList<>(size);
        for (int index = 0; index < size; index++) {
            list.add(cause(index));
        }
        return list;
    }
}

