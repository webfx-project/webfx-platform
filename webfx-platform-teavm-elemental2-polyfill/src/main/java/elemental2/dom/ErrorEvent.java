package elemental2.dom;

import org.teavm.jso.JSClass;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class ErrorEvent {
    public int colno;
    public Object error;
    public String filename;
    public int lineno;
    public String message;

    /*public ErrorEvent(String type, ErrorEventInit eventInitDict) {
        // This super call is here only for the code to compile; it is never executed.
        super((String) null, (EventInit) null);
    }

    public ErrorEvent(String type) {
        // This super call is here only for the code to compile; it is never executed.
        super((String) null, (EventInit) null);
    }*/

}
