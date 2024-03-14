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

import java.util.function.Predicate;

/**
 * Base class for any terminal that includes a {@link Predicate} {@link PushableStreamConsumer}.
 */
abstract class PushableStreamConsumerStreamTerminal3PushableStreamConsumer<T> extends PushableStreamConsumerStreamTerminalPushableStreamConsumer<T, Boolean> {

    /**
     * Package private to limit sub classing.
     */
    PushableStreamConsumerStreamTerminal3PushableStreamConsumer(final boolean result,
                                                                final Predicate<? super T> predicate,
                                                                final PushableStreamConsumerCloseableCollection closeables) {
        super(closeables);

        this.result = result;
        this.predicate = predicate;
    }

    /**
     * Returns the result;
     */
    @Override
    final Boolean result() {
        return this.result;
    }

    final Predicate<? super T> predicate;

    boolean result;

    @Override
    final void buildToString1(final ToStringBuilder builder) {
        builder.label(this.label());
        builder.value(this.predicate);

        builder.disable(ToStringBuilderOption.SKIP_IF_DEFAULT_VALUE);
        builder.value(this.result);
    }

    abstract String label();
}
