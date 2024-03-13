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

package walkingkooka.naming;

import walkingkooka.collect.list.Lists;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * An {@link Iterator} that walks starting at the given {@link Path} to the root.
 */
final class PathIterator<P extends Path<P, N>, N extends Name> implements Iterator<N> {

    static <P extends Path<P, N>, N extends Name> PathIterator<P, N> with(final Path<P, N> path) {
        return new PathIterator<>(path);
    }

    private PathIterator(final Path<P, N> path) {
        super();

        this.components = Lists.array();

        this.visitParent(path);

        this.cursor = 0;
        this.separator = path.separator();
    }

    private void visitParent(final Path<P, N> path) {
        final Optional<P> parent = path.parent();
        parent.ifPresent(this::visitParent);
        this.components.add(path.name());
    }

    @Override
    public boolean hasNext() {
        return this.cursor < this.components.size();
    }

    @Override
    public N next() {
        final int cursor = this.cursor;
        final List<N> components = this.components;
        if (cursor >= components.size()) {
            throw new NoSuchElementException();
        }
        this.cursor = cursor + 1;
        return components.get(cursor);
    }

    /**
     * All components in first to last path order, where first is the root and last is the deepest.
     */
    private final List<N> components;

    /**
     * Pointer to the current path component, counting forwards through the elements in {@link #components}.
     */
    private int cursor;

    /**
     * Returns a view of the remaining path components, an empty {@link String} will be returned when the iterator is exhausted.
     */
    @Override
    public String toString() {
        return IntStream.range(this.cursor, this.components.size())
                .mapToObj(this::element)
                .collect(Collectors.joining(this.separator.string()));
    }

    private String element(final int i) {
        return this.components.get(i).value();
    }

    private final PathSeparator separator;
}
