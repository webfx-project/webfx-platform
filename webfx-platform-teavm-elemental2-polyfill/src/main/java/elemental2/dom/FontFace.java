package elemental2.dom;

import elemental2.promise.Promise;
import org.teavm.jso.JSClass;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
@JSClass
public class FontFace implements JSObject {

    public FontFace(String fontFamily, String source) {}

    public native Promise<FontFace> load();

}
