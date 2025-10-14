package dev.webfx.platform.fetch.spi.impl.elemental2;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.blob.NamedBlob;
import dev.webfx.platform.blob.spi.impl.elemental2.Elemental2Blob;
import dev.webfx.platform.fetch.FetchOptions;
import dev.webfx.platform.fetch.FormData;
import dev.webfx.platform.fetch.Headers;
import dev.webfx.platform.fetch.Response;
import dev.webfx.platform.fetch.spi.FetchProvider;
import dev.webfx.platform.util.Strings;
import dev.webfx.platform.util.elemental2.async.Elemental2Async;
import elemental2.dom.DomGlobal;
import elemental2.dom.RequestInit;

import java.util.Map;

/**
 * @author Bruno Salmon
 */
public class Elemental2FetchProvider implements FetchProvider {

    @Override
    public Future<Response> fetch(String url, FetchOptions options) {
        RequestInit requestInit = null;
        if (options != null) {
            requestInit = RequestInit.create();
            requestInit.setMethod(options.getMethod());
            String mode = options.getMode();
            if (mode != null)
                requestInit.setMode(mode);
            Headers headers = options.getHeaders();
            if (headers instanceof Elemental2Headers eHeaders)
                requestInit.setHeaders(eHeaders.getJsHeaders());
            Object body = options.getBody();
            if (body instanceof String sBody)
                requestInit.setBody(sBody);
            else if (body instanceof Elemental2Blob eBody) {
                requestInit.setBody(eBody.getPlatformBlob());
            } else if (body instanceof FormData formData) {
                requestInit.setBody(buildMultipartBody(formData));
            }
        }
        return Elemental2Async.jsPromiseToWebFXFuture(DomGlobal.window.fetch(url, requestInit), Elemental2Response::new);
    }

    @Override
    public Headers createHeaders() {
        return new Elemental2Headers();
    }

    private elemental2.dom.FormData buildMultipartBody(FormData formData) {
        elemental2.dom.FormData jsFormData = new elemental2.dom.FormData();

        for (Map.Entry<String, Object> entry : formData.entries()) {
            Object value = entry.getValue();
            String filename = null;

            if (value instanceof NamedBlob) {
                NamedBlob namedBlob =  (NamedBlob) entry.getValue();
                value = namedBlob.getBlob();
                filename = namedBlob.getName();
            }

            if (value instanceof Elemental2Blob eBlob) {
                elemental2.dom.Blob blob = eBlob.getPlatformBlob();
                jsFormData.set(entry.getKey(), elemental2.dom.FormData.SetValueUnionType.of(blob), filename);
            } else {
                jsFormData.set(entry.getKey(), Strings.toString(value));
            }
        }

        return jsFormData;
    }

}
