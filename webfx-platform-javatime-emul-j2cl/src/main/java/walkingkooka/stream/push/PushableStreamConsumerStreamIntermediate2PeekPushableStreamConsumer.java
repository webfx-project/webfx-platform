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

final class PushableStreamConsumerStreamIntermediate2PeekPushableStreamConsumer<T> extends PushableStreamConsumerStreamIntermediate2PushableStreamConsumer<T> {

    static <T> PushableStreamConsumerStreamIntermediate2PeekPushableStreamConsumer<T> with(final Consumer<T> action,
                                                                                           final PushableStreamConsumer<T> next) {
        return new PushableStreamConsumerStreamIntermediate2PeekPushableStreamConsumer<>(action, next);
    }

    private PushableStreamConsumerStreamIntermediate2PeekPushableStreamConsumer(final Consumer<T> action,
                                                                                final PushableStreamConsumer<T> next) {
        super(next);
        this.action = action;
    }

    @Override
    public boolean isFinished() {
        return this.next.isFinished();
    }

    @Override
    public void accept(final T value) {
        this.action.accept(value);
        this.next.accept(value);
    }

    private final Consumer<T> action;

    // Object...........................................................................................................

    @Override
    void buildToString1(final ToStringBuilder builder) {
        builder.label("peek");
        builder.value(this.action);
    }
}
