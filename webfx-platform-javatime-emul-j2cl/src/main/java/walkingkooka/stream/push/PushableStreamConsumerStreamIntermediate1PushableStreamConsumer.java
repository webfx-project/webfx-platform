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

/**
 * Base class for both LIMIT or SKIP.
 */
abstract class PushableStreamConsumerStreamIntermediate1PushableStreamConsumer<T> extends PushableStreamConsumerStreamIntermediatePushableStreamConsumer<T> {

    PushableStreamConsumerStreamIntermediate1PushableStreamConsumer(final long limitOrSkip,
                                                                    final PushableStreamConsumer<T> next) {
        super(next);
        this.limitOrSkip = limitOrSkip;
    }

    /**
     * The counter. This is incremented each time a value is accepted.
     */
    long counter = 0;

    /**
     * Skip or limit terminal value.
     */
    final long limitOrSkip;

    // Object...........................................................................................................

    @Override
    final void buildToString1(final ToStringBuilder builder) {
        final long counter = this.counter;
        final long limitOrSkip = this.limitOrSkip;

        if(counter < limitOrSkip) {
            builder.value(this.label() + " " + counter + "/" + limitOrSkip);
        }
    }

    abstract String label();
}
