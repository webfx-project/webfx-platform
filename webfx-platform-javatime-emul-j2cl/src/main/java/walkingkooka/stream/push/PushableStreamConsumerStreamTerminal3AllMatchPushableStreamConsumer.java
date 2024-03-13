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

import walkingkooka.text.CharSequences;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * The ALL MATCH TERMINAL.
 */
final class PushableStreamConsumerStreamTerminal3AllMatchPushableStreamConsumer<T> extends PushableStreamConsumerStreamTerminal3PushableStreamConsumer<T> {

    static <T> PushableStreamConsumerStreamTerminal3AllMatchPushableStreamConsumer<T> with(final Predicate<? super T> predicate,
                                                                                           final PushableStreamConsumerCloseableCollection closeables) {
        Objects.requireNonNull(predicate, "predicate");

        return new PushableStreamConsumerStreamTerminal3AllMatchPushableStreamConsumer<>(predicate, closeables);
    }

    private PushableStreamConsumerStreamTerminal3AllMatchPushableStreamConsumer(final Predicate<? super T> predicate,
                                                                                final PushableStreamConsumerCloseableCollection closeables) {
        super(true, predicate, closeables);
    }

    /**
     * Stop whenever a predicate test fails.
     */
    @Override
    public boolean isFinished() {
        return false == this.result;
    }

    @Override
    public void accept(final T value) {
        if (false == this.predicate.test(value)) {
            if (false == this.result) {
                throw new PushStreamException("Second predicate failure, should have stopped after first, second value=" + CharSequences.quoteIfChars(value));
            }
            this.result = false;
        }
    }

    @Override
    String label() {
        return "allMatch";
    }
}
