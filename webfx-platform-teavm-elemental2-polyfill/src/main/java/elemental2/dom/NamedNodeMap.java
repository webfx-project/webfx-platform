package elemental2.dom;

import jsinterop.base.JsPropertyMap;

/**
 * @author Bruno Salmon
 */
public class NamedNodeMap<T> implements JsIterable<T>, JsArrayLike<T>, JsPropertyMap<T> {
    public int length;

    public native Node getNamedItem(String name);

    public native Node item(int index);

    public native Node removeNamedItem(String name);

    public native Node setNamedItem(Node arg);
}
