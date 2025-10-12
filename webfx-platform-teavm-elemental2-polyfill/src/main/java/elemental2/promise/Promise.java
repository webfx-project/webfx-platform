package elemental2.promise;

import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSMethod;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
public interface Promise<T> extends JSObject, IThenable<T> {

    @JSFunctor
    interface CatchOnRejectedCallbackFn<V> extends JSObject {
        IThenable<V> onInvoke(Object error);
    }

    @JSMethod("catch")
    <V> Promise<V> catch_(CatchOnRejectedCallbackFn<? extends V> onRejected);

    @Override
    @JSMethod
    <V> Promise<V> then(
        ThenOnFulfilledCallbackFn<? super T, ? extends V> onFulfilled,
        ThenOnRejectedCallbackFn<? extends V> onRejected);

    @Override
    @JSMethod
    <V> Promise<V> then(ThenOnFulfilledCallbackFn<? super T, ? extends V> onFulfilled);

}
