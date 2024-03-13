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

abstract class ToStringBuilderAppenderVector<V> extends ToStringBuilderAppender<V> {

    ToStringBuilderAppenderVector(final V value) {
        super(value);
    }

    @Override
    final boolean shouldSkip(final ToStringBuilder builder) {
        return false == builder.option(ToStringBuilderOption.INLINE_ELEMENTS) ||
                (this.isEmpty() && builder.option(ToStringBuilderOption.SKIP_IF_DEFAULT_VALUE));
    }

    /**
     * Sub classes should return true if the array, collection etc is empty.
     */
    abstract boolean isEmpty();

    @Override
    final String before(final ToStringBuilder builder) {
        final String before = builder.before;
        if (null != before) {
            builder.buffer.append(before);
        }
        return builder.after;
    }

    @Override
    final void after(final String after, final ToStringBuilder builder) {
        if (null != after) {
            builder.append(after);
        }
    }
}
