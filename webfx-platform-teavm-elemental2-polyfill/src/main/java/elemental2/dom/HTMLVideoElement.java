package elemental2.dom;

import org.teavm.jso.JSClass;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class HTMLVideoElement extends HTMLMediaElement {
    public int height;
    public String poster;
    public int videoHeight;
    public int videoWidth;
    public int webkitDecodedFrameCount;
    public boolean webkitDisplayingFullscreen;
    public int webkitDroppedFrameCount;
    public boolean webkitSupportsFullscreen;
    public int width;
}
