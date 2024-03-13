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
import walkingkooka.visit.Visitor;

import java.util.Objects;

/**
 * A {@link Visitor} to visit a {@link Class} hierarchy, ignoring generics
 */
public abstract class ClassVisitor extends Visitor<Class<?>> {

    protected ClassVisitor() {
        super();
    }

    public final void accept(final Class<?> classs) {
        Objects.requireNonNull(classs, "classs");

        this.traverseClass(classs);
    }

    // Class............................................................................................................

    private void traverseClass(final Class<?> classs) {
        if (Visiting.CONTINUE == this.startVisitClass(classs)) {
            this.traverseSuperClass(classs);
            this.traverseImplementedInterface(classs);
            this.traverseArrayComponent(classs.getComponentType());
        }
        this.endVisitClass(classs);
    }

    protected Visiting startVisitClass(final Class<?> classs) {
        return Visiting.CONTINUE;
    }

    protected void endVisitClass(final Class<?> classs) {
        // nop
    }

    // Array component classs.............................................................................................

    private void traverseArrayComponent(final Class<?> classs) {
        if (null != classs) {
            if (Visiting.CONTINUE == this.startVisitArrayComponent(classs)) {
                this.traverseClass(classs);
            }
            this.endVisitArrayComponent(classs);
        }
    }

    protected Visiting startVisitArrayComponent(final Class<?> classs) {
        return Visiting.CONTINUE;
    }

    protected void endVisitArrayComponent(final Class<?> classs) {
        // nop
    }

    // SuperClass.......................................................................................................

    private void traverseSuperClass(final Class<?> classs) {
        if (Object.class != classs) {
            final Class<?> superClass = classs.getSuperclass();
            if(null!=superClass) {
                if (Visiting.CONTINUE == this.startVisitSuperClass(superClass)) {
                    this.traverseClass(superClass);
                }
                this.endVisitSuperClass(superClass);
            }
        }
    }

    protected Visiting startVisitSuperClass(final Class<?> classs) {
        return Visiting.CONTINUE;
    }

    protected void endVisitSuperClass(final Class<?> classs) {
        // nop
    }

    // Implemented interfaces...........................................................................................

    private void traverseImplementedInterface(final Class<?> classs) {
        for (Class<?> implemented : classs.getInterfaces()) {
            if (Visiting.CONTINUE == this.startVisitImplementedInterface(implemented)) {
                this.traverseClass(implemented);
            }
            this.endVisitImplementedInterface(implemented);
        }
    }

    protected Visiting startVisitImplementedInterface(final Class<?> classs) {
        return Visiting.CONTINUE;
    }

    protected void endVisitImplementedInterface(final Class<?> classs) {
        // nop
    }
}
