package dev.webfx.platform.util.keyobject;

/**
 * @author Bruno Salmon
 */
public final class ImmutableKeyObject extends ReadOnlyKeyObjectWrapper {

    public ImmutableKeyObject(ReadOnlyKeyObject wrappedObject) {
        super(wrappedObject);
    }

}
