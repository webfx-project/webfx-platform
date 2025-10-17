package elemental2.media;

import elemental2.dom.EventTarget;

/**
 * @author Bruno Salmon
 */
public abstract class AudioNode implements EventTarget {

    public native AudioNode connect(AudioNode destination);

}
