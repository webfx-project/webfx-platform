package elemental2.dom;

import org.teavm.jso.JSClass;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
@JSClass
public class TextMetrics implements JSObject {
    public double actualBoundingBoxAscent;
    public double actualBoundingBoxDescent;
    public double actualBoundingBoxLeft;
    public double actualBoundingBoxRight;
    public double alphabeticBaseline;
    public double emHeightAscent;
    public double emHeightDescent;
    public double fontBoundingBoxAscent;
    public double fontBoundingBoxDescent;
    public double hangingBaseline;
    public double ideographicBaseline;
    public double width;
}