package elemental2.media;

import elemental2.dom.EventTarget;
import org.teavm.jso.JSClass;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class AudioNode implements EventTarget {

    public native AudioNode connect(AudioNode destination);

}
