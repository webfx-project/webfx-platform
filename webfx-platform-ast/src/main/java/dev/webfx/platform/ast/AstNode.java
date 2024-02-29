package dev.webfx.platform.ast;

/**
 * @author Bruno Salmon
 */
public interface AstNode extends ReadOnlyAstNode {

    /**
     * Removes all entries.
     */
    void clear();

    /**
     * Removes the first instance of the given value from the list.
     *
     * @return Whether the item was removed.
     */
    //boolean removeValue(Object value);

    @Override
    default AstObject asObject() {
        return (AstObject) this;
    }

    @Override
    default AstArray asArray() {
        return (AstArray) this;
    }


}
