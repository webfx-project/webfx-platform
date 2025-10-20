package elemental2.media;

import elemental2.dom.HTMLMediaElement;
import org.teavm.jso.JSClass;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class AudioContext extends BaseAudioContext {

    public native MediaElementAudioSourceNode createMediaElementSource(HTMLMediaElement mediaElement);

}
