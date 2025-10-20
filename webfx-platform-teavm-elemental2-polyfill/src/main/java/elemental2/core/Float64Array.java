package elemental2.core;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSByRef;
import org.teavm.jso.JSClass;

/**
 * @author Bruno Salmon
 */
@JSClass
public class Float64Array extends TypedArray {

    public Float64Array(double[] length) {}

    @JSBody(params = "array", script = "return array;")
    public static native Float64Array fromJavaArray(@JSByRef double[] array);

}
