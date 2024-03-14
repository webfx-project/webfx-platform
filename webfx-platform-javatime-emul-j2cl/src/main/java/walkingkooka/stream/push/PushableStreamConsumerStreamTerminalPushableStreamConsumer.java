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
import walkingkooka.UsesToStringBuilder;

/**
 * Base class for all TERMINAL {@link PushableStreamConsumer}.
 */
abstract class PushableStreamConsumerStreamTerminalPushableStreamConsumer<T, R> extends PushableStreamConsumerStreamPushableStreamConsumer<T>
        implements UsesToStringBuilder {

    /**
     * Package private to limit sub classing.
     */
    PushableStreamConsumerStreamTerminalPushableStreamConsumer(final PushableStreamConsumerCloseableCollection closeables) {
        super();
        this.closeables = closeables;
    }

    /**
     * The result of the terminal operator, such as the count or collector result.
     */
    abstract R result();

    @Override
    public final void close() {
        this.closeables.close();
    }

    final PushableStreamConsumerCloseableCollection closeables;

    @Override
    final void buildToString0(final ToStringBuilder builder) {
        this.buildToString1(builder);

        builder.label("closeables");
        builder.labelSeparator(": ");
        builder.value(this.closeables);
        builder.labelSeparator(" ");
    }

    abstract void buildToString1(final ToStringBuilder builder);
}
