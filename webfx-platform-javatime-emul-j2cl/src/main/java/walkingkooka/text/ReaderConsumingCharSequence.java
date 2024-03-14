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

import java.io.IOException;
import java.io.Reader;
import java.util.Objects;

/**
 * A {@link CharSequence} that reads its characters from a {@link Reader} when the last character in its current buffer
 * is read. Because this is mutable the hashcode and equals methods arent really worth using.
 */
final class ReaderConsumingCharSequence implements CharSequence {

    static ReaderConsumingCharSequence with(final Reader reader, final int bufferSize) {
        Objects.requireNonNull(reader, "reader");
        if (bufferSize <= 0) {
            throw new IllegalArgumentException("Buffersize " + bufferSize + " must be greater than 0");
        }
        return new ReaderConsumingCharSequence(reader, bufferSize);
    }

    private final Reader reader;

    private final StringBuilder content = new StringBuilder();

    // @VisibleForTesting
    boolean eof = false;

    private final char[] buffer;

    private ReaderConsumingCharSequence(final Reader reader, final int bufferSize) {
        this.reader = reader;
        this.buffer = new char[bufferSize];
    }

    @Override
    public int length() {
        this.maybeFillBuffer(1);
        return this.content.length();
    }

    @Override
    public char charAt(final int index) {
        if (index < 0) {
            throw new StringIndexOutOfBoundsException("Invalid index " + index);
        }
        this.maybeFillBuffer(index + 1);
        this.checkIndex(index, "Index", 0);

        return this.content.charAt(index);
    }

    @Override
    public CharSequence subSequence(final int start, final int end) {
        if (start < 0 || start > end) {
            throw new StringIndexOutOfBoundsException("Start index " + start + " must be between 0 and " + end);
        }

        this.maybeFillBuffer(end + 1);
        this.checkIndex(end, "End index", start);

        return this.content.subSequence(start, end);
    }

    private void checkIndex(final int index, final String label, final int start) {
        final int lengthAfterFill = this.content.length();
        if (index > lengthAfterFill) {
            throw new StringIndexOutOfBoundsException(label + " " + index + " must be between " + start + " and " + lengthAfterFill);
        }
    }

    private void maybeFillBuffer(final int untilCharCount) {
        if (!this.eof) {
            this.fillBuffer(untilCharCount);
        }
    }

    private void fillBuffer(final int untilCharCount) {
        try {
            final char[] buffer = this.buffer;

            for (; ; ) {
                if (untilCharCount < this.content.length()) {
                    break;
                }

                final int read = this.reader.read(buffer,
                        0,
                        buffer.length);
                if (-1 == read) {
                    this.eof = true;
                    break;
                }
                if (0 == read) {
                    break;
                }
                this.content.append(buffer, 0, read);
            }
        } catch (final IOException cause) {
            throw new ReaderConsumingCharSequenceTextException("Failed to fill char sequence, message: " + cause.getMessage(), cause);
        }
    }

    @Override
    public int hashCode() {
        return CharSequences.hash(this.content);
    }

    @Override
    public boolean equals(final Object other) {
        return this == other ||
                other instanceof ReaderConsumingCharSequence &&
                        this.equals0(Cast.to(other));
    }

    private boolean equals0(final ReaderConsumingCharSequence other) {
        return CharSequences.equals(this.content, other.content);
    }

    @Override
    public String toString() {
        return this.content.toString();
    }
}
