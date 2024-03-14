package dev.webfx.platform.ast.spi.factory.impl.gwt;

import com.google.gwt.core.client.JavaScriptObject;
import dev.webfx.platform.ast.AST;
import dev.webfx.platform.ast.AstNode;
import dev.webfx.platform.ast.spi.factory.nativeast.AstType;

/**
 * @author Bruno Salmon
 */
public abstract class GwtAstNode extends JavaScriptObject implements AstNode {

    // GWT: Constructors must be 'protected' in subclasses of JavaScriptObject
    protected GwtAstNode() { } // instances are actually always obtained from a javascript object cast

    /**
     * Return true if it is an array.
     */
    public final boolean isArray() { return AST.NATIVE_FACTORY.getNativeElementAstType(AST.NATIVE_FACTORY.nativeToAstArray(this)) == AstType.ARRAY; }

    /**
     * Return true if it is an object.
     */
    public final boolean isObject() {return AST.NATIVE_FACTORY.getNativeElementAstType(AST.NATIVE_FACTORY.nativeToAstObject(this)) == AstType.OBJECT; }


}
