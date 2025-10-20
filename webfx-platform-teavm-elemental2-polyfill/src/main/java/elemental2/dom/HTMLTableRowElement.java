package elemental2.dom;

/**
 * @author Bruno Salmon
 */
public abstract class HTMLTableRowElement extends HTMLElement {
    public String align;
    public String bgColor;
    public HTMLCollection<HTMLTableCellElement> cells;
    public String ch;
    public String chOff;
    public int rowIndex;
    public int sectionRowIndex;
    public String vAlign;

    public native void deleteCell(int index);

    public native HTMLElement insertCell(int index);
}
