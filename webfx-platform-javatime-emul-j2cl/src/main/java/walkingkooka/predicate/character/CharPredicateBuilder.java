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

package walkingkooka.predicate.character;

import walkingkooka.build.Builder;
import walkingkooka.build.BuilderException;
import walkingkooka.text.Whitespace;
import walkingkooka.util.Copyable;

import java.util.Objects;

/**
 * A {@link Builder} that may be used to create a {@link CharPredicate} using a variety of fluent
 * methods.
 */
final public class CharPredicateBuilder
        implements Builder<CharPredicate>, Copyable<CharPredicateBuilder> {

    /**
     * Creates a new {@link CharPredicateBuilder}
     */
    public static CharPredicateBuilder empty() {
        return new CharPredicateBuilder();
    }

    /**
     * Private constructor use factory.
     */
    private CharPredicateBuilder() {
        super();
    }

    /**
     * Updates this builder to match any of the characters in the provided {@link CharSequence}.
     */
    public CharPredicateBuilder any(final String chars) {
        return this.combine(CharPredicates.any(chars));
    }

    /**
     * Updates this builder to match any of the characters in the provided array.
     */
    public CharPredicateBuilder any(final char... chars) {
        Objects.requireNonNull(chars, "chars");

        return this.combine(CharPredicates.any(new String(chars)));
    }

    /**
     * Updates the character set to also include the provided {@link CharPredicate}.
     */
    public CharPredicateBuilder or(final CharPredicate predicate) {
        Objects.requireNonNull(predicate, "predicate");

        return this.combine(predicate);
    }

    /**
     * Performs an OR with any previous predicates and the new of.
     */
    private CharPredicateBuilder combine(final CharPredicate predicate) {
        final CharPredicate previous = this.predicate;

        this.predicate = null == previous ? predicate : CharPredicates.or(previous, predicate);
        return this;
    }

    /**
     * Updates the character set to also narrow the provided {@link CharPredicate}.
     */
    public CharPredicateBuilder and(final CharPredicate predicate) {
        Objects.requireNonNull(predicate, "predicate");

        final CharPredicate previous = this.predicate;
        this.predicate = null == previous ? predicate : CharPredicates.and(previous, predicate);
        return this;
    }

    /**
     * Updates the character set to also narrow the provided {@link CharPredicate}.
     */
    public CharPredicateBuilder andNot(final CharPredicate predicate) {
        Objects.requireNonNull(predicate, "predicate");

        final CharPredicate previous = this.predicate;
        this.predicate = null == previous ? predicate : CharPredicates.andNot(previous, predicate);
        return this;
    }

    /**
     * Inverts the currently selected characters.
     */
    public CharPredicateBuilder negate() {
        final CharPredicate previous = this.predicate;
        if (null != previous) {
            this.predicate = CharPredicates.not(previous);
        }
        return this;
    }

    /**
     * Updates this builder to predicate any of the characters in the inclusive range
     */
    public CharPredicateBuilder range(final char start, final char end) {
        this.combine(CharPredicates.range(start, end));
        return this;
    }

    // properties

    /**
     * The work in progress.
     */
    CharPredicate predicate;

    /**
     * Sets a {@link #toString} for the final {@link CharPredicate}.
     */
    public CharPredicateBuilder toString(final String toString) {
        this.toString = Whitespace.failIfNullOrEmptyOrWhitespace(
                toString,
                "toString"
        );
        return this;
    }

    private String toString;

    // Builder

    /**
     * Builds a {@link CharPredicate}
     */
    @Override
    public CharPredicate build() {
        final CharPredicate predicate = this.predicate;
        if (null == predicate) {
            throw new BuilderException("nothing built");
        }
        final String toString = this.toString;
        return null == toString ? predicate : CharPredicates.toString(predicate, toString);
    }

    // Object

    /**
     * Dumps the work in progress {@link CharPredicate}.
     */
    @Override
    public String toString() {
        final CharPredicate predicate = this.predicate;
        final String toString = this.toString;
        return null != toString ? toString : null == predicate ? "<nothing>" : predicate.toString();
    }

    // Copyable

    @Override
    public CharPredicateBuilder copy() {
        return new CharPredicateBuilder(this);
    }

    /**
     * Private copy constructor used by {@link #copy}
     */
    private CharPredicateBuilder(final CharPredicateBuilder copy) {
        super();
        this.predicate = copy.predicate;
        this.toString = copy.toString;
    }
}
