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
 * A {@link Printer} that passes the {@link CharSequence} too each of the two {@link Printer} given
 * at construction.
 */
final class TeePrinter implements Printer {

    /**
     * Creates a new {@link TeePrinter} if the two printers are different.
     */
    static Printer wrap(final Printer first, final Printer second) {
        Objects.requireNonNull(first, "first Printer");
        Objects.requireNonNull(second, "second Printer");

        return first.equals(second) ? first : new TeePrinter(first, second);
    }

    /**
     * Private constructor.
     */
    private TeePrinter(final Printer first, final Printer second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public void print(final CharSequence chars) {
        this.first.print(chars);
        this.second.print(chars);
    }

    /**
     * Returns the {@link LineEnding} of the first {@link Printer}.
     */
    @Override
    public LineEnding lineEnding() {
        return this.first.lineEnding();
    }

    /**
     * Flushes both {@link Printer printers} even if the first fails.
     */
    @Override
    public void flush() {
        try {
            this.first.flush();
        } finally {
            this.second.flush();
        }
    }

    /**
     * Closes both {@link Printer printers} even if the first fails.
     */
    @Override
    public void close() {
        try {
            this.first.close();
        } finally {
            this.second.close();
        }
    }

    // properties

    private final Printer first;

    private final Printer second;

    @Override
    public String toString() {
        return "tee (" + this.first + " AND " + this.second + ")";
    }
}
