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

final class PushableStreamConsumerStreamIntermediate1LimitPushableStreamConsumer<T> extends PushableStreamConsumerStreamIntermediate1PushableStreamConsumer<T> {

    static <T> PushableStreamConsumerStreamIntermediate1LimitPushableStreamConsumer<T> with(final long skip,
                                                                                            final PushableStreamConsumer<T> next) {
        return new PushableStreamConsumerStreamIntermediate1LimitPushableStreamConsumer<>(skip, next);
    }

    private PushableStreamConsumerStreamIntermediate1LimitPushableStreamConsumer(final long skip,
                                                                                 final PushableStreamConsumer<T> next) {
        super(skip, next);
    }

    @Override
    public boolean isFinished() {
        return this.counter >= this.limitOrSkip || this.next.isFinished();
    }

    @Override
    public void accept(final T value) {
        this.next.accept(value);
        this.counter++;
    }

    // Object...........................................................................................................

    @Override
    String label() {
        return "limit";
    }
}
