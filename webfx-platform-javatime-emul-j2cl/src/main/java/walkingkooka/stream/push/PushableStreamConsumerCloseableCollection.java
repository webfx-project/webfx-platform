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

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Holds all the {@link Runnable closeables} added to a {@link Stream}.
 */
abstract class PushableStreamConsumerCloseableCollection implements AutoCloseable, UsesToStringBuilder {

    /**
     * {@see PushableStreamConsumerCloseableCollectionEmpty}.
     */
    static PushableStreamConsumerCloseableCollection empty() {
        return PushableStreamConsumerCloseableCollectionEmpty.INSTANCE;
    }

    PushableStreamConsumerCloseableCollection() {
        super();
    }

    final PushableStreamConsumerCloseableCollectionNonEmpty add(final Runnable closeable) {
        Objects.requireNonNull(closeable, "closeable");
        return this.add0(closeable);
    }

    /**
     * Sub classes will accept a new {@link Runnable} and eventually create a {@link PushableStreamConsumerCloseableCollectionNonEmpty} with a new {@link List}.
     */
    abstract PushableStreamConsumerCloseableCollectionNonEmpty add0(final Runnable closeable);

    @Override
    public abstract void close();

    @Override
    public String toString() {
        return ToStringBuilder.buildFrom(this);
    }
}
