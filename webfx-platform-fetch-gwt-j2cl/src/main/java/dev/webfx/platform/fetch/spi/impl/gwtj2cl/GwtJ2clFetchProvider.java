package dev.webfx.platform.fetch.spi.impl.gwtj2cl;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.blob.Blob;
import dev.webfx.platform.blob.NamedBlob;
import dev.webfx.platform.blob.spi.impl.gwtj2cl.GwtJ2clBlob;
import dev.webfx.platform.fetch.*;
import dev.webfx.platform.fetch.spi.FetchProvider;
import dev.webfx.platform.util.Strings;
import elemental2.dom.DomGlobal;
import elemental2.dom.RequestInit;

import java.util.Map;

/**
 * @author Bruno Salmon
 */
public class GwtJ2clFetchProvider implements FetchProvider {

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
            if (headers instanceof GwtJ2clHeaders)
                requestInit.setHeaders(((GwtJ2clHeaders) headers).getJsHeaders());
            Object body = options.getBody();
            if (body instanceof String)
                requestInit.setBody((String) body);
            else if (body instanceof GwtJ2clBlob) {
                requestInit.setBody(((GwtJ2clBlob) body).getPlatformBlob());
            } else if (body instanceof FormData) {
                requestInit.setBody(buildMultipartBody((FormData) body));
            }
        }
        return GwtJ2clUtil.jsPromiseToWebFXFuture(DomGlobal.window.fetch(url, requestInit), GwtJ2clResponse::new);
    }

    @Override
    public Headers createHeaders() {
        return new GwtJ2clHeaders();
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

            if (value instanceof GwtJ2clBlob) {
                GwtJ2clBlob gwtJ2clBlob = (GwtJ2clBlob) value;
                Blob blob = (Blob) gwtJ2clBlob.getPlatformBlob();
                jsFormData.set(entry.getKey(), elemental2.dom.FormData.SetValueUnionType.of(blob), filename);
            } else {
                jsFormData.set(entry.getKey(), Strings.toString(value));
            }
        }

        return jsFormData;
    }

}
