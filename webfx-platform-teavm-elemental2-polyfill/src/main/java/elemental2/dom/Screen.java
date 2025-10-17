package elemental2.dom;

import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
public interface Screen extends JSObject {
    int availHeight = 0;
    int availWidth = 0;
    int colorDepth = 0;
    int height = 0;
    int pixelDepth = 0;
    int width = 0;
}