package dev.webfx.platform.blob;

/**
 * A convenient class that can be used to associate a {@link Blob} with a filename.
 * This is useful for operations where both the binary data and its name are needed,
 * such as when saving or downloading files.
 *
 * @author Bruno Salmon
 */
public final class NamedBlob {

    private final Blob blob;
    private final String name;

    /**
     * Creates a new NamedBlob instance.
     *
     * @param blob the Blob containing the binary data
     * @param name the filename or identifier to associate with the Blob
     */
    public NamedBlob(Blob blob, String name) {
        this.blob = blob;
        this.name = name;
    }

    /**
     * Returns the Blob associated with this NamedBlob.
     *
     * @return the Blob containing the binary data
     */
    public Blob getBlob() {
        return blob;
    }

    /**
     * Returns the name associated with this Blob.
     *
     * @return the filename or identifier associated with the Blob
     */
    public String getName() {
        return name;
    }
}
