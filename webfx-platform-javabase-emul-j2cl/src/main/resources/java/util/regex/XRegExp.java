package java.util.regex;

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author Bruno Salmon
 */

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "XRegExp")
public class XRegExp {

    @JsConstructor
    public XRegExp(String regExp) { }

    public static native Object exec(String input, XRegExp xRegExp, int pos);

}
