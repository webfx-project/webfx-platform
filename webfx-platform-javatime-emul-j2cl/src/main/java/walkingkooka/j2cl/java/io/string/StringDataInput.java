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

package walkingkooka.j2cl.java.io.string;

import walkingkooka.text.CharSequences;

import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;

/**
 * A {@link DataInput} that reads from a {@link String} encoded by {@link StringDataOutput}.
 * Some operations such as skipBytes and readLine will throw {@link UnsupportedOperationException}.
 */
final class StringDataInput implements DataInput {

    static StringDataInput with(final String source) {
        Objects.requireNonNull(source, "source");

        return new StringDataInput(source);
    }

    private StringDataInput(final String source) {
        super();
        this.source = source;
    }

    @Override
    public void readFully(final byte[] b) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void readFully(final byte[] b, final int off, final int len) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int skipBytes(final int n) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean readBoolean() throws IOException {
        final boolean booleanValue;
        final char charValue = this.readChar();
        switch (charValue) {
            case '0':
                booleanValue = false;
                break;
            case '1':
                booleanValue = true;
                break;
            default:
                throw new IOException("Bad boolean value " + charValue);
        }

        return booleanValue;
    }

    @Override
    public byte readByte() throws IOException {
        return Byte.parseByte(this.readNumberString());
    }

    @Override
    public int readUnsignedByte() throws IOException {
        final int value = this.readShort();
        if (value < 0 || value > 255) {
            throw new IOException("Invalid unsigned byte " + value);
        }
        return value;
    }

    @Override
    public short readShort() throws IOException {
        return Short.parseShort(this.readNumberString());
    }

    @Override
    public int readUnsignedShort() throws IOException {
        final int value = this.readInt();
        if (value < 0 || value > 0x10000) {
            throw new IOException("Invalid unsigned short " + value);
        }
        return value;
    }

    @Override
    public char readChar() throws IOException {
        final int offset = this.offset;
        final String source = this.source;
        final int end = source.length();

        if (offset == end) {
            throw new EOFException();
        }

        this.offset++;
        return source.charAt(offset);
    }

    @Override
    public int readInt() throws IOException {
        return Integer.parseInt(this.readNumberString());
    }

    @Override
    public long readLong() throws IOException {
        return Long.parseLong(this.readNumberString());
    }

    @Override
    public float readFloat() throws IOException {
        return Float.parseFloat(this.readNumberString());
    }

    @Override
    public double readDouble() throws IOException {
        return Double.parseDouble(this.readNumberString());
    }

    @Override
    public String readLine() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String readUTF() throws IOException {
        return this.readString();
    }

    private String readNumberString() throws IOException {
        final int offset = this.offset;
        final String source = this.source;
        final int end = source.length();

        if (offset == end) {
            throw new EOFException();
        }

        int i = offset;
        String text;

        for (; ; ) {
            final char c = source.charAt(i);
            i++;
            if (',' == c) {
                text = source.substring(offset, i - 1);
                break;
            }
            if (end == i) {
                text = source.substring(offset, end);
                break;
            }
        }

        this.offset = i;
        return text;
    }

    private String readString() throws IOException {
        int offset = this.offset;
        final String source = this.source;
        final int end = source.length();
        final StringBuilder text = new StringBuilder();

        boolean escaped = false;

        Exit:
        while (offset < end) {
            char c = source.charAt(offset);
            offset++;

            if (escaped) {
                switch (c) {
                    case '\\':
                        break;
                    case ',':
                        break;
                    default:
                        throw new IOException("Unexpected backslash escape " + CharSequences.quoteIfChars(c));
                }
                text.append(c);
                escaped = false;
                continue;
            }

            switch (c) {
                case '\\':
                    escaped = true;
                    break;
                case ',': // unescaped comma means end of string.
                    break Exit;
                default:
                    text.append(c);
                    break;
            }
        }

        this.offset = offset;
        return text.toString();
    }

    private final String source;

    private int offset;

    @Override
    public String toString() {
        final String source = this.source;
        final int offset = this.offset;
        return offset < source.length() ?
                source.substring(offset) :
                "";
    }
}
