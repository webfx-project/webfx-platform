package dev.webfx.platform.util.http;

/**
 * @author Bruno Salmon
 */
public final class HttpResponseStatus {

    // 1xx Informational
    public static final int CONTINUE_100 = 100;
    public static final int SWITCHING_PROCOLOLS_101 = 101;
    public static final int PROCESSING_102 = 102;
    public static final int EARLY_HINTS_103 = 103;

    // 2xx Successful
    public static final int OK_200 = 200;
    public static final int CREATED_201 = 201;
    public static final int ACCEPTED_202 = 202;
    public static final int NON_AUTHORITATIVE_INFORMATION_203 = 203;
    public static final int NO_CONTENT_204 = 204;
    public static final int RESET_CONTENT_205 = 205;
    public static final int PARTIAL_CONTENT_206 = 206;
    public static final int MULTI_STATUS_207 = 207;
    public static final int ALREADY_REPORTED_208 = 208;
    public static final int IM_USED_226 = 226;

    // 3xx Redirection
    public static final int MULTIPLE_CHOICES_300 = 300;
    public static final int MOVED_PERMANENTLY_301 = 301;
    public static final int FOUND_302 = 302;
    public static final int SEE_OTHER_303 = 303;
    public static final int NOT_MODIFIED_304 = 304;
    public static final int USE_PROXY_305 = 305;
    public static final int SWITCH_PROXY_306 = 306;
    public static final int TEMPORARY_REDIRECT_307 = 307;
    public static final int PERMANENT_REDIRECT_308 = 308;

    // 4xx Client Error
    public static final int BAD_REQUEST_400 = 400;
    public static final int UNAUTHORIZED_401 = 401;
    public static final int PAYMENT_REQUIRED_402 = 402;
    public static final int FORBIDDEN_403 = 403;
    public static final int NOT_FOUND_404 = 404;
    public static final int METHOD_NOT_ALLOWED_405 = 405;
    public static final int NOT_ACCEPTABLE_406 = 406;
    public static final int PROXY_AUTHENTICATION_REQUIRED_407 = 407;
    public static final int REQUEST_TIMEOUT_408 = 408;
    public static final int CONFLICT_409 = 409;
    public static final int GONE_410 = 410;
    public static final int LENGTH_REQUIRED_411 = 411;
    public static final int PRECONDITION_FAILED_412 = 412;
    public static final int PAYLOAD_TO_LARGE_413 = 413;
    public static final int URI_TO_LONG_414 = 414;
    public static final int UNSUPPORTED_MEDIA_TYPE_415 = 415;
    public static final int RANGE_NOT_SATISFIABLE_416 = 416;
    public static final int EXPECTATION_FAILED_417 = 417;
    public static final int IM_A_TEAPOT_418 = 418;
    public static final int MISDIRECTED_REQUEST_421 = 421;
    public static final int UNPROCESSABLE_ENTITY_422 = 422;
    public static final int LOCKED_423 = 423;
    public static final int FAILED_DEPENDENCY_424 = 424;
    public static final int TOO_EARLY_425 = 425;
    public static final int UPGRADE_REQUIRED_426 = 426;
    public static final int PRECONDITION_REQUIRED_428 = 428;
    public static final int TOO_MANY_REQUESTS_429 = 429;
    public static final int REQUEST_HEADER_FIELDS_TOO_LARGE_431 = 431;
    public static final int UNAVAILABLE_FOR_LEGAL_REASONS_451 = 451;

    //5xx Server Error
    public static final int INTERNAL_SERVER_ERROR_500 = 500;
    public static final int NOT_IMPLEMENTED_501 = 501;
    public static final int BAD_GATEWAY_502 = 502;
    public static final int SERVICE_UNAVAILABLE_503 = 503;
    public static final int GATEWAY_TIMEOUT_504 = 504;
    public static final int HTTP_VERSION_NOT_SUPPORTED_505 = 505;
    public static final int VARIANT_ALSO_NEGOTIATES_506 = 506;
    public static final int INSUFFICIENT_STORAGE_507 = 507;
    public static final int LOOP_DETECTED_508 = 508;
    public static final int NOT_EXTENDED_510 = 510;
    public static final int NETWORK_ATHENTICATION_REQUIRED_511 = 511;

}
