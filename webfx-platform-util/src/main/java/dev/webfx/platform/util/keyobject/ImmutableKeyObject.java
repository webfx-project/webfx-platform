package dev.webfx.platform.util.keyobject;

/**
 * @author Bruno Salmon
 */
public final class ImmutableKeyObject extends ReadOnlyDelegatedKeyObject {

    public ImmutableKeyObject(ReadOnlyKeyObject delegate) {
        super(delegate);
    }

}
