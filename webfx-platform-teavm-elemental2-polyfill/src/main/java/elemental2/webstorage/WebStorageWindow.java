package elemental2.webstorage;

import elemental2.dom.Window;
import org.teavm.jso.JSBody;

/**
 * @author Bruno Salmon
 */
public abstract class WebStorageWindow extends Window {

    public Storage localStorage;
    public Storage sessionStorage;

    @JSBody(params = {"o"}, script = "return o")
    public static native WebStorageWindow of(Window o);
}
