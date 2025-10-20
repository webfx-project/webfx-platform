package elemental2.dom;

/**
 * @author Bruno Salmon
 */
public interface NodeList<T> extends JsIterable<T>, JsArrayLike<T> {

    T item(int index);

}
