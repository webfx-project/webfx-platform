package elemental2.dom;

import org.teavm.jso.JSClass;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class HTMLTableSectionElement extends HTMLElement {
    public String align;
    public String ch;
    public String chOff;
    public HTMLCollection<HTMLTableRowElement> rows;
    public String vAlign;

    public native HTMLElement deleteRow(int index);

    public native HTMLElement insertRow();

    public native HTMLElement insertRow(int index);
}