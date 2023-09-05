package dev.webfx.platform.ast.json;

import dev.webfx.platform.ast.json.spi.JsonProvider;
import dev.webfx.platform.ast.ReadOnlyAstNode;

/**
 * @author Bruno Salmon
 */
public interface ReadOnlyJsonElement extends JsonProvider, ReadOnlyAstNode {

    Object getNativeElement();

    /**
     * Return true if it is an array.
     */
    default boolean isArray() { return getNativeElementType(getNativeElement()) == ElementType.ARRAY; }

    /**
     * Return true if it is an object.
     */
    default boolean isObject() {return getNativeElementType(getNativeElement()) == ElementType.OBJECT; }

    /**
     * Length of the array or number of keys of the object
     */
    //int size();

    default ReadOnlyJsonObject asJsonObject() {
        return (ReadOnlyJsonObject) this;
    }

    default ReadOnlyJsonArray asJsonArray() {
        return (ReadOnlyJsonArray) this;
    }


    /**
     * Make a copy of this object or array.
     */
    default <SC extends ReadOnlyJsonElement> SC copy() {
        return isArray() ? (SC) parseArray(toJsonString()) : (SC) parseObject(toJsonString());
    }

}
