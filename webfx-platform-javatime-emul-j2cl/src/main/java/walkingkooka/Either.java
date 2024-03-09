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
 * An either requires a single value which maybe on the left or right but not both or none.
 * One noticable method missing is a filter, because the concept of NONE is not supported.
 */
public abstract class Either<L, R> {

    /**
     * Creates a new {@link Either} with a left value.
     */
    public static <L, R> Either<L, R> left(final L value) {
        return EitherLeft.withLeft(value);
    }

    /**
     * Creates a new {@link Either} with a right value.
     */
    public static <L, R> Either<L, R> right(R value) {
        return EitherRight.withRight(value);
    }

    Either() {
        super();
    }

    /**
     * Only an either with a left value returns true.
     */
    public abstract boolean isLeft();

    /**
     * Only an either with a right value returns true.
     */
    public abstract boolean isRight();

    // getters..........................................................................................................

    /**
     * Only the left {@link Either} returns a value right will throw {@link java.util.NoSuchElementException}.
     */
    public abstract L leftValue() throws NoSuchElementException;

    /**
     * Only the right {@link Either} returns a value left will throw {@link java.util.NoSuchElementException}.
     */
    public abstract R rightValue() throws NoSuchElementException;

    // setters..........................................................................................................

    /**
     * Sets or replaces left {@link Either} value creating a new instance if the new value is different.
     */
    public final Either<L, R> setLeftValue(final L value) {
        return this.setLeftValue0(value);
    }

    abstract Either<L, R> setLeftValue0(final L value);

    /**
     * Sets or replaces right {@link Either} value creating a new instance if the new value is different.
     */
    public final Either<L, R> setRightValue(final R value) {
        return this.setRightValue0(value);
    }

    abstract Either<L, R> setRightValue0(final R value);

    /**
     * Creates a the opposite {@link Either}, keeping the same value but placing it on the other side.
     */
    public abstract Either<R, L> swap();

    // orElse...........................................................................................................

    /**
     * If a left value is present return that or the given value which may be null.
     */
    public abstract L orElseLeft(final L elseValue);

    /**
     * If a right value is present return that or the given value which may be null.
     */
    public abstract R orElseRight(final R elseValue);

    // orElseGet........................................................................................................

    /**
     * If a left value is present return that or the {@link Supplier#get()}
     */
    public final L orElseLeftGet(final Supplier<? extends L> elseSupplier) {
        checkSupplier(elseSupplier);

        return this.orElseLeftGet0(elseSupplier);
    }

    abstract L orElseLeftGet0(final Supplier<? extends L> elseSupplier);

    /**
     * If a right value is present return that or the {@link Supplier#get()}/.
     */
    public final R orElseRightGet(final Supplier<? extends R> elseSupplier) {
        checkSupplier(elseSupplier);

        return this.orElseRightGet0(elseSupplier);
    }

    abstract R orElseRightGet0(final Supplier<? extends R> elseSupplier);

    // orElseThrow.......................................................................................................

    /**
     * If a left value is present return that or throw the {@link Throwable} returned by {@link Supplier#get()}}
     */
    public final <X extends Throwable> L orElseLeftThrow(final Supplier<? extends X> exceptionSupplier) throws X {
        checkSupplier(exceptionSupplier);

        return this.orElseLeftThrow0(exceptionSupplier);
    }

    abstract <X extends Throwable> L orElseLeftThrow0(final Supplier<? extends X> exceptionSupplier) throws X;

    /**
     * If a right value is present return that or throw the {@link Throwable} returned by {@link Supplier#get()}}
     */
    public final <X extends Throwable> R orElseRightThrow(final Supplier<? extends X> exceptionSupplier) throws X {
        checkSupplier(exceptionSupplier);

        return this.orElseRightThrow0(exceptionSupplier);
    }

    abstract <X extends Throwable> R orElseRightThrow0(final Supplier<? extends X> exceptionSupplier) throws X;

    private static void checkSupplier(final Supplier<?> supplier) {
        Objects.requireNonNull(supplier, "supplier");
    }

    // map..............................................................................................................

    /**
     * Applies the map only if a left value is present.
     */
    public final <M> Either<M, R> mapLeft(final Function<? super L, ? extends M> mapper) {
        checkMapper(mapper);

        return this.mapLeft0(mapper);
    }

    abstract <M> Either<M, R> mapLeft0(final Function<? super L, ? extends M> mapper);

    /**
     * Applies the map only if a right value is present.
     */
    public final <S> Either<L, S> mapRight(final Function<? super R, ? extends S> mapper) {
        checkMapper(mapper);

        return this.mapRight0(mapper);
    }

    abstract <S> Either<L, S> mapRight0(final Function<? super R, ? extends S> mapper);

    private static void checkMapper(final Function<?, ?> mapper) {
        Objects.requireNonNull(mapper, "mapper");
    }

    // ifPresent........................................................................................................

    /**
     * If the left value is present it is given to the {@link Consumer}.
     */
    public final void ifLeftPresent(final Consumer<L> consumer) {
        checkConsumer(consumer);
        this.ifLeftPresent0(consumer);
    }

    abstract void ifLeftPresent0(final Consumer<L> consumer);

    /**
     * If the right value is present it is given to the {@link Consumer}.
     */
    public void ifRightPresent(final Consumer<R> consumer) {
        checkConsumer(consumer);
        this.ifRightPresent0(consumer);
    }

    abstract void ifRightPresent0(final Consumer<R> consumer);

    private static void checkConsumer(final Consumer<?> consumer) {
        Objects.requireNonNull(consumer, "consumer");
    }

    // accept...........................................................................................................

    /**
     * Calls the matching {@link Consumer with either the left or right value.
     */
    public final void accept(final Consumer<? super L> left,
                             final Consumer<? super R> right) {
        Objects.requireNonNull(left, "left");
        Objects.requireNonNull(right, "right");

        this.accept0(left, right);
    }

    abstract void accept0(final Consumer<? super L> left,
                          final Consumer<? super R> right);

    // Object...........................................................................................................

    @Override
    public final int hashCode() {
        return this.value().hashCode();
    }

    @Override
    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public final boolean equals(final Object other) {
        return this == other ||
                this.canBeEquals(other) && this.value().equals(((Either<?, ?>) other).value());
    }

    abstract boolean canBeEquals(final Object other);

    abstract Object value();

    @Override
    public final String toString() {
        return this.label() + ": " + CharSequences.quoteIfChars(this.value());
    }

    abstract String label();
}
