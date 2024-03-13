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

/**
 * The SKIP {@link PushableStreamConsumerStream}
 */
final class PushableStreamConsumerStreamIntermediate1Skip extends PushableStreamConsumerStreamIntermediate1 {

    static PushableStreamConsumerStreamIntermediate1Skip with(final long skip) {
        if (skip < 0) {
            throw new IllegalArgumentException("Skip " + skip + " < 0");
        }
        return new PushableStreamConsumerStreamIntermediate1Skip(skip);
    }

    private PushableStreamConsumerStreamIntermediate1Skip(final long skip) {
        super(skip);
    }

    @Override
    PushableStreamConsumerStreamIntermediatePushableStreamConsumer<?> createWithNext(final PushableStreamConsumer<?> next) {
        return PushableStreamConsumerStreamIntermediatePushableStreamConsumer.skip(this.value, next);
    }

    @Override
    long limit() {
        return NOT_LIMIT_OR_SKIP;
    }

    @Override
    long skip() {
        return this.value;
    }

    @Override
    boolean canBeEqual(final Object other) {
        return other instanceof PushableStreamConsumerStreamIntermediate1Skip;
    }

    @Override
    String label() {
        return "skip";
    }
}
