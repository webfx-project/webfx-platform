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

package walkingkooka.build;

import walkingkooka.SystemException;

/**
 * A general purpose exception thrown by {@link Builder} particularly when {@link Builder#build()}
 * fails.
 */
public class BuilderException extends SystemException {
    private final static long serialVersionUID = 1L;

    protected BuilderException() {
    }

    public BuilderException(final String message) {
        super(message);
    }

    public BuilderException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
