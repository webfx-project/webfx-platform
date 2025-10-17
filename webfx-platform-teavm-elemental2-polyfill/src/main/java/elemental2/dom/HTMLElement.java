package elemental2.dom;

/**
 * @author Bruno Salmon
 */
public abstract class HTMLElement extends Element {

    public native void setAttribute(String name, String value);

    public native Node appendChild(Node node);

}
