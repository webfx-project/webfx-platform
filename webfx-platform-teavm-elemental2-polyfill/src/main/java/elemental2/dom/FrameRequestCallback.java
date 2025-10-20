package elemental2.dom;

import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
@JSFunctor
public interface FrameRequestCallback extends JSObject {

    void onInvoke(double timestamp);

}
