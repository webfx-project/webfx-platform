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

import java.util.EnumSet;

/**
 * The state captured by {@link ToStringBuilder#saveState()}
 */
final class ToStringBuilderSaveStateRunnable implements Runnable {

    static ToStringBuilderSaveStateRunnable with(final String labelSeparator,
                                                 final EnumSet<ToStringBuilderOption> options,
                                                 final String separator,
                                                 final String valueSeparator,
                                                 final ToStringBuilder builder) {
        return new ToStringBuilderSaveStateRunnable(labelSeparator,
                options,
                separator,
                valueSeparator,
                builder);
    }

    private ToStringBuilderSaveStateRunnable(final String labelSeparator,
                                             final EnumSet<ToStringBuilderOption> options,
                                             final String separator,
                                             final String valueSeparator,
                                             final ToStringBuilder builder) {
        super();
        this.labelSeparator = labelSeparator;
        this.options = options.clone();
        this.separator = separator;
        this.valueSeparator = valueSeparator;

        this.builder = builder;
    }

    @Override
    public void run() {
        this.builder.restoreState(this.labelSeparator, this.options, this.separator, valueSeparator);
    }

    private final String labelSeparator;

    private final EnumSet<ToStringBuilderOption> options;

    private final String separator;

    private final String valueSeparator;

    private final ToStringBuilder builder;

    @Override
    public String toString() {
        return ToStringBuilder.empty()
                .label("labelSeparator").value(this.labelSeparator)
                .label("options").value(this.options)
                .label("separator").value(this.separator)
                .label("valueSeparator").value(this.valueSeparator)
                .build();
    }
}
