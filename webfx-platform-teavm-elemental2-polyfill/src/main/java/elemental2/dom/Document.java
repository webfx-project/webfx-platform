package elemental2.dom;

/**
 * @author Bruno Salmon
 */
public abstract class Document extends Node {

    public FontFaceSet fonts;

    public native Element createElement(String tagName);

    public native Element createElementNS(String namespaceURI, String qualifiedName);

    public native Element elementFromPoint(double x, double y);

    public native NodeList<Element> getElementsByTagName(String tagname);

}
