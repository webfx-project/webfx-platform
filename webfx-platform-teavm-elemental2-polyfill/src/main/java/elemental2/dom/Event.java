package elemental2.dom;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

/**
 * @author Bruno Salmon
 */
public interface Event extends JSObject {
    short CAPTURING_PHASE = 1;
    short AT_TARGET = 2;
    short BUBBLING_PHASE = 3;

    @JSProperty
    String getType();

    @JSProperty
    EventTarget getTarget();

    @JSProperty
    EventTarget getCurrentTarget();

    @JSProperty
    short getEventPhase();

    @JSProperty
    boolean isBubbles();

    @JSProperty
    boolean isCancelable();

    @JSProperty
    JSObject getTimeStamp();

    void stopPropagation();

    void preventDefault();

    void initEvent(String eventTypeArg, boolean canBubbleArg, boolean cancelableArg);
}
