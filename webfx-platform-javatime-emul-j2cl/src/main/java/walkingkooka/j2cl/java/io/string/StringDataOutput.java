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

import java.io.DataOutput;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * A {@link DataOutput} that writes a {@link String} that can be consumed by {@link StringDataInput}.
 * The factory is typically given a {@link StringBuilder#append(String)} which is filled as stuff is written.
 */
final class StringDataOutput implements DataOutput {

    static StringDataOutput with(final Consumer<String> output) {
        Objects.requireNonNull(output, "output");
        return new StringDataOutput(output);
    }

    private StringDataOutput(final Consumer<String> output) {
        super();
        this.output = output;
    }

    @Override
    public void write(final int b) {
        this.writeByte(b);
    }

    @Override
    public void write(final byte[] b) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void write(final byte[] b, final int off, final int len) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void writeBoolean(final boolean v) {
        this.writeChar(v ? '1' : '0');
    }

    @Override
    public void writeByte(final int v) {
        this.writeShort((byte) v);
    }

    @Override
    public void writeShort(final int v) {
        this.writeInt((short) v);
    }

    @Override
    public void writeChar(final int v) {
        this.writeString(String.valueOf((char) v), false); // assumes char not code point
    }

    @Override
    public void writeInt(final int v) {
        this.writeString(Integer.toString(v), true);
    }

    @Override
    public void writeLong(final long v) {
        this.writeString(Long.toString(v), true);
    }

    @Override
    public void writeFloat(final float v) {
        this.writeDouble(v);
    }

    @Override
    public void writeDouble(final double v) {
        this.writeString(Double.toString(v).replace(".0", ""),
                true);
    }

    @Override
    public void writeBytes(final String s) {
        this.writeChars(s);
    }

    @Override
    public void writeChars(final String s) {
        this.writeUTF(s);
    }

    /**
     * Writing of nulls is not supported and will throw a {@link NullPointerException}.
     */
    @Override
    public void writeUTF(final String s) {
        Objects.requireNonNull(s, "string");

        this.writeString(s.replace("\\", "\\\\")
                .replace(",", "\\,"),
                true);
    }

    private void writeString(final String s, final boolean required) {
        if (this.separatorRequired) {
            this.output.accept(",");
        }
        this.separatorRequired = required;

        this.output.accept(s);
    }

    private boolean separatorRequired;
    private final Consumer<String> output;

    @Override
    public String toString() {
        return this.output.toString();
    }
}
