package elemental2.dom;

/**
 * @author Bruno Salmon
 */
public abstract class HTMLDocument implements Document {

    public String visibilityState;

    public native Text createTextNode(String data);
}
