package elemental2.dom;

import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
public interface Navigator extends JSObject {

    String userAgent = ""; // dummy value

    String platform = ""; // dummy value

    int hardwareConcurrency = 0; // dummy value

}
