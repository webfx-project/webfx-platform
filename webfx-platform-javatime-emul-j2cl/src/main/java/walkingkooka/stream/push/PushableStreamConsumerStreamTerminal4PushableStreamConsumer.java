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
import walkingkooka.ToStringBuilderOption;

import java.util.Objects;
import java.util.function.BiFunction;

/**
 * Base class for both REDUCE terminators {@link PushableStreamConsumer}.
 */
abstract class PushableStreamConsumerStreamTerminal4PushableStreamConsumer<T, R> extends PushableStreamConsumerStreamTerminalPushableStreamConsumer<T, R> {

    static void checkReducer(final BiFunction<?, ?, ?> reducer) {
         Objects.requireNonNull(reducer,"reducer");
    }

    /**
     * Package private to limit sub classing.
     */
    PushableStreamConsumerStreamTerminal4PushableStreamConsumer(final T initial,
                                                                final BiFunction<T, ? super T, T> reducer,
                                                                final PushableStreamConsumerCloseableCollection closeables) {
        super(closeables);
        this.value = initial;
        this.reducer = reducer;
    }

    /**
     * REDUCE want to process all values.
     */
    @Override
    public final boolean isFinished() {
        return false;
    }

    final BiFunction<T, ? super T, T> reducer;

    T value;

    @Override
    final void buildToString1(final ToStringBuilder builder) {
        builder.label("reduce");
        builder.value(this.reducer);

        if (this.isValuePresent()) {
            builder.enable(ToStringBuilderOption.QUOTE);
            builder.value(this.value);
        }
    }

    abstract boolean isValuePresent();
}
