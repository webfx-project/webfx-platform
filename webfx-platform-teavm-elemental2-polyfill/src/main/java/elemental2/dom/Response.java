package elemental2.dom;

import elemental2.promise.Promise;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
public interface Response extends JSObject {

    boolean ok = false; // dummy value

    String statusText = ""; // dummy value

    Promise<String> text();

}
