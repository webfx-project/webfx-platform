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

package walkingkooka.collect.list;

import java.util.ArrayList;

/**
 * An {@link ArrayList} that includes a {@link #set(int, Object)} that auto adds elements if the index if greater than
 * the current size.
 */
final class AutoExpandArrayList<T> extends ArrayList<T> {

    private static final long serialVersionUID = 4689842813565886828L;

    static <T> AutoExpandArrayList<T> empty() {
        return new AutoExpandArrayList<>();
    }

    private AutoExpandArrayList() {
        super();
    }

    public T get(final int index) {
        checkIndex(index);

        return index >= this.size() ?
                null :
                super.get(index);
    }

    @Override
    public T set(final int index, final T element) {
        final int size = this.size();
        checkIndex(index);

        final T replaced;
        if(index < size) {
            replaced = super.set(index, element);
        } else {
            while(index > this.size()) {
                this.add(null);
            }

            this.add(element);
            replaced = null;
        }
        return replaced;
    }

    private static void checkIndex(final int index) {
        if(index < 0) {
            throw new IndexOutOfBoundsException("Invalid index " + index + "< 0");
        }
    }
}
