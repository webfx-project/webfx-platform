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

import java.util.Optional;
import java.util.function.BiFunction;

/**
 * The REDUCE terminator {@link PushableStreamConsumer}.
 */
final class PushableStreamConsumerStreamTerminal4AccumulatorPushableStreamConsumer<T> extends PushableStreamConsumerStreamTerminal4PushableStreamConsumer<T, Optional<T>> {

    /**
     * Creates a new {@link PushableStreamConsumerStreamTerminal4AccumulatorPushableStreamConsumer} without a combiner.
     */
    static <T> PushableStreamConsumerStreamTerminal4AccumulatorPushableStreamConsumer<T> with(final BiFunction<T, ? super T, T> reducer,
                                                                                              final PushableStreamConsumerCloseableCollection closeables) {
        checkReducer(reducer);

        return new PushableStreamConsumerStreamTerminal4AccumulatorPushableStreamConsumer<>(reducer, closeables);
    }

    /**
     * Private use factory
     */
    private PushableStreamConsumerStreamTerminal4AccumulatorPushableStreamConsumer(final BiFunction<T, ? super T, T> reducer,
                                                                                   final PushableStreamConsumerCloseableCollection closeables) {
        super(null, reducer, closeables);
        this.empty = true;
    }


    @Override
    public void accept(final T value) {
        this.value = this.empty ?
                value :
                this.reducer.apply(this.value, value);
        this.empty = false;
    }

    private boolean empty;

    /**
     * Returns the REDUCE result if any is present.
     */
    @Override
    Optional<T> result() {
        return Optional.ofNullable(this.value);
    }

    @Override
    boolean isValuePresent() {
        return !this.empty;
    }
}
