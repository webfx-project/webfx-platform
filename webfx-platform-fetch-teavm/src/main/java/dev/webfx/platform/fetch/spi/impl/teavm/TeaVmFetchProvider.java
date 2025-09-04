package dev.webfx.platform.fetch.spi.impl.teavm;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.blob.NamedBlob;
import dev.webfx.platform.blob.spi.impl.teavm.TeaVmBlob;
import dev.webfx.platform.fetch.FetchOptions;
import dev.webfx.platform.fetch.FormData;
import dev.webfx.platform.fetch.Headers;
import dev.webfx.platform.fetch.Response;
import dev.webfx.platform.fetch.spi.FetchProvider;
import dev.webfx.platform.util.Strings;
import dev.webfx.platform.util.teavm.TeaVmUtil;
import org.teavm.jso.JSBody;
import org.teavm.jso.core.JSPromise;

import java.util.Map;

/**
 * @author Bruno Salmon
 */
public class TeaVmFetchProvider implements FetchProvider {

    @Override
    public Future<Response> fetch(String url, FetchOptions options) {
        JSRequestInit requestInit = null;
        if (options != null) {
            requestInit = createRequestInit();
            requestInit.setMethod(options.getMethod());
            String mode = options.getMode();
            if (mode != null)
                requestInit.setMode(mode);
            Headers headers = options.getHeaders();
            if (headers instanceof TeaVmHeaders)
                requestInit.setHeaders(((TeaVmHeaders) headers).getJsHeaders());
            Object body = options.getBody();
            if (body instanceof String)
                requestInit.setBody((String) body);
            else if (body instanceof TeaVmBlob) {
                requestInit.setBody(((TeaVmBlob) body).getPlatformBlob());
            } else if (body instanceof FormData) {
                requestInit.setBody(buildMultipartBody((FormData) body));
            }
        }
        return TeaVmUtil.jsPromiseToWebFXFuture(fetch(url, requestInit), TeaVmResponse::new);
    }

    @Override
    public Headers createHeaders() {
        return new TeaVmHeaders();
    }

    private org.teavm.jso.ajax.FormData buildMultipartBody(FormData formData) {
        org.teavm.jso.ajax.FormData jsFormData = new org.teavm.jso.ajax.FormData();

        for (Map.Entry<String, Object> entry : formData.entries()) {
            Object value = entry.getValue();
            String filename = null;

            if (value instanceof NamedBlob) {
                NamedBlob namedBlob = (NamedBlob) entry.getValue();
                value = namedBlob.getBlob();
                filename = namedBlob.getName();
            }

            if (value instanceof TeaVmBlob) {
                TeaVmBlob teaVmBlob = (TeaVmBlob) value;
                org.teavm.jso.file.Blob blob = teaVmBlob.getPlatformBlob();
                if (filename != null)
                    jsFormData.append(entry.getKey(), blob, filename);
                else
                    jsFormData.append(entry.getKey(), blob);
            } else {
                jsFormData.append(entry.getKey(), Strings.toString(value));
            }
        }

        return jsFormData;
    }

    @JSBody(script = "return new RequestInit();")
    private static native JSRequestInit createRequestInit();

    @JSBody(params = {"url", "requestInit"}, script = "return window.fetch(url, requestInit);")
    private static native JSPromise<JSResponse> fetch(String url, JSRequestInit requestInit);

}