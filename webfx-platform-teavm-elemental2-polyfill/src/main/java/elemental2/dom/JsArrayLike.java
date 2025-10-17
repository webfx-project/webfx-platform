package elemental2.dom;

import jsinterop.base.Js;
import org.teavm.jso.JSObject;

import java.util.Arrays;
import java.util.List;

/**
 * @author Bruno Salmon
 */
public interface JsArrayLike<T> extends JSObject {

    T getAt(int index);

    default List<T> asList() {
        // Since it is hidden behind Arrays.asList, it is safe to do uncheckedCast.
        T[] asArray = Js.uncheckedCast(this);
        return Arrays.asList(asArray);
    }

}