package elemental2.dom;

import elemental2.core.JsArray;
import elemental2.core.Transferable;
import jsinterop.base.Js;
import org.teavm.jso.JSClass;
import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class Worker implements EventTarget {
    
    public interface ConstructorScriptURLUnionType extends JSObject {
        static Worker.ConstructorScriptURLUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    @JSFunctor
    public interface OnerrorFn extends JSObject {
        void onInvoke(ErrorEvent p0);
    }

    @JSFunctor
    public interface OnmessageFn extends JSObject {
        void onInvoke(MessageEvent<Object> p0);
    }

    public interface PostMessageTransferOrOptionsUnionType extends JSObject {
        static Worker.PostMessageTransferOrOptionsUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public interface WebkitPostMessageTransferOrOptionsUnionType extends JSObject {
        static Worker.WebkitPostMessageTransferOrOptionsUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    public Worker.OnerrorFn onerror;
    public Worker.OnmessageFn onmessage;

    //public Worker(Worker.ConstructorScriptURLUnionType scriptURL, WorkerOptions options) {}

    public Worker(Worker.ConstructorScriptURLUnionType scriptURL) {}

    //public Worker(String scriptURL, WorkerOptions options) {}

    public Worker(String scriptURL) {}

    //public Worker(TrustedScriptURL scriptURL, WorkerOptions options) {}

    //public Worker(TrustedScriptURL scriptURL) {}

    //public Worker(URL scriptURL, WorkerOptions options) {}

    public Worker(URL scriptURL) {}

    /*public native void addEventListener(
        String type, EventListener listener, EventTarget.AddEventListenerOptionsUnionType options);*/

    public native void addEventListener(String type, EventListener listener);

    public native boolean dispatchEvent(Event evt);

    public final void postMessage(Object message, JsArray<Transferable> transferOrOptions) {
        postMessage(
            message, Js.<Worker.PostMessageTransferOrOptionsUnionType>uncheckedCast(transferOrOptions));
    }

    public native void postMessage(
        Object message, Worker.PostMessageTransferOrOptionsUnionType transferOrOptions);

    /*public final void postMessage(Object message, StructuredSerializeOptions transferOrOptions) {
        postMessage(
            message, Js.<Worker.PostMessageTransferOrOptionsUnionType>uncheckedCast(transferOrOptions));
    }*/

    public final void postMessage(Object message, Transferable[] transferOrOptions) {
        postMessage(message, Js.<JsArray<Transferable>>uncheckedCast(transferOrOptions));
    }

    public native void postMessage(Object message);

    /*public native void removeEventListener(
        String type, EventListener listener, EventTarget.RemoveEventListenerOptionsUnionType options);*/

    public native void removeEventListener(String type, EventListener listener);

    public native void terminate();

    public final void webkitPostMessage(Object message, JsArray<Transferable> transferOrOptions) {
        webkitPostMessage(
            message,
            Js.<Worker.WebkitPostMessageTransferOrOptionsUnionType>uncheckedCast(transferOrOptions));
    }

    /*public final void webkitPostMessage(
        Object message, StructuredSerializeOptions transferOrOptions) {
        webkitPostMessage(
            message,
            Js.<Worker.WebkitPostMessageTransferOrOptionsUnionType>uncheckedCast(transferOrOptions));
    }*/

    public final void webkitPostMessage(Object message, Transferable[] transferOrOptions) {
        webkitPostMessage(message, Js.<JsArray<Transferable>>uncheckedCast(transferOrOptions));
    }

    public native void webkitPostMessage(
        Object message, Worker.WebkitPostMessageTransferOrOptionsUnionType transferOrOptions);

    public native void webkitPostMessage(Object message);

}
