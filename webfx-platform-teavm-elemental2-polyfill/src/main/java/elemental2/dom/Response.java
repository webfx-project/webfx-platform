package elemental2.dom;

import elemental2.promise.Promise;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

/**
 * @author Bruno Salmon
 */
public interface Response extends JSObject {

    @JSProperty
    boolean isOk();

    @JSProperty
    String getStatusText();

    Promise<String> text();

}
