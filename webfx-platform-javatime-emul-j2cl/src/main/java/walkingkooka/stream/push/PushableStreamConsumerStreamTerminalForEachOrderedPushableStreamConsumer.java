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

import java.util.function.Consumer;

/**
 * The FOREACH TERMINAL {@link PushableStreamConsumer}.
 */
final class PushableStreamConsumerStreamTerminalForEachOrderedPushableStreamConsumer<T> extends PushableStreamConsumerStreamTerminalPushableStreamConsumer<T, Void> {

    static <T> PushableStreamConsumerStreamTerminalForEachOrderedPushableStreamConsumer<T> with(final Consumer<? super T> action,
                                                                                                final PushableStreamConsumerCloseableCollection closeables) {
        return new PushableStreamConsumerStreamTerminalForEachOrderedPushableStreamConsumer<>(action, closeables);
    }

    /**
     * Package private to limit sub classing.
     */
    private PushableStreamConsumerStreamTerminalForEachOrderedPushableStreamConsumer(final Consumer<? super T> action,
                                                                                     final PushableStreamConsumerCloseableCollection closeables) {
        super(closeables);
        this.action = action;
    }

    /**
     * Count wants to count everything.
     */
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void accept(final T value) {
        this.action.accept(value);
    }

    private final Consumer<? super T> action;

    /**
     * For each returns nothing.
     */
    @Override
    Void result() {
        return null;
    }

    @Override
    void buildToString1(final ToStringBuilder builder) {
        builder.label("forEachOrdered");
        builder.value(this.action);
    }
}
