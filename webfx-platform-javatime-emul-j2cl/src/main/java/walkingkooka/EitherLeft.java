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
 * An {@link Either} that holds a value on the left side.
 */
final class EitherLeft<L, R> extends Either<L, R> {

    static <L, R> EitherLeft<L, R> withLeft(final L value) {
        return new EitherLeft<>(value);
    }

    private EitherLeft(final L value) {
        super();
        this.value = value;
    }

    @Override
    public boolean isLeft() {
        return true;
    }

    @Override
    public boolean isRight() {
        return false;
    }

    @Override
    public L leftValue() {
        return this.value;
    }

    @Override
    public R rightValue() throws NoSuchElementException {
        throw new NoSuchElementException("left=" + CharSequences.quoteIfChars(this.value));
    }

    @Override
    Either<L, R> setLeftValue0(final L value) throws NoSuchElementException {
        return Objects.equals(this.value, value) ?
                this :
                new EitherLeft<>(value);
    }

    /**
     * Sets or replaces right {@link Either} value creating a new instance if the new value is different.
     */
    @Override
    Either<L, R> setRightValue0(final R value) throws NoSuchElementException {
        return EitherRight.withRight(value);
    }

    @Override
    public Either<R, L> swap() {
        return EitherRight.withRight(this.value);
    }

    // orElse...........................................................................................................

    /**
     * Ignores the elseValue parameter and returns the {@link #value}.
     */
    @Override
    public L orElseLeft(final L elseValue) {
        return this.value;
    }

    /**
     * Always returns the else value.
     */
    @Override
    public R orElseRight(final R elseValue) {
        return elseValue;
    }

    @Override
    L orElseLeftGet0(final Supplier<? extends L> elseSupplier) {
        return this.value;
    }

    @Override
    R orElseRightGet0(final Supplier<? extends R> elseSupplier) {
        return elseSupplier.get();
    }

    @Override <X extends Throwable> L orElseLeftThrow0(final Supplier<? extends X> exceptionSupplier) {
        return this.value;
    }

    @Override <X extends Throwable> R orElseRightThrow0(final Supplier<? extends X> exceptionSupplier) throws X {
        throw exceptionSupplier.get();
    }

    // map..............................................................................................................

    @Override <M> Either<M, R> mapLeft0(final Function<? super L, ? extends M> mapper) {
        return withLeft(mapper.apply(this.value));
    }

    @Override <S> Either<L, S> mapRight0(final Function<? super R, ? extends S> mapper) {
        return Cast.to(this);
    }

    // ifPresent.........................................................................................................

    @Override
    void ifLeftPresent0(final Consumer<L> consumer) {
        consumer.accept(this.value);
    }

    @Override
    void ifRightPresent0(final Consumer<R> consumer) {
    }

    // accept...........................................................................................................

    @Override
    void accept0(final Consumer<? super L> left, final Consumer<? super R> right) {
        left.accept(this.value);
    }

    private final L value;

    // Object...........................................................................................................

    @Override
    boolean canBeEquals(final Object other) {
        return other instanceof EitherLeft;
    }

    @Override
    Object value() {
        return this.value;
    }

    @Override
    String label() {
        return "Left";
    }
}
