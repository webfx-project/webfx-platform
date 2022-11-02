package dev.webfx.platform.fetch;

/**
 * @author Bruno Salmon
 */
public class FetchOptions {

    private String method; // ex: "GET", "POST", "PUT", "DELETE"
    private String mode; // ex: "cors", "no-cors", or "same-origin"
    private Headers headers;

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
}
