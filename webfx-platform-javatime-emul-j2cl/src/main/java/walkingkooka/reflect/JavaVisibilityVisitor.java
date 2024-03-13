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

public class JavaVisibilityVisitor extends Visitor<JavaVisibility> {

    protected JavaVisibilityVisitor() {
        super();
    }

    @Override
    public final void accept(final JavaVisibility visibility) {
        Objects.requireNonNull(visibility, "visibility");
        this.accept0(visibility);
    }

    final void accept0(final JavaVisibility visibility) {
        if (Visiting.CONTINUE == this.startVisit(visibility)) {
            visibility.accept(this);
        }
        this.endVisit(visibility);
    }

    protected Visiting startVisit(final JavaVisibility visibility) {
        return Visiting.CONTINUE;
    }

    protected void endVisit(final JavaVisibility visibility) {
        // nop
    }

    protected void visitPublic() {
        // nop
    }

    protected void visitProtected() {
        // nop
    }

    protected void visitPackagePrivate() {
        // nop
    }

    protected void visitPrivate() {
        // nop
    }
}
