package elemental2.dom;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

public class DomGlobal {
    
    // Static field that returns the browser's console
    public static final Console console = getConsole();
    
    @JSBody(script = "return console;")
    private static native Console getConsole();

    public static final Window window = getWindow();

    @JSBody(script = "return window;")
    private static native Window getWindow();

    public static final Navigator navigator = getNavigator();

    @JSBody(script = "return navigator;")
    private static native Navigator getNavigator();

    public static final HTMLDocument document = getDocument();

    @JSBody(script = "return document;")
    private static native HTMLDocument getDocument();

    public static final Screen screen = getScreen();

    @JSBody(script = "return screen;")
    private static native Screen getScreen();

    @JSBody(params = {"callback"}, script = "return requestAnimationFrame(callback);")
    public static native int requestAnimationFrame(FrameRequestCallback callback);

    @JSBody(params = {"handle"}, script = "return cancelAnimationFrame(handle);")
    public static native void cancelAnimationFrame(int handle);

    public static double setTimeout(DomGlobal.SetTimeoutCallbackFn callback, double... p1) {
        return setTimeout(callback, (int) p1[0]);
    }

    public static double setTimeout(DomGlobal.SetTimeoutCallbackFn callback, double delay, Object... args) {
        return setTimeout(callback, (int) delay);
    }

    @JSBody(params = {"callback", "delay"}, script = "return setTimeout(callback, delay);")
    public static native double setTimeout(DomGlobal.SetTimeoutCallbackFn callback, int delay);

    @JSBody(params = {"timerId"}, script = "clearTimeout(timerId);")
    public static native void clearTimeout(double timerId);

    @JSFunctor
    public interface SetTimeoutCallbackFn extends JSObject {
        void onInvoke(Object... p0);
    }
}
