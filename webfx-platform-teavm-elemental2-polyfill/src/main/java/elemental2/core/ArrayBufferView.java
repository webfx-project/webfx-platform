package elemental2.core;

import org.teavm.jso.JSClass;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
@JSClass
public class ArrayBufferView implements JSObject {
    public ArrayBuffer buffer;
    public int byteLength;
    public int byteOffset;
}
