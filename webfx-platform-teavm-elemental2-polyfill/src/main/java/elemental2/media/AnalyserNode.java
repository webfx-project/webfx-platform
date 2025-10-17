package elemental2.media;

import elemental2.core.Uint8Array;
import org.teavm.jso.JSClass;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class AnalyserNode extends AudioNode {

    public native Object getByteFrequencyData(Uint8Array array);

    public native Object getByteTimeDomainData(Uint8Array array);

}
