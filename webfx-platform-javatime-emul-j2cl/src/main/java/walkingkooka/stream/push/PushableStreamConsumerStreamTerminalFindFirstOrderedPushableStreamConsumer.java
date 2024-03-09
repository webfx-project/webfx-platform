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

package walkingkooka.stream.push;

import walkingkooka.ToStringBuilder;
import walkingkooka.stream.StreamException;
import walkingkooka.text.CharSequences;

import java.util.Optional;

/**
 * The FIND FIRST ORDERED TERMINAL {@link PushableStreamConsumer}.
 */
final class PushableStreamConsumerStreamTerminalFindFirstOrderedPushableStreamConsumer<T> extends PushableStreamConsumerStreamTerminalPushableStreamConsumer<T, Optional<T>> {

    static <T> PushableStreamConsumerStreamTerminalFindFirstOrderedPushableStreamConsumer<T> with(final PushableStreamConsumerCloseableCollection closeables) {
        return new PushableStreamConsumerStreamTerminalFindFirstOrderedPushableStreamConsumer<>(closeables);
    }

    /**
     * Package private to limit sub classing.
     */
    private PushableStreamConsumerStreamTerminalFindFirstOrderedPushableStreamConsumer(final PushableStreamConsumerCloseableCollection closeables) {
        super(closeables);
    }

    /**
     * Find first stops once something is found.
     */
    @Override
    public boolean isFinished() {
        return this.found;
    }

    @Override
    public void accept(final T value) {
        if(this.found) {
            throw new StreamException("First already found: " + CharSequences.quoteIfChars(this.first) + " new find: " + CharSequences.quoteIfChars(value));
        }
        this.first = value;
        this.found = true;
    }

    /**
     * Returns whatever was found inside an {@link Optional}.
     */
    @Override
    Optional<T> result() {
        return Optional.ofNullable(this.first);
    }

    private boolean found = false;
    private T first;

    @Override
    void buildToString1(final ToStringBuilder builder) {
        builder.value("findFirstOrdered");
    }
}
