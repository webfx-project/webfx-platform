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
}
