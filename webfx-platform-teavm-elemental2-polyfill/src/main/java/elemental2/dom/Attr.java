package elemental2.dom;

import org.teavm.jso.JSClass;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class Attr extends Node {
    public boolean isId;
    public String name;
    public Element ownerElement;
    public boolean specified;
    public String value;
}
