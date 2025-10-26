package elemental2.dom;

import org.teavm.jso.JSClass;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class Node implements EventTarget {

    public native Node appendChild(Node newChild);

    public native Node removeChild(Node oldChild);

    public native Node insertBefore(Node newChild, Node refChild);

    public native Node replaceChild(Node newChild, Node oldChild);

    public native boolean contains(Node n);

    public native void append(Node... nodes);

    public native void removeEventListener(String type, EventListener listener);

}
