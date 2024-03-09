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

import walkingkooka.Cast;
import walkingkooka.ToStringBuilder;

import java.util.function.Function;

final class PushableStreamConsumerStreamIntermediate2MapPushableStreamConsumer<T> extends PushableStreamConsumerStreamIntermediate2PushableStreamConsumer<T> {

    static <T> PushableStreamConsumerStreamIntermediate2MapPushableStreamConsumer<T> with(final Function<T, ?> mapper,
                                                                                          final PushableStreamConsumer<T> next) {
        return new PushableStreamConsumerStreamIntermediate2MapPushableStreamConsumer<>(mapper, next);
    }

    private PushableStreamConsumerStreamIntermediate2MapPushableStreamConsumer(final Function<T, ?> mapper,
                                                                               final PushableStreamConsumer<T> next) {
        super(next);
        this.mapper = mapper;
    }

    @Override
    public boolean isFinished() {
        return this.next.isFinished();
    }

    @Override
    public void accept(final T value) {
        this.next.accept(Cast.to(this.mapper.apply(value)));
    }

    private final Function<T, ?> mapper;

    // Object...........................................................................................................

    @Override
    void buildToString1(final ToStringBuilder builder) {
        builder.label("map");
        builder.value(this.mapper);
    }
}
