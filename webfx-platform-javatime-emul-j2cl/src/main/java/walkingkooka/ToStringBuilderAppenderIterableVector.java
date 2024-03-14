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

package walkingkooka;

import java.util.Iterator;

final class ToStringBuilderAppenderIterableVector extends ToStringBuilderAppenderVector<Iterable<?>> {

    static ToStringBuilderAppenderIterableVector with(final Iterable<?> value) {
        return new ToStringBuilderAppenderIterableVector(value);
    }

    private ToStringBuilderAppenderIterableVector(final Iterable<?> value) {
        super(value);
        this.iterator = value.iterator();
    }

    @Override
    void append0(final ToStringBuilder builder) {
        this.appendLabelBeforeValueAfterPostEmptyCheck(builder);
    }

    @Override
    boolean isEmpty() {
        return null == this.value || !this.iterator.hasNext();
    }

    @Override
    void value(final ToStringBuilder builder) {
        final Iterator<?> from = this.iterator;
        boolean first = true;

        while (from.hasNext()) {
            if (!first) {
                builder.appendValueSeparator();
            }

            object(from.next()).value(builder);

            first = false;
        }
    }

    private final Iterator<?> iterator;
}
