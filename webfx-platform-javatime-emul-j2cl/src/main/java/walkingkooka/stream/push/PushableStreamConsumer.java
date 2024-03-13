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

import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * A bridge that accepts value that eventually appear in a {@link Stream}, but also provides feedback if the provider should short circuit and stop providing new values.
 */
public interface PushableStreamConsumer<T> extends Consumer<T>, AutoCloseable {

    /**
     * Factory that creates a {@link Stream} from the given {@link PushableStreamConsumer}.
     */
    static <T> Stream<T> stream(final Consumer<PushableStreamConsumer<T>> starter) {
        return PushableStreamConsumerStream.with(starter);
    }

    /**
     * Returns true if the {@link Stream} has completed and no more items should be pushed.
     * Reasons for finishing include a limit being satisfied.
     */
    boolean isFinished();

    /**
     * Closes or terminates this {@link PushableStreamConsumer}.
     * Unlike {@link AutoCloseable#close()} this version does not throw {@link Exception}.
     */
    @Override
    void close();
}
