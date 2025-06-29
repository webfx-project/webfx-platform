package dev.webfx.platform.blob.spi;

import dev.webfx.platform.blob.Blob;
import dev.webfx.platform.service.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * Service Provider Interface (SPI) for creating and managing {@link Blob} instances.
 * This interface is implemented by platform-specific providers to handle blobs (web, desktop, mobile).
 * <p>
 * The BlobProvider is responsible for:
 * - Creating Blob instances from platform-specific objects
 * - Creating Blob instances from text
 * - Exporting/downloading Blobs
 *
 * @author Bruno Salmon
 */
public interface BlobProvider {

    /**
     * Returns the singleton instance of the BlobProvider.
     * Uses the Java ServiceLoader mechanism to locate the appropriate implementation.
     *
     * @return the platform-specific BlobProvider implementation
     */
    static BlobProvider get() {
        return SingleServiceProvider.getProvider(BlobProvider.class, () -> ServiceLoader.load(BlobProvider.class));
    }

    /**
     * Creates a new Blob that wraps the given platform-specific object.
     *
     * @param platformBlob the platform-specific object to wrap (e.g., a Java File or JavaScript Blob)
     * @return a new Blob instance wrapping the provided platform-specific object
     */
    Blob createBlob(Object platformBlob);

    /**
     * Creates a new Blob containing the specified text.
     *
     * @param text the text content to include in the Blob
     * @return a new Blob instance containing the text
     */
    Blob createTextBlob(String text);

    /**
     * Exports a Blob, typically triggering a download in web environments.
     * This is a convenience method that calls {@link #exportBlob(Blob, String)} with a null filename.
     *
     * @param blob the Blob to export
     */
    default void exportBlob(Blob blob) {
        exportBlob(blob, null);
    }

    /**
     * Exports a Blob with the specified filename, typically triggering a download in web environments.
     * The default implementation calls {@link #downloadUrl(String, String)} with the Blob's object URL.
     *
     * @param blob the Blob to export
     * @param fileName the filename to use for the exported Blob, or null to use a default name
     */
    default void exportBlob(Blob blob, String fileName) {
        downloadUrl(blob.getObjectURL(), fileName);
    }

    /**
     * Downloads the content at the specified URL.
     * This is a convenience method that calls {@link #downloadUrl(String, String)} with a null filename.
     *
     * @param url the URL to download
     */
    default void downloadUrl(String url) {
        downloadUrl(url, null);
    }

    /**
     * Downloads the content at the specified URL with the given filename.
     *
     * @param url the URL to download
     * @param fileName the filename to use for the downloaded content, or null to use a default name
     */
    void downloadUrl(String url, String fileName);

}
