package elemental2.dom;

import org.teavm.jso.JSClass;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class HTMLDocument extends Document {

    public String visibilityState;

    public native Text createTextNode(String data);
}
