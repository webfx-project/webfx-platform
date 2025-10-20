package elemental2.dom;

import dev.webfx.platform.util.teavm.TeaVmUtil;
import jsinterop.base.Js;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

import java.util.Arrays;
import java.util.List;

/**
 * @author Bruno Salmon
 */
public interface JsArrayLike<T> extends JSObject {

    default List<T> asList() {
        // Since it is hidden behind Arrays.asList, it is safe to do uncheckedCast.
        T[] asArray = Js.uncheckedCast(this);
        return Arrays.asList(asArray);
    }

    default void setAt(int index, T value) {
        TeaVmUtil.setAt(this, index, TeaVmUtil.javaToJs(value));
    }

    default T getAt(int index) {
        return (T) TeaVmUtil.jsToJava(TeaVmUtil.getAt(this, index));
    }

    @JSProperty
    default int getLength() {
        return 0;
    }


}