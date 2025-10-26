package elemental2.dom;

import org.teavm.jso.JSClass;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class DOMTokenList implements JsArrayLike<String> {
    public int length;
    public String value;

    public native void add(String... var_args);

    public native boolean contains(String token);

    public native void remove(String... var_args);

}
