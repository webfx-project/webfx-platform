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
import walkingkooka.util.OpenChecker;

import java.util.Objects;

/**
 * A {@link Printer} that adds any {@link CharSequence characters} to a {@link StringBuilder}.
 */
final class StringBuilderPrinter implements Printer {

    /**
     * Creates a new {@link StringBuilderPrinter}. Note the {@link StringBuilder} does not have to
     * be empty nor is it cleared.
     */
    static StringBuilderPrinter with(final StringBuilder builder, final LineEnding lineEnding) {
        Objects.requireNonNull(builder, "builder");
        Objects.requireNonNull(lineEnding, "lineEnding");

        return new StringBuilderPrinter(builder, lineEnding);
    }

    /**
     * Private constructor use static factory
     */
    private StringBuilderPrinter(final StringBuilder builder, final LineEnding lineEnding) {
        this.stringBuilder = builder;
        this.lineEnding = lineEnding;
    }

    /**
     * Appends the {@link CharSequence} to the wrapped {@link StringBuilder}.
     */
    @Override
    public void print(final CharSequence chars) {
        this.openChecker.check();
        this.stringBuilder.append(chars);
    }

    @Override
    public LineEnding lineEnding() {
        this.openChecker.check();
        return this.lineEnding;
    }

    private final LineEnding lineEnding;

    /**
     * Does nothing but verify this printer is still open
     */
    @Override
    public void flush() {
        this.openChecker.check();
    }

    @Override
    public void close() {
        this.openChecker.close();
    }

    /**
     * Package private for testing purposes
     */
    final StringBuilder stringBuilder;

    /**
     * A flag that keeps track of whether this {@link Printer} is open(false) or closed(true)
     */
    private final OpenChecker<IllegalStateException> openChecker = OpenChecker.with(
            "Printer is closed",
            IllegalStateException::new
    );

    /**
     * Dumps the wrapped {@link StringBuilder}
     */
    @Override
    public String toString() {
        return this.stringBuilder.toString();
    }
}
