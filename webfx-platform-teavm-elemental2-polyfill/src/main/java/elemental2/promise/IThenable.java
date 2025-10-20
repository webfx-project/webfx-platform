package elemental2.promise;


import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
public interface IThenable<T> extends JSObject {

    @JSFunctor
    interface ThenOnFulfilledCallbackFn<T, V> extends JSObject {
        IThenable<V> onInvoke(T p0);
    }

    @JSFunctor
    interface ThenOnRejectedCallbackFn<V> extends JSObject {
        IThenable<V> onInvoke(Object p0);
    }

    <V> IThenable<V> then(ThenOnFulfilledCallbackFn<? super T, ? extends V> onFulfilled);

    <V> IThenable<V> then(
        ThenOnFulfilledCallbackFn<? super T, ? extends V> onFulfilled,
        ThenOnRejectedCallbackFn<? extends V> onRejected);
}