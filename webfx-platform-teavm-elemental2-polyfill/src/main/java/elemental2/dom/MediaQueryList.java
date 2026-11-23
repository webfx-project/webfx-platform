package elemental2.dom;

import org.teavm.jso.JSClass;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class MediaQueryList implements JSObject {

    public boolean matches;

    public String media;

}
