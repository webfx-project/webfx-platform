package elemental2.dom;

/**
 * @author Bruno Salmon
 */
public abstract class Node implements EventTarget {

    public native Node appendChild(Node newChild);

    public native Node removeChild(Node oldChild);

    public native Node insertBefore(Node newChild, Node refChild);

    public native boolean contains(Node n);

    public native void append(Node... nodes);

    public native void removeEventListener(String type, EventListener listener);

}
