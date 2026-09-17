package dev.webfx.platform.fetch;

import dev.webfx.platform.blob.Blob;

/**
 * @author Bruno Salmon
 */
public class FetchOptions {

    private String method; // ex: "GET", "POST", "PUT", "DELETE"
    private String mode; // ex: "cors", "no-cors", or "same-origin"
    private Headers headers;
    private Object body;

    public String getMethod() {
        return method;
    }

    public FetchOptions setMethod(String method) {
        this.method = method;
        return this;
    }

    public String getMode() {
        return mode;
    }

    public FetchOptions setMode(String mode) {
        this.mode = mode;
        return this;
    }

    public Headers getHeaders() {
        return headers;
    }

    public FetchOptions setHeaders(Headers headers) {
        this.headers = headers;
        return this;
    }

    public Object getBody() {
        return body;
    }

    public FetchOptions setBody(String body) {
        this.body = body;
        return this;
    }

    public FetchOptions setBody(Blob body) {
        this.body = body;
        return this;
    }

    public FetchOptions setBody(FormData body) {
        this.body = body;
        return this;
    }

    /**
     * Set a raw binary body. Use this when the caller already has the bytes
     * to send (e.g. an encrypted Web Push payload). The Content-Type header
     * is NOT inferred from the body — the caller must set it explicitly via
     * {@link #setHeaders(Headers)} (Web Push uses "application/octet-stream").
     * <p>
     * Mirrors the Web Fetch API's acceptance of {@code BufferSource}
     * (ArrayBuffer / typed array) as a request body.
     */
    public FetchOptions setBody(byte[] body) {
        this.body = body;
        return this;
    }
}
