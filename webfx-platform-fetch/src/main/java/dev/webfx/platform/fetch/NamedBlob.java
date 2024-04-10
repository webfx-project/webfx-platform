package dev.webfx.platform.fetch;

import dev.webfx.platform.blob.Blob;

/**
 * @author Bruno Salmon
 */
public final class NamedBlob {

    private final Blob blob;
    private final String name;

    public NamedBlob(Blob blob, String name) {
        this.blob = blob;
        this.name = name;
    }

    public Blob getBlob() {
        return blob;
    }

    public String getName() {
        return name;
    }
}
