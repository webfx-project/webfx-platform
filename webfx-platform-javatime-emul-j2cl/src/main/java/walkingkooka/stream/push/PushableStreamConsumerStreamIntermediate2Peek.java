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

import java.util.Objects;
import java.util.function.Consumer;

/**
 * The PEEK {@link PushableStreamConsumerStream}
 */
@SuppressWarnings("lgtm[java/inconsistent-equals-and-hashcode]")
final class PushableStreamConsumerStreamIntermediate2Peek extends PushableStreamConsumerStreamIntermediate2 {

    static PushableStreamConsumerStreamIntermediate2Peek with(final Consumer<?> action) {
        Objects.requireNonNull(action, "action");

        return new PushableStreamConsumerStreamIntermediate2Peek(action);
    }

    private PushableStreamConsumerStreamIntermediate2Peek(final Consumer<?> action) {
        super();
        this.action = action;
    }

    @Override
    PushableStreamConsumerStreamIntermediatePushableStreamConsumer<?> createWithNext(final PushableStreamConsumer<?> next) {
        return PushableStreamConsumerStreamIntermediatePushableStreamConsumer.peek(Cast.to(this.action), next);
    }

    private final Consumer<?> action;

    // Object..........................................................................................................

    @Override
    public int hashCode() {
        return this.action.hashCode();
    }

    @Override
    boolean canBeEqual(final Object other) {
        return other instanceof PushableStreamConsumerStreamIntermediate2Peek;
    }

    @Override
    boolean equals0(final Object other) {
        return this.equals1(Cast.to(other));
    }

    private boolean equals1(final PushableStreamConsumerStreamIntermediate2Peek other) {
        return this.action.equals(other.action);
    }

    @Override
    public String toString() {
        return "peek " + this.action;
    }
}
