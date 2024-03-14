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

import walkingkooka.text.Whitespace;

import java.util.Objects;

/**
 * Root {@link Exception} inherited by all custom exceptions. Note Depending on the constructor
 * called the message must not be null or only whitespace and the {@link Throwable cause} must not
 * be null.
 */
public class SystemException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    protected SystemException() {
    }

    protected SystemException(final String message) {
        super(checkMessage(message));
    }

    protected SystemException(final Throwable cause) {
        super(checkCause(cause));
    }

    protected SystemException(final String message, final Throwable cause) {
        super(checkMessage(message), checkCause(cause));
    }

    private static String checkMessage(final String message) {
        return Whitespace.failIfNullOrEmptyOrWhitespace(message, "message");
    }

    private static Throwable checkCause(final Throwable cause) {
        return Objects.requireNonNull(cause, "cause");
    }
}
