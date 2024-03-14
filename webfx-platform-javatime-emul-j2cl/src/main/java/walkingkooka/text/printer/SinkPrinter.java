/*
 * Copyright 2022 Miroslav Pokorny (github.com/mP1)
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

package walkingkooka.text.printer;

import walkingkooka.text.LineEnding;

import java.util.Objects;

/**
 * A {@link Printer} that ignores all {@link CharSequence sequences} added to it.
 */
final class SinkPrinter implements Printer {

    static SinkPrinter with(final LineEnding lineEnding) {
        Objects.requireNonNull(lineEnding, "lineEnding");

        final SinkPrinter printer;

        switch (lineEnding.toString()) {
            case "\r":
                printer = CR;
                break;
            case "\r\n":
                printer = CRNL;
                break;
            case "\n":
                printer = NL;
                break;
            case "":
                printer = NONE;
                break;
            default:
                throw new IllegalArgumentException("Unknown lineEnding: " + lineEnding);
        }

        return printer;
    }

    private final static SinkPrinter CR = new SinkPrinter(LineEnding.CR);
    private final static SinkPrinter CRNL = new SinkPrinter(LineEnding.CRNL);
    private final static SinkPrinter NL = new SinkPrinter(LineEnding.NL);
    private final static SinkPrinter NONE = new SinkPrinter(LineEnding.NONE);

    /**
     * Singleton
     */
    private SinkPrinter(final LineEnding lineEnding) {
        super();
        this.lineEnding = lineEnding;
    }

    @Override
    public void print(final CharSequence chars) {
        // nop
    }

    /**
     * Always returns {@link LineEnding}.
     */
    @Override
    public LineEnding lineEnding() {
        return this.lineEnding;
    }

    private final LineEnding lineEnding;

    @Override
    public void flush() {
        // nop
    }

    @Override
    public void close() {
        // nop
    }

    @Override
    public String toString() {
        return "sink";
    }
}
