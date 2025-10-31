package elemental2.media;

import elemental2.core.ArrayBuffer;
import elemental2.dom.EventTarget;
import elemental2.promise.Promise;
import org.teavm.jso.JSClass;
import org.teavm.jso.JSMethod;
import org.teavm.jso.core.JSUndefined;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class BaseAudioContext implements EventTarget {

    public AudioDestinationNode destination;

    public native AudioBufferSourceNode createBufferSource();

    public native GainNode createGain();

    public native AnalyserNode createAnalyser();

    public Promise<Void> resume() {
        // Elemental2 is mixing JS Promise with Java Void, which doesn't work with TeaVM, so here is the fix:
        return resumeImpl().then(ignored -> null);
    }

    @JSMethod("resume")
    public native Promise<JSUndefined> resumeImpl();

    public native Promise<AudioBuffer> decodeAudioData(ArrayBuffer audioData);

}
