package dev.webfx.platform.fetch;

import java.util.Iterator;

/**
 * @author Bruno Salmon
 */
public interface Headers {

    String CONTENT_TYPE = "Content-Type";
    String CONTENT_DISPOSITION = "Content-Disposition";
    String CONTENT_ENCODING = "Content-Encoding";
    String CONTENT_LANGUAGE = "Content-Language";
    String CONTENT_LENGTH = "Content-Length";
    String CONTENT_LOCATION = "Content-Location";
    String CONTENT_RANGE = "Content-Range";
    String CONTENT_RANGES = "Content-Ranges";
    String MULTIPART_FORMDATA = "multipart/form-data";

    static String multipartFormDataWithBoundary(String boundary) {
        return MULTIPART_FORMDATA + "; boundary=" + boundary;
    }

    Headers append(String name, String value);

    Headers delete(String name);

    String get(String name);

    boolean has(String name);

    Headers set(String name, String value);

    Iterator<String> keys();

    Iterator<String> values();

    static Headers create() {
        return Fetch.createHeaders();
    }

}
