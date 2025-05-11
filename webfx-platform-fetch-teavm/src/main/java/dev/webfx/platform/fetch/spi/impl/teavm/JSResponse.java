package dev.webfx.platform.fetch.spi.impl.teavm;

import org.teavm.jso.JSMethod;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;
import org.teavm.jso.core.JSPromise;
import org.teavm.jso.core.JSString;
import org.teavm.jso.file.Blob;
import org.teavm.jso.typedarrays.ArrayBuffer;

/**
 * @author Bruno Salmon
 */
interface JSResponse extends JSObject {

    @JSProperty
    boolean isOk(); // corresponds to `response.ok`

    @JSProperty
    int getStatus(); // corresponds to `response.status`

    @JSProperty
    String getStatusText();

    @JSProperty
    String getURL();

    @JSProperty
    boolean isRedirected(); // corresponds to `response.ok`

    @JSMethod
    JSPromise<JSObject> json(); // .json() returns a Promise<JS object>

    @JSMethod
    JSPromise<JSString> text(); // .text() returns a Promise<string>

    @JSMethod
    JSPromise<Blob> blob(); // .blob() returns a Promise<Blob>

    @JSMethod
    JSPromise<org.teavm.jso.ajax.FormData> formData();

    @JSMethod
    JSPromise<ArrayBuffer> arrayBuffer();

    @JSProperty
    JSHeaders getHeaders();

    @JSProperty
    org.teavm.jso.streams.ReadableStream getBody();
}

