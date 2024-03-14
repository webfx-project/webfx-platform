/*
 * Copyright 2019 Miroslav Pokorny (github.com/mP1)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package walkingkooka;

import walkingkooka.text.CharSequences;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * This {@link Error} should only be thrown by code that should literally never happen.
 */
public class NeverError extends Error {

    private static final long serialVersionUID = 1L;

    /**
     * Reports an unexpected {@link UnsupportedEncodingException}.
     */
    public static <T> T unsupportedEncodingException(final UnsupportedEncodingException cause) {
        throw new NeverError(cause.getMessage(), cause);
    }

    /**
     * Reports an unexpected method call, including dumping the parameters.
     */
    public static <T> T unexpectedMethodCall(final Object instance, final String method, final Object... parameters) {
        throw new NeverError(instance.getClass().getName() + "." + method + "(" + Arrays.stream(parameters)
                .map(CharSequences::quoteIfChars)
                .collect(Collectors.joining(",")) + ")");
    }

    /**
     * Useful to report unexpected enums like values such as {@link int} or {@link String} used in a switch statement.
     */
    @SafeVarargs
    public static <T> T unhandledCase(final T value, final T... expected) {
        throw new NeverError("Unhandled value: " + CharSequences.quoteIfChars(value) + " only expected: " + Arrays.stream(expected)
                .map(CharSequences::quoteIfChars)
                .collect(Collectors.joining(",")));
    }

    /**
     * Useful to report unexpected enums in a switch.
     */
    @SafeVarargs
    public static <E extends Enum<E>, T> T unhandledEnum(final E value, final E... expected) {
        throw new NeverError("Unhandled enum value: " + value + " only expected: " + Arrays.stream(expected)
                .map(Enum::name)
                .collect(Collectors.joining(",")));
    }

    private static String check(final String message) {
        CharSequences.failIfNullOrEmpty(message, "message");
        return message;
    }

    private static Throwable check(final Throwable cause) {
        Objects.requireNonNull(cause, "cause");
        return cause;
    }

    protected NeverError() {
        super();
    }

    public NeverError(final String message) {
        super(NeverError.check(message));
    }

    public NeverError(final String message, final Throwable cause) {
        super(NeverError.check(message), NeverError.check(cause));
    }
}
