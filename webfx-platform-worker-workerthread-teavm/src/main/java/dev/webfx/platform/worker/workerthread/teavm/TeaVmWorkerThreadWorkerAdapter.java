package dev.webfx.platform.worker.workerthread.teavm;

import dev.webfx.platform.worker.workerthread.ApplicationWorkerThreadWorkerBase;
import dev.webfx.platform.worker.workerthread.PlatformWorkerThreadWorkerAdapter;
import org.teavm.interop.Import;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;
import org.teavm.jso.core.JSArray;
import org.teavm.jso.core.JSNumber;
import org.teavm.jso.dom.events.EventListener;
import org.teavm.jso.dom.events.MessageEvent;
import org.teavm.jso.impl.JSWrapper;

import java.util.function.Consumer;

/**
 * @author Bruno Salmon
 */
public final class TeaVmWorkerThreadWorkerAdapter implements PlatformWorkerThreadWorkerAdapter {

    public static void executeApplicationWorkerThreadWorker(ApplicationWorkerThreadWorkerBase applicationWorker) {
        applicationWorker.setPlatformAdapter(new TeaVmWorkerThreadWorkerAdapter());
        applicationWorker.onLoaded();
    }

    @Override
    public void log(String message) {
        native_log(message);
    }

    @Override
    public void log(Object object) {
        native_log((JSObject) object);
    }

    @Override
    public void postMessage(Object msg) {
        native_postMessage(JSWrapper.unwrap(msg));
    }

    @Override
    public Object toNativeArray(byte[] byteArray) {
        int n = byteArray.length;
        JSArray<?> jsArray = new JSArray<>();
        for (int i = 0; i < n; ++i)
            native_setByteArray(jsArray, i, byteArray[i]);
        return jsArray;
    }

    @Override
    public Object toNativeArray(int[] intArray) {
        int n = intArray.length;
        JSArray<?> jsArray = new JSArray<>();
        for (int i = 0; i < n; ++i)
            native_setIntArray(jsArray, i, intArray[i]);
        return jsArray;
    }

    @Override
    public Object toNativeArray(double[] doubleArray) {
        int n = doubleArray.length;
        JSArray<?> jsArray = new JSArray<>();
        for (int i = 0; i < n; ++i)
            native_setDoubleArray(jsArray, i, doubleArray[i]);
        return jsArray;
    }

    @Override
    public int getAstInt(Object nativeObject, String key) {
        return (int) getAstDouble(nativeObject, key);
    }

    @Override
    public double getAstDouble(Object nativeObject, String key) {
        return js2Double(getJSValue((JSObject) nativeObject, key));
    }

    @JSBody(params = {"jso", "key"}, script = "return jso[key] || null;")
    static native JSObject getJSValue(JSObject jso, String key);

    static double js2Double(JSObject jsv) {
        return jsv == null || isUndefined(jsv) ? 0 : ((JSNumber) jsv).doubleValue();
    }

    @JSBody(params = "object", script = "return typeof object === 'undefined';")
    static native boolean isUndefined(JSObject object);

    @JSBody(params={"jsArray", "index", "value"}, script="jsArray[index] = value")
    @Import(name = "setByteArray")
    private static native void native_setByteArray(JSArray<?> jsArray, int index, byte value);

    @JSBody(params={"jsArray", "index", "value"}, script="jsArray[index] = value")
    @Import(name = "setIntArray")
    private static native void native_setIntArray(JSArray<?> jsArray, int index, int value);

    @JSBody(params={"jsArray", "index", "value"}, script="jsArray[index] = value")
    @Import(name = "setDoubleArray")
    private static native void native_setDoubleArray(JSArray<?> jsArray, int index, double value);

    @Override
    public void setOnMessageHandler(Consumer<Object> onMessageHandler) {
        native_setOnMessageHandler(evt -> onMessageHandler.accept(evt.getData()));
    }

    @Override
    public void terminate() {
    }

    @JSBody(params={"handler"}, script="self.onmessage=handler")
    @Import(name = "setOnMessageHandler")
    public static native void native_setOnMessageHandler(EventListener<MessageEvent> handler);

    @JSBody(params={"msg"}, script="self.postMessage(msg)")
    @Import(name = "postMessageObject")
    private static native void native_postMessage(JSObject message);

    @JSBody(params={"msg","param"}, script="self.postMessage(msg,param)")
    @Import(name = "postMessageObjectWithParam")
    private static native void native_postMessage(JSObject message, JSObject param);

    @JSBody(params={"msg"}, script="self.postMessage(msg)")
    @Import(name = "postMessageString")
    private static native void native_postMessage(String message);

    @JSBody(params={"msg"}, script="console.log(msg)")
    @Import(name = "logString")
    private static native void native_log(String msg);

    @JSBody(params={"js"}, script="console.log(js)")
    @Import(name = "logJs")
    private static native void native_log(JSObject js);

}
