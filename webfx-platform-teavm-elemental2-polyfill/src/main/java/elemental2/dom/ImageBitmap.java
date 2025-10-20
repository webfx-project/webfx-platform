package elemental2.dom;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

/**
 * @author Bruno Salmon
 */
public interface ImageBitmap extends JSObject {
    void close();

    @JSProperty
    int getHeight();

    @JSProperty
    int getWidth();
}