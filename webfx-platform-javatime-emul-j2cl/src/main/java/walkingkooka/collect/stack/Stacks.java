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

package walkingkooka.collect.stack;

import walkingkooka.reflect.PublicStaticHelper;

final public class Stacks implements PublicStaticHelper {

    /**
     * {@see ArrayStack}.
     */
    public static <T> Stack<T> array() {
        return EmptyArrayStack.instance();
    }

    /**
     * {@see ArrayListStack}.
     */
    public static <T> Stack<T> arrayList() {
        return ArrayListStack.create();
    }

    /**
     * {@see FakeStack}.
     */
    public static <T> Stack<T> fake() {
        return FakeStack.create();
    }

    /**
     * {@see JdkStackStack}
     */
    public static <T> Stack<T> jdk() {
        return JdkStackStack.create();
    }

    /**
     * {@see ReadOnlyStack}
     */
    public static <T> Stack<T> readOnly(final Stack<T> stack) {
        return ReadOnlyStack.wrap(stack);
    }

    /**
     * {@see UnreadableStack}
     */
    public static <T> Stack<T> unreadable(final Stack<T> stack) {
        return UnreadableStack.wrap(stack);
    }

    /**
     * Stop creation
     */
    private Stacks() {
        throw new UnsupportedOperationException();
    }
}
