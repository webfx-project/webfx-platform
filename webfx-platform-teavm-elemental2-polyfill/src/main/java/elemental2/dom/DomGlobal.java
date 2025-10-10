package elemental2.dom;

import org.teavm.jso.JSBody;

public class DomGlobal {
    
    // Static field that returns the browser's console
    public static final Console console = getConsole();
    
    @JSBody(script = "return console;")
    private static native Console getConsole();
    
}
