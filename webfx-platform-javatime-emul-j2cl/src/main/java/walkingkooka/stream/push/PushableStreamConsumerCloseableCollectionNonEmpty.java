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
import walkingkooka.collect.list.Lists;

import java.util.List;

/**
 * A {@link PushableStreamConsumerCloseableCollection} with at least one {@link Runnable}.
 */
final class PushableStreamConsumerCloseableCollectionNonEmpty extends PushableStreamConsumerCloseableCollection {

    static PushableStreamConsumerCloseableCollectionNonEmpty with(final List<Runnable> closeables) {
        return new PushableStreamConsumerCloseableCollectionNonEmpty(closeables);
    }

    private PushableStreamConsumerCloseableCollectionNonEmpty(final List<Runnable> closeables) {
        super();
        this.closeables = closeables;
    }

    @Override
    PushableStreamConsumerCloseableCollectionNonEmpty add0(final Runnable closeable) {
        final List<Runnable> copy = Lists.array();
        copy.addAll(this.closeables);
        copy.add(closeable);
        return new PushableStreamConsumerCloseableCollectionNonEmpty(copy);
    }

    @Override
    public void close() {
        if (false == this.closed) {
            try {
                this.closeOnce();
            } finally {
                this.closed = true;
            }
        }
    }

    private void closeOnce() {
        RuntimeException thrown = null;

        for (Runnable closeable : this.closeables) {
            try {
                closeable.run();
            } catch (final RuntimeException cause) {
                if (null == thrown) {
                    thrown = cause;
                } else {
                    thrown.addSuppressed(cause);
                }
            }
        }

        if (null != thrown) {
            throw thrown;
        }
    }

    private boolean closed;

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return this.closeables.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || other instanceof PushableStreamConsumerCloseableCollectionNonEmpty && this.equals0(Cast.to(other));
    }

    private boolean equals0(final PushableStreamConsumerCloseableCollectionNonEmpty other) {
        return this.closeables.equals(other.closeables) &&
                this.closed == other.closed;
    }

    @Override
    public void buildToString(final ToStringBuilder builder) {
        builder.valueSeparator(", ");
        builder.value(this.closeables);
    }

    // VisibleForTesting
    final List<Runnable> closeables;
}
