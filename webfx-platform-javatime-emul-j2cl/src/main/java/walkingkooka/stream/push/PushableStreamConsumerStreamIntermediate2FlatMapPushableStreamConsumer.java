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
import java.util.stream.Stream;

final class PushableStreamConsumerStreamIntermediate2FlatMapPushableStreamConsumer<T, R> extends PushableStreamConsumerStreamIntermediate2PushableStreamConsumer<T> {

    static <T, R> PushableStreamConsumerStreamIntermediate2FlatMapPushableStreamConsumer<T, R> with(final Function<? super T, ? extends Stream<? extends R>> mapper,
                                                                                                    final PushableStreamConsumer<T> next) {
        return new PushableStreamConsumerStreamIntermediate2FlatMapPushableStreamConsumer<>(mapper, next);
    }

    private PushableStreamConsumerStreamIntermediate2FlatMapPushableStreamConsumer(final Function<? super T, ? extends Stream<? extends R>> mapper,
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
        final Stream<T> stream = Cast.to(this.mapper.apply(value));
        if (null != stream) {
            stream.forEach(this.next);
        }
    }

    private final Function<? super T, ? extends Stream<? extends R>> mapper;

    // Object...........................................................................................................

    @Override
    void buildToString1(final ToStringBuilder builder) {
        builder.label("flatmap");
        builder.value(this.mapper);
    }
}
