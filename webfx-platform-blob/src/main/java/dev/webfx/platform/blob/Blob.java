package dev.webfx.platform.blob;

import dev.webfx.platform.blob.spi.BlobProvider;

/**
 * A cross-platform interface inspired by the Web <a href="https://developer.mozilla.org/en-US/docs/Web/API/Blob">Blob API</a>.
 * <p>
 * The Blob interface serves as a wrapper for platform-specific objects such as
 * - Java File objects for desktop or mobile applications
 * - JavaScript Blob objects (including File) for web applications
 * <p>
 * Because the browser sandbox is much more restrictive than the JVM, this interface is much more limited than
 * Java files, but this is necessary to allow to handle them consistently across different platforms.
 *
 * @author Bruno Salmon
 */
public interface Blob {

    /**
     * Returns the underlying platform-specific object wrapped by this Blob.
     * 
     * @return the platform-specific object (e.g., a Java File or JavaScript Blob)
     */
    Object getPlatformBlob();

    /**
     * Returns the size of the Blob in bytes.
     * 
     * @return the size of the Blob in bytes
     */
    long length();

    /**
     * Returns the MIME type of the Blob.
     * 
     * @return the MIME type string (e.g., "text/plain", "image/jpeg")
     */
    String getMimeType();

    /**
     * Returns a URL that can be used to reference the Blob.
     * On web platforms, this typically returns an object URL created via URL.createObjectURL().
     * On other platforms, it may return a file URL or other platform-specific reference.
     * 
     * @return a URL string that can be used to reference this Blob
     */
    String getObjectURL();

    /**
     * Creates a new Blob that wraps the given platform-specific object.
     * 
     * @param platformBlob the platform-specific object to wrap (e.g., a Java File or JavaScript Blob)
     * @return a new Blob instance wrapping the provided platform-specific object
     */
    static Blob create(Object platformBlob) {
        return BlobProvider.get().createBlob(platformBlob);
    }

}
