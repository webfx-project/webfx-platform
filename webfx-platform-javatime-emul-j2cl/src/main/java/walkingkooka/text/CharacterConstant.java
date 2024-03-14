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

import walkingkooka.InvalidCharacterException;
import walkingkooka.collect.list.Lists;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Holds both a character and its {@link String} equivalent. This is ideal for constants that should
 * not be inlined and is intended to replace dual declaration of constants of for the character and
 * another to hold the {@link String} equivalent.
 */
final public class CharacterConstant implements CharSequence {

    final static char LOWER_BOUNDS = '\n';

    final static char UPPER_BOUNDS = 'z';

    /**
     * The cache holds only printables between {@link #LOWER_BOUNDS} and {@link #UPPER_BOUNDS}.
     */
    private final static CharacterConstant[] CONSTANTS = CharacterConstant.fill();

    private static CharacterConstant[] fill() {
        final CharacterConstant[] constants = new CharacterConstant[
                (CharacterConstant.UPPER_BOUNDS + 1) - CharacterConstant.LOWER_BOUNDS];
        for (char c = CharacterConstant.LOWER_BOUNDS; c < (CharacterConstant.UPPER_BOUNDS + 1); c++) {
            constants[c - CharacterConstant.LOWER_BOUNDS] = new CharacterConstant(c);
        }
        return constants;
    }

    /**
     * Factory that returns a {@link CharacterConstant} which may be shared/cached.
     */
    public static CharacterConstant with(final char c) {
        return (c >= CharacterConstant.LOWER_BOUNDS) && (c <= CharacterConstant.UPPER_BOUNDS) ?
                CharacterConstant.CONSTANTS[c - CharacterConstant.LOWER_BOUNDS] :
                new CharacterConstant(c);
    }

    /**
     * COMMA
     */
    public final static CharacterConstant COMMA = with(',');

    private CharacterConstant(final char character) {
        super();
        this.character = character;
        this.string = String.valueOf(character);
    }

    public char character() {
        return this.character;
    }

    private final char character;

    public String string() {
        return this.string;
    }

    private final String string;

    // SubSequence

    @Override
    public int length() {
        return 1;
    }

    @Override
    public char charAt(final int index) {
        if (0 != index) {
            this.failIndexOfOutBounds("index must be 0");
        }
        return this.character;
    }

    @Override
    public CharSequence subSequence(final int start, final int end) {
        if (0 != start) {
            this.failIndexOfOutBounds("start must be 0 but was " + start);
        }
        return 0 == end ? "" : 1 == end ? this : this.failSubSequence(end);
    }

    private CharSequence failSubSequence(final int end) {
        return this.failIndexOfOutBounds("end must be 0 or 1 but was " + end);
    }

    private CharSequence failIndexOfOutBounds(final String message) {
        throw new StringIndexOutOfBoundsException(message);
    }

    // parse............................................................................................................

    /**
     * Parses the given {@link String text} into csv delimited components, each component is then parsed.
     * An empty input {@link String} will produce an empty {@link List}.
     */
    public <T> List<T> parse(final String text,
                             final Function<String, T> component) {
        Objects.requireNonNull(text, "text");

        final List<T> parsed = Lists.array();

        final int length = text.length();
        int i = 0;
        int start = 0;

        while (i < length) {
            final char c = text.charAt(i);
            if (this.character == c) {
                parse0(
                        text,
                        start,
                        i,
                        component,
                        parsed
                );

                start = i + 1;
            }
            i++;
        }

        if (start != length) {
            parse0(
                    text,
                    start,
                    length,
                    component,
                    parsed
            );
        }

        return Lists.immutable(parsed);
    }

    private static <T> void parse0(final String text,
                                   final int start,
                                   final int end,
                                   final Function<String, T> component,
                                   final List<T> parsed) {
        try {
            parsed.add(
                    component.apply(text.substring(start, end))
            );
        } catch (final InvalidCharacterException cause) {
            throw cause.setTextAndPosition(
                    text,
                    start + cause.position()
            );
        } catch (final RuntimeException cause) {
            throw new IllegalArgumentException("Unable to parse " + CharSequences.quote(text) + ", " + cause.getMessage(), cause);
        }
    }

    // toSeparatedString..................................................................................................

    /**
     * THe inverse of the {link #parse}, turns the given values back into a CSV String.
     */
    public <T> String toSeparatedString(final Collection<T> values,
                                        final Function<T, String> component) {
        Objects.requireNonNull(values, "values");
        Objects.requireNonNull(component, "component");

        return values.stream()
                .map(component)
                .collect(Collectors.joining(this.string));
    }

    // Object..........................................................................................................

    @Override
    public int hashCode() {
        return this.character;
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || //
                other instanceof CharacterConstant && this.equals0((CharacterConstant) other);
    }

    private boolean equals0(final CharacterConstant other) {
        return this.equals(other.character);
    }

    public boolean equals(final char c) {
        return this.character == c;
    }

    @Override
    public String toString() {
        return this.string;
    }
}
