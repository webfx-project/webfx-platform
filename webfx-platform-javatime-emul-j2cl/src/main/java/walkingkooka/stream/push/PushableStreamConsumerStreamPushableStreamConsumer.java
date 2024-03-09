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
import walkingkooka.UsesToStringBuilder;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * Base class for all {@link PushableStreamConsumer} including those returned by {@link PushableStreamConsumerStreamIntermediate#createWithNext(PushableStreamConsumer)}.
 */
abstract class PushableStreamConsumerStreamPushableStreamConsumer<T> implements PushableStreamConsumer<T>,
        UsesToStringBuilder {

    /**
     * {@see PushableStreamConsumerStreamTerminal3AllMatchPushableStreamConsumer}
     */
    static <T> PushableStreamConsumerStreamTerminal3AllMatchPushableStreamConsumer<T> allMatch(final Predicate<? super T> predicate,
                                                                                               final PushableStreamConsumerCloseableCollection closeables) {
        return PushableStreamConsumerStreamTerminal3AllMatchPushableStreamConsumer.with(predicate, closeables);
    }
    
    /**
     * {@see PushableStreamConsumerStreamTerminal3AnyMatchPushableStreamConsumer}
     */
    static <T> PushableStreamConsumerStreamTerminal3AnyMatchPushableStreamConsumer<T> anyMatch(final Predicate<? super T> predicate,
                                                                                               final PushableStreamConsumerCloseableCollection closeables) {
        return PushableStreamConsumerStreamTerminal3AnyMatchPushableStreamConsumer.with(predicate, closeables);
    }

    /**
     * {@see PushableStreamConsumerStreamTerminalCollectorPushableStreamConsumer}
     */
    static <T, A, R> PushableStreamConsumerStreamTerminalCollectorPushableStreamConsumer<T, A, R> collector(final Collector<? super T, A, R> collector,
                                                                                                            final PushableStreamConsumerCloseableCollection closeables) {
        return PushableStreamConsumerStreamTerminalCollectorPushableStreamConsumer.with(collector, closeables);
    }

    /**
     * {@see PushableStreamConsumerStreamTerminalCountPushableStreamConsumer}
     */
    static <T> PushableStreamConsumerStreamTerminalCountPushableStreamConsumer<T> count(final PushableStreamConsumerCloseableCollection closeables) {
        return PushableStreamConsumerStreamTerminalCountPushableStreamConsumer.with(closeables);
    }

    /**
     * {@see PushableStreamConsumerStreamIntermediate2FilterPushableStreamConsumer}
     */
    static <T> PushableStreamConsumerStreamIntermediate2FilterPushableStreamConsumer<T> filter(final Predicate<T> predicate,
                                                                                               final PushableStreamConsumer<T> next) {
        return PushableStreamConsumerStreamIntermediate2FilterPushableStreamConsumer.with(predicate, next);
    }

    /**
     * {@see PushableStreamConsumerStreamTerminalFindFirstOrderedPushableStreamConsumer}
     */
    static <T> PushableStreamConsumerStreamTerminalFindFirstOrderedPushableStreamConsumer<T> findFirst(final PushableStreamConsumerCloseableCollection closeables) {
        return PushableStreamConsumerStreamTerminalFindFirstOrderedPushableStreamConsumer.with(closeables);
    }

    /**
     * {@see PushableStreamConsumerStreamIntermediate2FlatMapPushableStreamConsumer}
     */
    static <T, R> PushableStreamConsumerStreamIntermediate2FlatMapPushableStreamConsumer<T, R> flatMap(final Function<? super T, ? extends Stream<? extends R>> mapper,
                                                                                                       final PushableStreamConsumer<T> next) {
        return PushableStreamConsumerStreamIntermediate2FlatMapPushableStreamConsumer.with(mapper, next);
    }

    /**
     * {@see PushableStreamConsumerStreamTerminalForEachOrderedPushableStreamConsumer}
     */
    static <T> PushableStreamConsumerStreamTerminalForEachOrderedPushableStreamConsumer<T> forEach(final Consumer<? super T> action,
                                                                                                   final PushableStreamConsumerCloseableCollection closeables) {
        return PushableStreamConsumerStreamTerminalForEachOrderedPushableStreamConsumer.with(action, closeables);
    }

    /**
     * {@see PushableStreamConsumerStreamIntermediate1LimitPushableStreamConsumer}
     */
    static <T> PushableStreamConsumerStreamIntermediate1LimitPushableStreamConsumer<T> limit(final long skip,
                                                                                             final PushableStreamConsumer<T> next) {
        return PushableStreamConsumerStreamIntermediate1LimitPushableStreamConsumer.with(skip, next);
    }

    /**
     * {@see PushableStreamConsumerStreamIntermediate2MapPushableStreamConsumer}
     */
    static <T> PushableStreamConsumerStreamIntermediate2MapPushableStreamConsumer<T> map(final Function<T, ?> mapper,
                                                                                         final PushableStreamConsumer<T> next) {
        return PushableStreamConsumerStreamIntermediate2MapPushableStreamConsumer.with(mapper, next);
    }

    /**
     * {@see PushableStreamConsumerStreamTerminal2MaxPushableStreamConsumer}
     */
    static <T> PushableStreamConsumerStreamTerminal2MaxPushableStreamConsumer<T> max(final Comparator<? super T> comparator,
                                                                                     final PushableStreamConsumerCloseableCollection closeables) {
        return PushableStreamConsumerStreamTerminal2MaxPushableStreamConsumer.with(comparator, closeables);
    }

    /**
     * {@see PushableStreamConsumerStreamTerminal2MinPushableStreamConsumer}
     */
    static <T> PushableStreamConsumerStreamTerminal2MinPushableStreamConsumer<T> min(final Comparator<? super T> comparator,
                                                                                     final PushableStreamConsumerCloseableCollection closeables) {
        return PushableStreamConsumerStreamTerminal2MinPushableStreamConsumer.with(comparator, closeables);
    }

    /**
     * {@see PushableStreamConsumerStreamTerminal3NoneMatchPushableStreamConsumer}
     */
    static <T> PushableStreamConsumerStreamTerminal3NoneMatchPushableStreamConsumer<T> noneMatch(final Predicate<? super T> predicate,
                                                                                                 final PushableStreamConsumerCloseableCollection closeables) {
        return PushableStreamConsumerStreamTerminal3NoneMatchPushableStreamConsumer.with(predicate, closeables);
    }
    
    /**
     * {@see PushableStreamConsumerStreamIntermediate2PeekPushableStreamConsumer}
     */
    static <T> PushableStreamConsumerStreamIntermediate2PeekPushableStreamConsumer<T> peek(final Consumer<T> consumer,
                                                                                           final PushableStreamConsumer<T> next) {
        return PushableStreamConsumerStreamIntermediate2PeekPushableStreamConsumer.with(consumer, next);
    }

    /**
     * {@see PushableStreamConsumerStreamTerminal4AccumulatorPushableStreamConsumer}
     */
    static <T> PushableStreamConsumerStreamTerminal4AccumulatorPushableStreamConsumer<T> reduce(final BiFunction<T, ? super T, T> reducer,
                                                                                                final PushableStreamConsumerCloseableCollection closeables) {
        return PushableStreamConsumerStreamTerminal4AccumulatorPushableStreamConsumer.with(reducer, closeables);
    }

    /**
     * {@see PushableStreamConsumerStreamTerminal4InitialAccumulatorPushableStreamConsumer}
     */
    static <T> PushableStreamConsumerStreamTerminal4InitialAccumulatorPushableStreamConsumer<T> reduceWithInitial(final T initial,
                                                                                                                  final BiFunction<T, ? super T, T> reducer,
                                                                                                                  final PushableStreamConsumerCloseableCollection closeables) {
        return PushableStreamConsumerStreamTerminal4InitialAccumulatorPushableStreamConsumer.with(initial, reducer, closeables);
    }

    /**
     * {@see PushableStreamConsumerStreamIntermediate1SkipPushableStreamConsumer}
     */
    static <T> PushableStreamConsumerStreamIntermediate1SkipPushableStreamConsumer<T> skip(final long skip,
                                                                                           final PushableStreamConsumer<T> next) {
        return PushableStreamConsumerStreamIntermediate1SkipPushableStreamConsumer.with(skip, next);
    }

    /**
     * Package private to limit sub classing.
     */
    PushableStreamConsumerStreamPushableStreamConsumer() {
        super();
    }

    // Object...........................................................................................................

    @Override
    public final String toString() {
        return ToStringBuilder.buildFrom(this);
    }

    @Override
    public final void buildToString(final ToStringBuilder builder) {
        builder.labelSeparator(" ");
        builder.separator(" ");
        builder.disable(ToStringBuilderOption.QUOTE);

        this.buildToString0(builder);
    }

    abstract void buildToString0(final ToStringBuilder builder);
}