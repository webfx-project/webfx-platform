package elemental2.dom;

import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
public interface Event extends JSObject {

    void stopPropagation();

    void preventDefault();

    void initEvent(String eventTypeArg, boolean canBubbleArg, boolean cancelableArg);
}
