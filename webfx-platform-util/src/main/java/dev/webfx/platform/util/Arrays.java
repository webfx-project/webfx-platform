package dev.webfx.platform.util;

import dev.webfx.platform.util.collection.Collections;
import dev.webfx.platform.util.collection.ToStringOptions;
import dev.webfx.platform.util.function.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/**
 * @author Bruno Salmon
 */

public final class Arrays {

    private Arrays() {}

    public static <T> T[] of(T... a) {
        return a;
    }

    public static <T> List<T> asList(T... a) {
        if (a == null)
            return null;
        return java.util.Arrays.asList(a);
    }

    public static <T> T[] asArray(Object value) {
        if (!(value instanceof Object[]))
            return null;
        return (T[]) value;
    }

    public static <T> int length(T[] array) {
        return array == null ? 0 : array.length;
    }

    public static <T> boolean isEmpty(T[] array) {
        return length(array) == 0;
    }

    public static <T> T first(T[] array) {
        return isEmpty(array) ? null : array[0];
    }

    public static <T> T last(T[] list) {
        int length = length(list);
        return length == 0 ? null : list[length - 1];
    }

    public static <T> T[] filter(T[] array, Predicate<T> predicate, IntFunction<T[]> generator) {
        return java.util.Arrays.stream(array).filter(predicate::test).toArray(generator);
    }

    public static <T> T[] subArray(IntFunction<T[]> generator, int i0, int i1, T... a) {
        int n = i1 - i0;
        T[] subArray = generator.apply(n);
        for (int i = 0; i < n; i++)
            subArray[i] = a[i0 + i];
        return subArray;
    }

    public static <A, B> B[] map(A[] aArray, Converter<A, B> aToBConverter, IntFunction<B[]> generator) {
        //return java.util.Arrays.stream(aArray).map(a -> aToBConverter.convert(a)).toArray(generator);
        int n = aArray.length;
        B[] bArray = generator.apply(n);
        for (int i = 0; i < n; i++)
            bArray[i] = aToBConverter.convert(aArray[i]);
        return bArray;
    }

    public static <A, B> B[] map(A[] aArray, BiFunction<Integer, A, B> aToBConverter, IntFunction<B[]> generator) {
        //return java.util.Arrays.stream(aArray).map(a -> aToBConverter.convert(a)).toArray(generator);
        int n = aArray.length;
        B[] bArray = generator.apply(n);
        for (int i = 0; i < n; i++)
            bArray[i] = aToBConverter.apply(i, aArray[i]);
        return bArray;
    }

    public static <A, B> B[] flatMap(A[] aArray, Converter<A, B[]> aToBConverter, IntFunction<B[]> generator) {
        B[] bArray = generator.apply(0);
        int n = aArray.length;
        for (int i = 0; i < n; i++)
            bArray = concat(generator, bArray, aToBConverter.convert(aArray[i]));
        return bArray;
    }


    public static <T> String toString(T[] array, ToStringOptions options) {
        return Collections.toString(asList(array), options);
    }

    public static <T> String toString(T[] array) {
        return toString(array, ToStringOptions.BRACKETS_SINGLE_QUOTE_TO_STRING_OPTIONS);
    }

    public static <T> String toStringWithLineFeeds(T[] array) {
        return toString(array, ToStringOptions.BRACKETS_SINGLE_QUOTE_LINE_FEEDS_TO_STRING_OPTIONS);
    }

    public static <T> void forEach(T[] array, Consumer<T> consumer) {
        for (T element : array)
            consumer.accept(element);
    }

    public static <T> void forEachNonNull(T[] array, Consumer<T> consumer) {
        for (T element : array)
            if (element != null)
                consumer.accept(element);
    }

    public static <T> List<T> collectNonNulls(T[] array, List<T> list) {
        forEachNonNull(array, list::add);
        return list;
    }

    public static <T> T[] nonNulls(IntFunction<T[]> arrayGenerator, T... array) {
        if (allNonNulls(array))
            return array;
        return Collections.toArray(collectNonNulls(array, new ArrayList<>(array.length)), arrayGenerator);
    }

    public static <A, B> B[] convert(A[] aArray, Converter<A, B> aToBConverter, IntFunction<B[]> arrayGenerator) {
        int length = aArray.length;
        B[] bArray = arrayGenerator.apply(length);
        for (int i = 0; i < length; i++)
            bArray[i] = aToBConverter.convert(aArray[i]);
        return bArray;
    }

    public static <A> A[] clone(A[] aArray, IntFunction<A[]> arrayGenerator) {
        return convert(aArray, a -> a, arrayGenerator);
    }

    public static <T> List<T> nonNullsAsList(T[] array) {
        return collectNonNulls(array, new ArrayList<>(length(array)));
    }

    public static <T> boolean contains(T[] array, T element) {
        return indexOf(array, element) >= 0;
    }

    public static <T> int indexOf(T[] array, T element) {
        for (int i = 0, n = length(array); i < n; i++)
            if (Objects.areEquals(array[i], element))
                return i;
        return -1;
    }

    public static <T> int indexOfNull(T[] array) {
        for (int i = 0, n = length(array); i < n; i++)
            if (array[i] == null)
                return i;
        return -1;
    }

    public static <T> boolean allNonNulls(T[] array) {
        return indexOfNull(array) == -1;
    }

    public static <T> boolean hasNulls(T[] array) {
        return !allNonNulls(array);
    }

    public static <T> T findFirst(T[] array, Predicate<? super T> predicate) {
        for (int i = 0, n = length(array); i < n; i++) {
            T element = array[i];
            if (predicate.test(element))
                return element;
        }
        return null;
    }


    public static <T> T getValue(T[] array, int index) {
        return array == null || index >= array.length ? null : array[index];
    }

    public static <T> String getString(T[] array, int index) {
        return Strings.toString(getValue(array, index));
    }

    public static <A> A[] concat(IntFunction<A[]> arrayGenerator, A[]... as) {
        int length = 0;
        for (A[] a : as)
            length += a.length;
        A[] array = arrayGenerator.apply(length);
        length = 0;
        for (A[] a : as) {
            System.arraycopy(a, 0, array, length, a.length);
            length += a.length;
        }
        return array;
    }

    public static <A> A[] add(IntFunction<A[]> arrayGenerator, A[] array, A... a) {
        return concat(arrayGenerator, array, a);
    }

    public static double sum(double... values) {
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        return sum;
    }
}
