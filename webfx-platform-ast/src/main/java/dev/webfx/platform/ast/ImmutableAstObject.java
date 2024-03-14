package dev.webfx.platform.ast;

/**
 * @author Bruno Salmon
 */
public final class ImmutableAstObject extends ReadOnlyAstObjectWrapper {

    public ImmutableAstObject(ReadOnlyAstObject wrappedObject) {
        super(wrappedObject);
    }

}
