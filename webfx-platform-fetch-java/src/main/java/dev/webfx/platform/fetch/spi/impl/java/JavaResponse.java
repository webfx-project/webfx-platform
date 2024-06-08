package dev.webfx.platform.fetch.spi.impl.java;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.blob.Blob;
import dev.webfx.platform.blob.spi.impl.java.JavaBlob;
import dev.webfx.platform.fetch.Headers;
import dev.webfx.platform.fetch.Response;
import dev.webfx.platform.streams.ReadableStream;
import dev.webfx.platform.streams.spi.impl.java.JavaReadableStreams;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.http.HttpResponse;

import static dev.webfx.platform.util.http.HttpResponseStatus.*;

/**
 * @author Bruno Salmon
 */
final class JavaResponse implements Response {

    private final HttpResponse<?> javaResponse;
    private Headers headers;
    private ReadableStream body;

    public JavaResponse(HttpResponse<?> javaResponse) {
        this.javaResponse = javaResponse;
    }

    @Override
    public int status() {
        return javaResponse.statusCode();
    }

    @Override
    public String statusText() {
        int status = status();
        switch (status) {
            // 1xx Informational
            case CONTINUE_100: return "Continue";
            case SWITCHING_PROCOLOLS_101: return "Switching protocols";
            case PROCESSING_102: return "Processing";
            case EARLY_HINTS_103: return "Early Hints";

            // 2xx Successful
            case OK_200: return "OK";
            case CREATED_201: return "Created";
            case ACCEPTED_202: return "Accepted";
            case NON_AUTHORITATIVE_INFORMATION_203: return "Non-Authoritative Information";
            case NO_CONTENT_204: return "No Content";
            case RESET_CONTENT_205: return "Reset Content";
            case PARTIAL_CONTENT_206: return "Partial Content";
            case MULTI_STATUS_207: return "Multi-Status";
            case ALREADY_REPORTED_208: return "Already Reported";
            case IM_USED_226: return "IM Used";

            // 3xx Redirection
            case MULTIPLE_CHOICES_300: return "Multiple Choices";
            case MOVED_PERMANENTLY_301: return "Moved Permanently";
            case FOUND_302: return "Found (Previously \"Moved Temporarily\")";
            case SEE_OTHER_303: return "See Other";
            case NOT_MODIFIED_304: return "Not Modified";
            case USE_PROXY_305: return "Use Proxy";
            case SWITCH_PROXY_306: return "Switch Proxy";
            case TEMPORARY_REDIRECT_307: return "Temporary Redirect";
            case PERMANENT_REDIRECT_308: return "Permanent Redirect";

            // 4xx Client Error
            case BAD_REQUEST_400: return "Bad Request";
            case UNAUTHORIZED_401: return "Unauthorized";
            case PAYMENT_REQUIRED_402: return "Payment Required";
            case FORBIDDEN_403: return "Forbidden";
            case NOT_FOUND_404: return "Not Found";
            case METHOD_NOT_ALLOWED_405: return "Method Not Allowed";
            case NOT_ACCEPTABLE_406: return "Not Acceptable";
            case PROXY_AUTHENTICATION_REQUIRED_407: return "Proxy Authentication Required";
            case REQUEST_TIMEOUT_408: return "Request Timeout";
            case CONFLICT_409: return "Conflict";
            case GONE_410: return "Gone";
            case LENGTH_REQUIRED_411: return "Length Required";
            case PRECONDITION_FAILED_412: return "Precondition Failed";
            case PAYLOAD_TO_LARGE_413: return "Payload Too Large";
            case URI_TO_LONG_414: return "URI Too Long";
            case UNSUPPORTED_MEDIA_TYPE_415: return "Unsupported Media Type";
            case RANGE_NOT_SATISFIABLE_416: return "Range Not Satisfiable";
            case EXPECTATION_FAILED_417: return "Expectation Failed";
            case IM_A_TEAPOT_418: return "I'm a Teapot";
            case MISDIRECTED_REQUEST_421: return "Misdirected Request";
            case UNPROCESSABLE_ENTITY_422: return "Unprocessable Entity";
            case LOCKED_423: return "Locked";
            case FAILED_DEPENDENCY_424: return "Failed Dependency";
            case TOO_EARLY_425: return "Too Early";
            case UPGRADE_REQUIRED_426: return "Upgrade Required";
            case PRECONDITION_REQUIRED_428: return "Precondition Required";
            case TOO_MANY_REQUESTS_429: return "Too Many Requests";
            case REQUEST_HEADER_FIELDS_TOO_LARGE_431: return "Request Header Fields Too Large";
            case UNAVAILABLE_FOR_LEGAL_REASONS_451: return "Unavailable For Legal Reasons";

            //5xx Server Error
            case INTERNAL_SERVER_ERROR_500: return "Internal Server Error";
            case NOT_IMPLEMENTED_501: return "Not Implemented";
            case BAD_GATEWAY_502: return "Bad Gateway";
            case SERVICE_UNAVAILABLE_503: return "Service Unavailable";
            case GATEWAY_TIMEOUT_504: return "Gateway Timeout";
            case HTTP_VERSION_NOT_SUPPORTED_505: return "HTTP Version Not Supported";
            case VARIANT_ALSO_NEGOTIATES_506: return "Variant Also Negotiates";
            case INSUFFICIENT_STORAGE_507: return "Insufficient Storage";
            case LOOP_DETECTED_508: return "Loop Detected";
            case NOT_EXTENDED_510: return "Not Extended";
            case NETWORK_ATHENTICATION_REQUIRED_511: return "Network Authentication Required";
        }
        return "Status code: " + status;
    }

    @Override
    public String url() {
        try {
            return javaResponse.uri().toURL().toExternalForm();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Headers headers() {
        if (headers == null)
            headers = new JavaHeaders(javaResponse.headers().map());
        return headers;
    }

    @Override
    public Future<Blob> blob() {
        return Future.succeededFuture(new JavaBlob(javaResponse) {

            @Override
            public long length() {
                return javaResponse.headers().firstValueAsLong("Content-Length").orElse(0);
            }

            @Override
            public String getMimeType() {
                return javaResponse.headers().firstValue("Content-Type").orElse(null);
            }

            @Override
            protected URI toURI() {
                return javaResponse.uri();
            }
        });
    }

    @Override
    public Future<String> text() {
        return Future.succeededFuture(javaResponse.body().toString());
    }

    @Override
    public ReadableStream body() {
        if (body == null)
            body = new JavaReadableStreams(javaResponse.body());
        return body;
    }
}
