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

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Base class for all intermediate steps while building a {@link Stream} to terminal operation invocation.
 */
abstract class PushableStreamConsumerStreamIntermediate {

    /**
     * {@see PushableStreamConsumerStreamIntermediate2Filter}
     */
    static PushableStreamConsumerStreamIntermediate2Filter filter(final Predicate<?> predicate) {
        return PushableStreamConsumerStreamIntermediate2Filter.with(predicate);
    }

    /**
     * {@see PushableStreamConsumerStreamIntermediate2FlatMap}
     */
    static PushableStreamConsumerStreamIntermediate2FlatMap flatMap(final Function<?, Stream<?>> function) {
        return PushableStreamConsumerStreamIntermediate2FlatMap.with(function);
    }

    /**
     * {@see PushableStreamConsumerStreamIntermediate1Limit}
     */
    static PushableStreamConsumerStreamIntermediate1Limit limit(final long limit) {
        return PushableStreamConsumerStreamIntermediate1Limit.with(limit);
    }

    /**
     * {@see PushableStreamConsumerStreamIntermediate2Map}
     */
    static PushableStreamConsumerStreamIntermediate2Map map(final Function<?, ?> function) {
        return PushableStreamConsumerStreamIntermediate2Map.with(function);
    }

    /**
     * {@see PushableStreamConsumerStreamIntermediate2Peek}
     */
    static PushableStreamConsumerStreamIntermediate2Peek peek(final Consumer<?> consumer) {
        return PushableStreamConsumerStreamIntermediate2Peek.with(consumer);
    }

    /**
     * {@see PushableStreamConsumerStreamIntermediate1Skip}
     */
    static PushableStreamConsumerStreamIntermediate1Skip skip(final long skip) {
        return PushableStreamConsumerStreamIntermediate1Skip.with(skip);
    }

    PushableStreamConsumerStreamIntermediate() {
        super();
    }

    final static long NOT_LIMIT_OR_SKIP = -1;

    /**
     * Only {@link PushableStreamConsumerStreamIntermediate1Limit} will return a non zero value.
     */
    abstract long limit();

    /**
     * Only {@link PushableStreamConsumerStreamIntermediate1Skip} will return a non zero value.
     */
    abstract long skip();

    /**
     * Creates the {@link PushableStreamConsumer} with the given next {@link PushableStreamConsumer}.
     */
    abstract PushableStreamConsumerStreamIntermediatePushableStreamConsumer<?> createWithNext(PushableStreamConsumer<?> next);

    @Override
    public abstract int hashCode();

    @Override
    @SuppressWarnings({"EqualsWhichDoesntCheckParameterClass", "lgtm[java/inconsistent-equals-and-hashcode]"})
    public final boolean equals(final Object other) {
        return this == other || this.canBeEqual(other) && this.equals0(other);
    }

    abstract boolean canBeEqual(final Object other);

    abstract boolean equals0(final Object other);
}
