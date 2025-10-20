package elemental2.media;

import elemental2.dom.Event;
import org.teavm.jso.JSClass;
import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class AudioBufferSourceNode extends AudioNode {

    @JSFunctor
    public interface OnendedFn extends JSObject {
        void onInvoke(Event p0);
    }

    public native Object start();

    public native Object start(double when, double offset, double duration);

    public native Object start(double when, double offset);

    public native Object start(double when);

    public native Object stop();

    public native Object stop(double when);

}
