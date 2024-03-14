package dev.webfx.platform.ast.spi.factory.impl.teavm;


import dev.webfx.platform.ast.AstNode;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;
import org.teavm.jso.core.JSArray;
import org.teavm.jso.core.JSNumber;
import org.teavm.jso.core.JSString;

/*
 * @author Bruno Salmon
 */
abstract class TeaVmAstNode implements AstNode {

    protected final JSObject nativeElement; // As opposed to GWT, TeaVM needs the element to be embedded as a member field

    TeaVmAstNode(JSObject nativeElement) {
        this.nativeElement = nativeElement;
    }

    JSObject getNativeElement() {
        return nativeElement;
    }


    /** Static JS utility methods **/

    @JSBody(params = {"jso", "key", "value"}, script = "jso[key] = value;")
    static native void setJSValue(JSObject jso, String key, JSObject value);

    @JSBody(params = {"jso", "key"}, script = "return jso[key] || null;")
    static native JSObject getJSValue(JSObject jso, String key);

    @JSBody(params = {"jso", "key"}, script = "delete jso[key];")
    static native JSObject deleteJSValue(JSObject jso, String key);

    @JSBody(params = {"jsa", "value"}, script = "return jsa.indexOf(value);")
    static native int indexOf(JSArray jsa, JSObject value);

    @JSBody(params = {"jso"}, script = "" +
            "    var keys = [];\n" +
            "    for(var key in jso) {\n" +
            "      if (Object.prototype.hasOwnProperty.call(jso, key) && key != '$H') {\n" +
            "        keys.push(key);\n" +
            "      }\n" +
            "    }\n" +
            "    return keys;")
    static native JSArray<JSString> getKeys(JSObject jso);

    @JSBody(params = {"jso", "key"}, script = "key in jso;")
    static native boolean has(JSObject jso, String key);

    @JSBody(params = {"jso"}, script = "" +
            "        for (var key in this)\n" +
            "            if (Object.prototype.hasOwnProperty.call(this, key))\n" +
            "                delete this[key];\n" +
            "        return this;")
    static native void clear(JSObject jso);


    @JSBody(params = "object", script = "return typeof object === 'undefined';")
    static native boolean isUndefined(JSObject object);

    static String js2String(JSObject jsv) {
        return jsv == null || isUndefined(jsv) ? null : ((JSString) jsv).stringValue();
    }

    static double js2Double(JSObject jsv) {
        return jsv == null || isUndefined(jsv) ? 0 : ((JSNumber) jsv).doubleValue();
    }

}
