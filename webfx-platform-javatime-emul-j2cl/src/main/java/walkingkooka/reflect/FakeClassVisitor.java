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

package walkingkooka.reflect;

import walkingkooka.visit.Visiting;

public class FakeClassVisitor extends ClassVisitor {

    protected FakeClassVisitor() {
        super();
    }

    @Override
    protected Visiting startVisitClass(final Class<?> classs) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void endVisitClass(final Class<?> classs) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Visiting startVisitSuperClass(final Class<?> classs) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void endVisitSuperClass(final Class<?> classs) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Visiting startVisitImplementedInterface(final Class<?> classs) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void endVisitImplementedInterface(final Class<?> classs) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Visiting startVisitArrayComponent(final Class<?> classs) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void endVisitArrayComponent(final Class<?> classs) {
        throw new UnsupportedOperationException();
    }
}
