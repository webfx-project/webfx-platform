/*
 * Copyright 2022 Miroslav Pokorny (github.com/mP1)
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

package walkingkooka.text.printer;

import walkingkooka.reflect.PublicStaticHelper;

final public class PrintedLineHandlers implements PublicStaticHelper {

    /**
     * {@see FakePrintedLineHandler}
     */
    public static PrintedLineHandler fake() {
        return FakePrintedLineHandler.create();
    }

    /**
     * {@see ContinuationCharacterInsertingPrintedLineHandler}.
     */
    public static PrintedLineHandler split(final int width, final char continuation) {
        return ContinuationCharacterInsertingPrintedLineHandler.with(width, continuation);
    }

    /**
     * Stop creation
     */
    private PrintedLineHandlers() {
        throw new UnsupportedOperationException();
    }
}
