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

package walkingkooka.collect.iterator;

import walkingkooka.text.CharSequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * An {@link Iterator} that returns the individual {@link Character characters} from a {@link
 * CharSequence}.
 */
final class CharSequenceIterator implements Iterator<Character> {

    /**
     * Creates a new {@link CharSequenceIterator}
     */
    static CharSequenceIterator with(final CharSequence charSequence) {
        Objects.requireNonNull(charSequence, "charSequence");

        return new CharSequenceIterator(charSequence);
    }

    private CharSequenceIterator(final CharSequence charSequence) {
        super();
        this.charSequence = charSequence;
        this.i = 0;
    }

    // Iterator

    @Override
    public boolean hasNext() {
        return this.i < this.charSequence.length();
    }

    @Override
    public Character next() {
        final CharSequence chars = this.charSequence;
        final int i = this.i;
        if (i >= chars.length()) {
            throw new NoSuchElementException();
        }
        final Character character = chars.charAt(i);
        this.i = i + 1;
        return character;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    private final CharSequence charSequence;

    private int i;

    @Override
    public String toString() {
        return CharSequences.quoteAndEscape(this.charSequence).toString();
    }
}
