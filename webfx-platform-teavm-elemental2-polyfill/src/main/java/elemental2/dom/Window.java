package elemental2.dom;

import elemental2.promise.Promise;
import org.teavm.jso.JSMethod;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

/**
 * @author Bruno Salmon
 */
public abstract class Window implements JSObject, WindowEventTarget {

    @JSProperty
    public abstract History getHistory();

    @JSProperty
    public abstract Window getOpener();

    @JSMethod
    public abstract Promise<Response> fetch(String input);

    public abstract void close();

}
