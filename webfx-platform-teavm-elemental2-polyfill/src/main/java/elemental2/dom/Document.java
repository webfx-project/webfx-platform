package elemental2.dom;

import org.teavm.jso.JSClass;

/**
 * @author Bruno Salmon
 */
@JSClass
public abstract class Document extends Node {

    public FontFaceSet fonts;

    public native Element createElement(String tagName);

    public native Element createElementNS(String namespaceURI, String qualifiedName);

    public native Element elementFromPoint(double x, double y);

    public native NodeList<Element> getElementsByTagName(String tagname);

    public native void exitFullscreen();

}
