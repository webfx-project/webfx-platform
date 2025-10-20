package elemental2.dom;

import jsinterop.base.JsPropertyMap;

/**
 * @author Bruno Salmon
 */
public interface CSSStyleDeclaration extends CSSProperties
    , JsIterable<String>, JsArrayLike<String>, JsPropertyMap<String> {

    void setProperty(String propertyName, String value);

    String removeProperty(String propertyName);

}
