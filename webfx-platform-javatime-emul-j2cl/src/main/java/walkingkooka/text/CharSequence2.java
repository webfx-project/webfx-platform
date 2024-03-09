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

import walkingkooka.Cast;

/**
 * Template {@link CharSequence} that includes templated handling the boring bits of {@link
 * #charAt(int)} and {@link #subSequence(int, int)} .
 */
abstract class CharSequence2<C extends CharSequence2<C>> implements CharSequence {

    /**
     * Package private to limit sub classing.
     */
    CharSequence2() {
        super();
    }

    /**
     * {@see CharSequence#charAt(int)}.
     */
    @Override
    final public char charAt(final int index) {
        final int length = this.length();
        if (index < 0 || index >= length) {
            throw new StringIndexOutOfBoundsException(
                    "Index " + index + " must be between 0 and " + length);
        }
        return this.charAtIndex(index);
    }

    /**
     * Sub classes must override this method which is called after index has been verified.
     */
    abstract char charAtIndex(int index);

    @Override
    final public CharSequence subSequence(final int start, final int end) {
        final int length = this.length();
        if (start < 0 || start > end || end > length) {
            throw new StringIndexOutOfBoundsException(
                    "start " + start + ", end " + end + ", length " + length);
        }

        CharSequence result = this;
        for (; ; ) {
            if ((start == 0) && (end == length)) {
                break;
            }
            if (start == end) {
                result = "";
                break;
            }
            result = this.subSequence0(start, end);
            break;
        }

        return result;
    }

    /**
     * Called after start and end have been verified to be different and valid.
     */
    abstract CharSequence subSequence0(int start, int end);

    // Object...........................................................................................................

    /**
     * Lazily calculates the hash code and stores it for future retrieval.
     */
    @Override
    final public int hashCode() {
        if (0 == this.hashCode) {
            this.hashCode = this.calculateHashCode();
        }
        return this.hashCode;
    }

    /**
     * This method is invoked only once when the hashcode is first requested. Future requests are
     * taken from the cached value.
     */
    abstract int calculateHashCode();

    /**
     * The cached hash code which is initially set to 0.
     */
    private transient int hashCode = 0;

    /**
     * Performs some simple checks for nullness, identity and type using {@link #canBeEqual(Object)}
     * before invoking {@link #equals0(C)} if types are compatible but different
     * instances.
     */
    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    final public boolean equals(final Object other) {
        return this == other || this.canBeEqual(other) && this.equals0(Cast.to(other));
    }

    /**
     * Tests if the argument to {@link #equals(Object)} is compatible for purposes of equality.Note
     * the parameter may be null thus the best testing includes an instance of X test.
     */
    abstract boolean canBeEqual(final Object other);

    /**
     * This method is invoked only if the both objects are the same type and not null.
     */
    abstract boolean equals0(C object);

    /**
     * Checks a cached field and if null calls {@link #buildToString()}
     */
    @Override
    final public String toString() {
        if (null == this.toString) {
            this.toString = this.buildToString();
        }
        return this.toString;
    }

    /**
     * May be overridden but probably should not be necessary.
     */
    abstract String buildToString();

    /**
     * A transient cache of {@link #toString()} result built by {@link #buildToString()}.
     */
    private transient String toString;
}
