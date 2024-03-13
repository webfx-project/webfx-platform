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

enum ToStringBuilderMode {

    NONE {
        @Override
        void beforeLabel(final ToStringBuilder builder) {
        }

        @Override
        ToStringBuilderMode value() {
            return VALUE;
        }
    },
    LABEL_SEPARATOR {
        @Override
        void beforeLabel(final ToStringBuilder builder) {
        }

        @Override
        ToStringBuilderMode value() {
            return VALUE;
        }
    },
    SEPARATOR {
        @Override
        void beforeLabel(final ToStringBuilder builder) {
            throw new UnsupportedOperationException();
        }

        @Override
        ToStringBuilderMode value() {
            return VALUE;
        }
    },
    VALUE_SEPARATOR {
        @Override
        void beforeLabel(final ToStringBuilder builder) {
            throw new UnsupportedOperationException();
        }

        @Override
        ToStringBuilderMode value() {
            return VALUE;
        }
    },
    VALUE {
        @Override
        void beforeLabel(final ToStringBuilder builder) {
            builder.appendSeparator();
        }

        @Override
        ToStringBuilderMode value() {
            return NONE;
        }
    },
    APPEND {
        @Override
        void beforeLabel(final ToStringBuilder builder) {
            // nop
        }

        @Override
        ToStringBuilderMode value() {
            return VALUE;
        }
    };

    abstract void beforeLabel(final ToStringBuilder builder);

    abstract ToStringBuilderMode value();
}
