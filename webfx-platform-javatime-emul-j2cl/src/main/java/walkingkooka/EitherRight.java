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

import walkingkooka.text.CharSequences;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * An {@link Either} that holds a value on the right side.
 */
final class EitherRight<L, R> extends Either<L, R> {

    static <L, R> EitherRight<L, R> withRight(final R value) {
        return new EitherRight<>(value);
    }

    private EitherRight(final R value) {
        super();
        this.value = value;
    }

    @Override
    public boolean isLeft() {
        return false;
    }

    @Override
    public boolean isRight() {
        return true;
    }

    @Override
    public L leftValue() throws NoSuchElementException {
        throw new NoSuchElementException("right=" + CharSequences.quoteIfChars(this.value));
    }

    @Override
    public R rightValue() {
        return this.value;
    }

    /**
     * Sets or replaces left {@link Either} value creating a new instance if the new value is different.
     */
    @Override
    Either<L, R> setLeftValue0(final L value) throws NoSuchElementException {
        return EitherLeft.withLeft(value);
    }

    @Override
    Either<L, R> setRightValue0(final R value) throws NoSuchElementException {
        return Objects.equals(this.value, value) ?
                this :
                new EitherRight<>(value);
    }

    @Override
    public Either<R, L> swap() {
        return EitherLeft.withLeft(this.value);
    }

    // orElse...........................................................................................................

    /**
     * Always returns the else value.
     */
    @Override
    public L orElseLeft(final L elseValue) {
        return elseValue;
    }

    /**
     * Ignores the elseValue parameter and returns the {@link #value}.
     */
    @Override
    public R orElseRight(final R elseValue) {
        return this.value;
    }

    @Override
    L orElseLeftGet0(final Supplier<? extends L> elseSupplier) {
        return elseSupplier.get();
    }

    @Override
    R orElseRightGet0(final Supplier<? extends R> elseSupplier) {
        return this.value;
    }

    @Override <X extends Throwable> L orElseLeftThrow0(final Supplier<? extends X> exceptionSupplier) throws X {
        throw exceptionSupplier.get();
    }

    @Override <X extends Throwable> R orElseRightThrow0(final Supplier<? extends X> exceptionSupplier) {
        return this.value;
    }

    // map..............................................................................................................

    @Override <M> Either<M, R> mapLeft0(final Function<? super L, ? extends M> mapper) {
        return Cast.to(this);
    }

    @Override <S> Either<L, S> mapRight0(final Function<? super R, ? extends S> mapper) {
        return withRight(mapper.apply(this.value));
    }

    // ifPresent.........................................................................................................

    @Override
    void ifLeftPresent0(final Consumer<L> consumer) {
    }

    @Override
    void ifRightPresent0(final Consumer<R> consumer) {
        consumer.accept(this.value);
    }

    // accept...........................................................................................................

    @Override
    void accept0(final Consumer<? super L> left, final Consumer<? super R> right) {
        right.accept(this.value);
    }

    final R value;

    // Object...........................................................................................................

    @Override
    boolean canBeEquals(final Object other) {
        return other instanceof EitherRight;
    }

    @Override
    Object value() {
        return this.value;
    }

    @Override
    String label() {
        return "Right";
    }
}
