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

package walkingkooka.text;

/**
 * A {@link CharSequence} that is always empty.
 */
final class EmptyCharSequence implements CharSequence {

    /**
     * Singleton
     */
    final static EmptyCharSequence INSTANCE = new EmptyCharSequence();

    /**
     * Private constructor use singleton
     */
    private EmptyCharSequence() {
        super();
    }

    // CharSequence

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(final int index) {
        throw new StringIndexOutOfBoundsException("Invalid index " + index);
    }

    @Override
    public CharSequence subSequence(final int start, final int end) {
        if (start != 0) {
            throw new StringIndexOutOfBoundsException("Invalid start index " + start);
        }
        if (end != 0) {
            throw new StringIndexOutOfBoundsException("Invalid end index " + end);
        }
        return this;
    }

    /**
     * Always returns an empty {@link String}.
     */
    @Override
    public String toString() {
        return "";
    }
}
