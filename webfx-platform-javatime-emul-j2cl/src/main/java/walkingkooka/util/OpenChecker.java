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

package walkingkooka.util;

import walkingkooka.text.Whitespace;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/**
 * A simple guard that initially starts off "open" but may eventually be changed to closed. Any
 * future checks will fail.
 */
final public class OpenChecker<T extends Throwable> {

    /**
     * Creates a new {@link OpenChecker} which is initially open.
     */
    public static <T extends Throwable> OpenChecker<T> with(final String message,
                                                            final Function<String, T> throwableFactory) {
        return new OpenChecker<>(
                Whitespace.failIfNullOrEmptyOrWhitespace(message, "message"),
                Objects.requireNonNull(throwableFactory, "throwableFactory")
        );
    }

    /**
     * Private constructor use factory
     */
    private OpenChecker(final String message, final Function<String, T> throwableFactory) {
        super();
        this.message = message;
        this.throwableFactory = throwableFactory;
    }

    /**
     * If this thing has been closed an {@link Throwable} will be thrown.
     */
    public void check() throws T {
        if (this.closed.get()) {
            throw this.throwableFactory.apply(this.message);
        }
    }

    /**
     * If closed invokes {@link Function#apply(Object)}
     */
    public <T2 extends Throwable> void check(final Function<String, T2> throwableFactory) throws T2 {
        if (this.closed.get()) {
            throw throwableFactory.apply(this.message);
        }
    }

    /**
     * Updates the closed flag. Note that once closed this value can never ever be changed back to
     * open. True is returned if this {@link OpenChecker} is already closed.
     */
    public boolean close() {
        return this.closed.getAndSet(true);
    }

    /**
     * Helper that verifies that this guard is open and then closes it.
     */
    public void closeOnce() throws T {
        this.check();
        this.close();
    }

    /**
     * Getter that returns true if this has been closed.
     */
    public boolean isClosed() {
        return this.closed.get();
    }

    /**
     * Supplies the message that is thrown.
     */
    private final String message;

    /**
     * The {@link Function} that is used to create a throwable to report a closed.
     */
    private final Function<String, T> throwableFactory;

    /**
     * A flag that becomes true when closed
     */
    private final AtomicBoolean closed = new AtomicBoolean();

    /**
     * Dumps the closed status of this guard.
     */
    @Override
    public String toString() {
        return this.closed.get() ? "Closed" : "Open";
    }
}
