package elemental2.core;

import dev.webfx.platform.util.teavm.TeaVmUtil;
import elemental2.dom.DomGlobal;

/**
 * @author Bruno Salmon
 */
public class Global {

    public static final JSONType JSON = (JSONType) TeaVmUtil.getJSObject(DomGlobal.window, "JSON");



}
