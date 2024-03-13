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

package walkingkooka.j2cl.java.io.string;

import walkingkooka.reflect.PublicStaticHelper;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.function.Consumer;

public final class StringDataInputDataOutput implements PublicStaticHelper {

    /**
     * {@see StringDataInput}
     */
    public static DataInput input(final String source) {
        return StringDataInput.with(source);
    }

    /**
     * {@see StringDataOutput}
     */
    public static DataOutput output(final Consumer<String> dest) {
        return StringDataOutput.with(dest);
    }

    /**
     * Stop creation.
     */
    private StringDataInputDataOutput() {
        throw new UnsupportedOperationException();
    }
}
