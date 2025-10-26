package elemental2.dom;

import org.teavm.jso.JSClass;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class HTMLElement extends Element {

    public native void setAttribute(String name, String value);

    public native Node appendChild(Node node);

}
