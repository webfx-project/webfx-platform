package elemental2.media;

import elemental2.core.ArrayBuffer;
import elemental2.dom.EventTarget;
import elemental2.promise.Promise;
import org.teavm.jso.JSClass;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class BaseAudioContext implements EventTarget {

    public AudioDestinationNode destination;

    public native AudioBufferSourceNode createBufferSource();

    public native GainNode createGain();

    public native AnalyserNode createAnalyser();

    public native Promise<Void> resume();

    public native Promise<AudioBuffer> decodeAudioData(ArrayBuffer audioData);

}
