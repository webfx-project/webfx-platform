package dev.webfx.platform.fetch.spi.impl.jre;

import dev.webfx.platform.async.Future;
import dev.webfx.platform.blob.Blob;
import dev.webfx.platform.blob.spi.impl.jre.JreBlob;
import dev.webfx.platform.fetch.Headers;
import dev.webfx.platform.fetch.Response;
import dev.webfx.platform.streams.ReadableStream;
import dev.webfx.platform.streams.spi.impl.jre.JreReadableStreams;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.http.HttpResponse;

import static dev.webfx.platform.util.http.HttpResponseStatus.*;

/**
 * @author Bruno Salmon
 */
final class JreResponse implements Response {

    private final HttpResponse<?> javaResponse;
    private Headers headers;
    private ReadableStream body;

    public JreResponse(HttpResponse<?> javaResponse) {
        this.javaResponse = javaResponse;
    }

    @Override
    public int status() {
        return javaResponse.statusCode();
    }

    @Override
    public String statusText() {
        int status = status();
        return switch (status) {
            // 1xx Informational
            case CONTINUE_100 -> "Continue";
            case SWITCHING_PROTOCOLS_101 -> "Switching protocols";
            case PROCESSING_102 -> "Processing";
            case EARLY_HINTS_103 -> "Early Hints";

            // 2xx Successful
            case OK_200 -> "OK";
            case CREATED_201 -> "Created";
            case ACCEPTED_202 -> "Accepted";
            case NON_AUTHORITATIVE_INFORMATION_203 -> "Non-Authoritative Information";
            case NO_CONTENT_204 -> "No Content";
            case RESET_CONTENT_205 -> "Reset Content";
            case PARTIAL_CONTENT_206 -> "Partial Content";
            case MULTI_STATUS_207 -> "Multi-Status";
            case ALREADY_REPORTED_208 -> "Already Reported";
            case IM_USED_226 -> "IM Used";

            // 3xx Redirection
            case MULTIPLE_CHOICES_300 -> "Multiple Choices";
            case MOVED_PERMANENTLY_301 -> "Moved Permanently";
            case FOUND_302 -> "Found (Previously \"Moved Temporarily\")";
            case SEE_OTHER_303 -> "See Other";
            case NOT_MODIFIED_304 -> "Not Modified";
            case USE_PROXY_305 -> "Use Proxy";
            case SWITCH_PROXY_306 -> "Switch Proxy";
            case TEMPORARY_REDIRECT_307 -> "Temporary Redirect";
            case PERMANENT_REDIRECT_308 -> "Permanent Redirect";

            // 4xx Client Error
            case BAD_REQUEST_400 -> "Bad Request";
            case UNAUTHORIZED_401 -> "Unauthorized";
            case PAYMENT_REQUIRED_402 -> "Payment Required";
            case FORBIDDEN_403 -> "Forbidden";
            case NOT_FOUND_404 -> "Not Found";
            case METHOD_NOT_ALLOWED_405 -> "Method Not Allowed";
            case NOT_ACCEPTABLE_406 -> "Not Acceptable";
            case PROXY_AUTHENTICATION_REQUIRED_407 -> "Proxy Authentication Required";
            case REQUEST_TIMEOUT_408 -> "Request Timeout";
            case CONFLICT_409 -> "Conflict";
            case GONE_410 -> "Gone";
            case LENGTH_REQUIRED_411 -> "Length Required";
            case PRECONDITION_FAILED_412 -> "Precondition Failed";
            case PAYLOAD_TO_LARGE_413 -> "Payload Too Large";
            case URI_TO_LONG_414 -> "URI Too Long";
            case UNSUPPORTED_MEDIA_TYPE_415 -> "Unsupported Media Type";
            case RANGE_NOT_SATISFIABLE_416 -> "Range Not Satisfiable";
            case EXPECTATION_FAILED_417 -> "Expectation Failed";
            case IM_A_TEAPOT_418 -> "I'm a Teapot";
            case MISDIRECTED_REQUEST_421 -> "Misdirected Request";
            case UNPROCESSABLE_ENTITY_422 -> "Unprocessable Entity";
            case LOCKED_423 -> "Locked";
            case FAILED_DEPENDENCY_424 -> "Failed Dependency";
            case TOO_EARLY_425 -> "Too Early";
            case UPGRADE_REQUIRED_426 -> "Upgrade Required";
            case PRECONDITION_REQUIRED_428 -> "Precondition Required";
            case TOO_MANY_REQUESTS_429 -> "Too Many Requests";
            case REQUEST_HEADER_FIELDS_TOO_LARGE_431 -> "Request Header Fields Too Large";
            case UNAVAILABLE_FOR_LEGAL_REASONS_451 -> "Unavailable For Legal Reasons";

            //5xx Server Error
            case INTERNAL_SERVER_ERROR_500 -> "Internal Server Error";
            case NOT_IMPLEMENTED_501 -> "Not Implemented";
            case BAD_GATEWAY_502 -> "Bad Gateway";
            case SERVICE_UNAVAILABLE_503 -> "Service Unavailable";
            case GATEWAY_TIMEOUT_504 -> "Gateway Timeout";
            case HTTP_VERSION_NOT_SUPPORTED_505 -> "HTTP Version Not Supported";
            case VARIANT_ALSO_NEGOTIATES_506 -> "Variant Also Negotiates";
            case INSUFFICIENT_STORAGE_507 -> "Insufficient Storage";
            case LOOP_DETECTED_508 -> "Loop Detected";
            case NOT_EXTENDED_510 -> "Not Extended";
            case NETWORK_AUTHENTICATION_REQUIRED_511 -> "Network Authentication Required";
            default -> "Status code: " + status;
        };
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
            headers = new JreHeaders(javaResponse.headers().map());
        return headers;
    }

    @Override
    public Future<Blob> blob() {
        return Future.succeededFuture(new JreBlob(javaResponse) {

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
            body = new JreReadableStreams(javaResponse.body());
        return body;
    }
}
