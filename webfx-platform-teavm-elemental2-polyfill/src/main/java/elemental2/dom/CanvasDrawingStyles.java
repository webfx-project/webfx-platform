package elemental2.dom;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

/**
 * @author Bruno Salmon
 */
public interface CanvasDrawingStyles extends JSObject {
    @JSProperty
    String getFont();

    @JSProperty
    String getLetterSpacing();

    @JSProperty
    String getLineCap();

    //JsArray<Double> getLineDash();

    @JSProperty
    String getLineJoin();

    @JSProperty
    double getLineWidth();

    @JSProperty
    double getMiterLimit();

    @JSProperty
    String getTextAlign();

    @JSProperty
    String getTextBaseline();

    @JSProperty
    void setFont(String font);

    @JSProperty
    void setLetterSpacing(String letterSpacing);

    @JSProperty
    void setLineCap(String lineCap);

    //void setLineDash(JsArray<Double> segments);

    /*@JsOverlay
    default void setLineDash(double[] segments) {
        setLineDash(Js.<JsArray<Double>>uncheckedCast(segments));
    }*/

    @JSProperty
    void setLineJoin(String lineJoin);

    @JSProperty
    void setLineWidth(double lineWidth);

    @JSProperty
    void setMiterLimit(double miterLimit);

    @JSProperty
    void setTextAlign(String textAlign);

    @JSProperty
    void setTextBaseline(String textBaseline);

}