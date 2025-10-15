package elemental2.dom;

import org.teavm.jso.JSBody;

public class DomGlobal {
    
    // Static field that returns the browser's console
    public static final Console console = getConsole();
    
    @JSBody(script = "return console;")
    private static native Console getConsole();

    public static final Window window = getWindow();

    @JSBody(script = "return window;")
    private static native Window getWindow();

    public static final Navigator navigator = getNavigator();

    @JSBody(script = "return navigator;")
    private static native Navigator getNavigator();

    public static final HTMLDocument document = getDocument();

    @JSBody(script = "return document;")
    private static native HTMLDocument getDocument();

}
