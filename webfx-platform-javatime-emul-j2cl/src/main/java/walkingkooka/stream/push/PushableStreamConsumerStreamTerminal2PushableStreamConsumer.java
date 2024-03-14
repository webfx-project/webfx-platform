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

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

/**
 * MAX or MIN TERMINAL {@link PushableStreamConsumer}.
 */
abstract class PushableStreamConsumerStreamTerminal2PushableStreamConsumer<T> extends PushableStreamConsumerStreamTerminalPushableStreamConsumer<T, Optional<T>> {

    static void check(final Comparator<?> comparator) {
        Objects.requireNonNull(comparator, "comparator");
    }

    /**
     * Package private to limit sub classing.
     */
    PushableStreamConsumerStreamTerminal2PushableStreamConsumer(final Comparator<? super T> comparator,
                                                                final PushableStreamConsumerCloseableCollection closeables) {
        super(closeables);
        this.comparator = comparator;
    }

    /**
     * Min/Max want to process all values.
     */
    @Override
    public final boolean isFinished() {
        return false;
    }

    @Override
    public final void accept(final T next) {
        final T previous = this.value;
        if (null == previous) {
            this.value = next;
        } else {
            this.value = this.compare(this.comparator.compare(previous, next),
                    previous,
                    next);
        }
    }

    private final Comparator<? super T> comparator;

    /**
     * Sub classes should perform the compare and return the max/min value.
     */
    abstract T compare(final int compareResult,
                       final T previous,
                       final T value);

    /**
     * Returns the MAX or MIN as determined by the comparator and given values.
     */
    @Override
    final Optional<T> result() {
        return Optional.ofNullable(this.value);
    }

    private T value;

    @Override
    final void buildToString1(final ToStringBuilder builder) {
        builder.label(this.label());
        builder.value(this.comparator);
        builder.value(this.value);
    }

    abstract String label();
}
