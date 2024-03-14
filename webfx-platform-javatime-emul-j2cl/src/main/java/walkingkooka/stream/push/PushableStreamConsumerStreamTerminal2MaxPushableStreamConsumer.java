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

import java.util.Comparator;

/**
 * The MAX TERMINAL {@link PushableStreamConsumerStreamTerminalPushableStreamConsumer}.
 */
final class PushableStreamConsumerStreamTerminal2MaxPushableStreamConsumer<T> extends PushableStreamConsumerStreamTerminal2PushableStreamConsumer<T> {
    /**
     * Package private to limit sub classing.
     */
    static <T> PushableStreamConsumerStreamTerminal2MaxPushableStreamConsumer<T> with(final Comparator<? super T> comparator,
                                                                                      final PushableStreamConsumerCloseableCollection closeables) {
        check(comparator);

        return new PushableStreamConsumerStreamTerminal2MaxPushableStreamConsumer<>(comparator, closeables);
    }

    /**
     * Package private to limit sub classing.
     */
    private PushableStreamConsumerStreamTerminal2MaxPushableStreamConsumer(final Comparator<? super T> comparator,
                                                                           final PushableStreamConsumerCloseableCollection closeables) {
        super(comparator, closeables);
    }

    @Override
    T compare(final int compare,
              final T previous,
              final T value) {
        return compare > 0 ? previous : value;
    }

    @Override
    String label() {
        return "max";
    }
}
