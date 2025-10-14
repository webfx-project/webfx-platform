package elemental2.dom;

import elemental2.promise.Promise;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
public abstract class Window implements JSObject, WindowEventTarget {

    public History history;

    public Window opener;

    public abstract Window open(String url);

    public abstract Promise<Response> fetch(String url);

    public abstract Promise<Response> fetch(String url, RequestInit requestInit);

    public abstract void close();

}
