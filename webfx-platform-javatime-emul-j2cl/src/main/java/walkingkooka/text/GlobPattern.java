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

package walkingkooka.text;

import walkingkooka.collect.list.Lists;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Files contains a userful glob pattern support but unfortunatley it is not available for general {@link String} or
 * {@link CharSequence} matching.
 * <br>
 * <a href="https://en.wikipedia.org/wiki/Glob_(programming)">Glob</a>
 */
public final class GlobPattern implements Predicate<CharSequence> {

    static GlobPattern parse(final String pattern,
                             final char escape,
                             final CaseSensitivity caseSensitivity) {
        Objects.requireNonNull(pattern, "pattern");

        // special case if pattern is empty
        return pattern.isEmpty() ?
                caseSensitivity.emptyGlobPattern() :
                parseNonEmpty(pattern, escape, caseSensitivity);
    }

    final static GlobPattern EMPTY_CASE_SENSITIVE = empty(CaseSensitivity.SENSITIVE);

    final static GlobPattern EMPTY_CASE_INSENSITIVE = empty(CaseSensitivity.INSENSITIVE);

    private static GlobPattern empty(final CaseSensitivity caseSensitivity) {
        return new GlobPattern(
                GlobPatternComponent.SENTINEL,
                caseSensitivity,
                ""
        );
    }

    private static GlobPattern parseNonEmpty(final String pattern,
                                             final char escape,
                                             final CaseSensitivity caseSensitivity) {
        final List<GlobPatternComponent> components = Lists.array();
        final int length = pattern.length();

        final StringBuilder textLiteral = new StringBuilder();
        int min = 0;
        int max = 0;

        boolean escaped = false;

        for(int i = 0; i < length; i++) {
            final char c = pattern.charAt(i);
            if(escaped) {
                if(min > 0 || max > 0) {
                    components.add(
                            GlobPatternComponent.wildcard(min, max)
                    );
                    min = 0;
                    max = 0;
                    continue;
                }
                textLiteral.append(c);
                escaped = false;
                continue;
            }
            switch(c) {
                case '*':
                case '?':
                    addTextLiteralIfNecessary(
                            textLiteral,
                            components
                    );


                    if('*' ==c) {
                        max = Integer.MAX_VALUE;
                    } else {
                        min++;
                        if(max < Integer.MAX_VALUE) {
                            max++;
                        }
                    }
                    break;
                default:
                    escaped = escape == c;
                    if(!escaped) {
                        addWildcardIfNecessary(
                                min,
                                max,
                                components
                        );
                        min = 0;
                        max = 0;
                        textLiteral.append(c);
                    }
                    break;
            }
        }

        addTextLiteralIfNecessary(
                textLiteral,
                components
        );
        addWildcardIfNecessary(
                min,
                max,
                components
        );



        return new GlobPattern(
                setNext(components), // will never be null
                caseSensitivity,
                pattern
        );
    }

    private static void addTextLiteralIfNecessary(final StringBuilder textLiteral,
                                                  final List<GlobPatternComponent> components) {
        if(textLiteral.length() > 0) {
            components.add(
                    GlobPatternComponent.textLiteral(
                            textLiteral.toString()
                    )
            );

            textLiteral.setLength(0);
        }
    }

    private static void addWildcardIfNecessary(final int min,
                                               final int max,
                                               final List<GlobPatternComponent> components) {
        if(min > 0 || max > 0) {
            components.add(
                    GlobPatternComponent.wildcard(
                            min,
                            max
                    )
            );
        }
    }

    // @VisibleForTesting
    static GlobPatternComponent setNext(final List<GlobPatternComponent> components) {
        // setNext on all components
        GlobPatternComponent component = null;
        GlobPatternComponent next = GlobPatternComponent.SENTINEL;

        int i = components.size() - 1;
        while( i >= 0) {
            component = components.get(i);
            component.next = next;

            next = component;
            i--;
        }

        return component;
    }

    GlobPattern(final GlobPatternComponent first,
                final CaseSensitivity caseSensitivity,
                final String pattern) {
        super();
        this.first = first;
        this.caseSensitivity = caseSensitivity;
        this.pattern = pattern;
    }

    /**
     * Returns true if this pattern is actually just a text literal without any wildcards.
     */
    public boolean isOnlyTextLiteral() {
        return this.first.isOnlyTextLiteral();
    }

    // search..........................................................................................................

    /**
     * Attempts to locate the start of this pattern within the given text, returning -1 if none is found.
     */
    public int search(final CharSequence text,
                      final int startPos) {
        Objects.requireNonNull(text, "text");

        final int textLength = text.length();
        switch (textLength) {
            case 0:
                // startPos = 0 is ok for empty string.
                if (startPos < 0 || startPos > textLength) {
                    throw new StringIndexOutOfBoundsException("Invalid start " + startPos + " < 0 || > " + textLength);
                }
                break;
            default:
                if (startPos < 0 || startPos >= textLength) {
                    throw new StringIndexOutOfBoundsException("Invalid start " + startPos + " < 0 || >= " + textLength);
                }
                break;
        }

        int foundIndex = -1;

        final GlobPatternComponent first = this.first;
        final GlobPatternContext context = this.caseSensitivity.globPatternSearchContext;

        if (first.test(
                text,
                startPos,
                context)
        ) {
            foundIndex = startPos;
        } else {
            final int stop = textLength - first.searchMinLength();

            int tryingStartIndex = startPos;

            while (tryingStartIndex <= stop) {
                if (first.test(
                        text,
                        tryingStartIndex,
                        context)) {
                    foundIndex = tryingStartIndex;
                    break;
                }

                tryingStartIndex++;
            }
        }

        return foundIndex;
    }

    // Predicate.......................................................................................................

    @Override
    public boolean test(final CharSequence text) {
        Objects.requireNonNull(text, "text");

        return this.first.test(
                text,
                0,
                this.caseSensitivity.globPatternTestContext
        );
    }

    final GlobPatternComponent first;

    private final CaseSensitivity caseSensitivity;

    // Object..........................................................................................................

    @Override
    public int hashCode() {
        return Objects.hash(
                this.pattern,
                this.caseSensitivity
        );
    }

    @Override
    public boolean equals(final Object other) {
        return other == this || other instanceof GlobPattern && this.equals0((GlobPattern)other);
    }

    private boolean equals0(final GlobPattern other) {
        return this.pattern.equals(other.pattern) &&
                this.caseSensitivity == other.caseSensitivity;
    }

    @Override
    public String toString() {
        return CharSequences.quoteAndEscape(this.pattern) + " " + this.caseSensitivity;
    }

    private final String pattern;
}
