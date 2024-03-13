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

import java.util.function.BiFunction;

/**
 * The REDUCE terminator {@link PushableStreamConsumer}.
 */
final class PushableStreamConsumerStreamTerminal4InitialAccumulatorPushableStreamConsumer<T> extends PushableStreamConsumerStreamTerminal4PushableStreamConsumer<T, T> {

    /**
     * Creates a new {@link PushableStreamConsumerStreamTerminal4InitialAccumulatorPushableStreamConsumer} without a combiner.
     */
    static <T> PushableStreamConsumerStreamTerminal4InitialAccumulatorPushableStreamConsumer<T> with(final T initial,
                                                                                                     final BiFunction<T, ? super T, T> reducer,
                                                                                                     final PushableStreamConsumerCloseableCollection closeables) {
        checkReducer(reducer);

        return new PushableStreamConsumerStreamTerminal4InitialAccumulatorPushableStreamConsumer<>(initial, reducer, closeables);
    }

    /**
     * Private use factory
     */
    private PushableStreamConsumerStreamTerminal4InitialAccumulatorPushableStreamConsumer(final T initial,
                                                                                          final BiFunction<T, ? super T, T> reducer,
                                                                                          final PushableStreamConsumerCloseableCollection closeables) {
        super(initial, reducer, closeables);
    }

    @Override
    public void accept(final T value) {
        this.value = this.reducer.apply(this.value, value);
    }

    /**
     * Returns the REDUCE result if any is present.
     */
    @Override
    T result() {
        return this.value;
    }

    @Override
    boolean isValuePresent() {
        return true; // always
    }
}
