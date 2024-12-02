package dev.webfx.platform.util.collection;

import dev.webfx.platform.util.function.Converter;

import java.io.Serializable;
import java.util.*;
import java.util.function.*;

/**
 * @author Bruno Salmon
 */
public final class Collections {

    public static <T> List<T> newList() {
        return new ArrayList<>();
    }

    public static <T> List<T> newList(int initialCapacity) {
        return new ArrayList<>(initialCapacity);
    }

    public static <T> List<T> emptyList() {
        return newList();
    }

    public static <T> List<T> listOf(T... elements) {
        List<T> list = newList(elements.length);
        java.util.Collections.addAll(list, elements);
        return list;
    }

    public static <T> List<T> listOfRemoveNulls(T... elements) {
        return removeNulls(listOf(elements));
    }

    public static <T> List<T> listOf(Iterable<T> iterable) {
        List<T> list = newList();
        forEach(iterable, list::add);
        return list;
    }

    public static <K, V> Map<K, V> mapOf(K k1, V v1) {
        Map<K, V> map = new HashMap<>();
        map.put(k1, v1);
        return map;
    }

    public static <K, V> Map<K, V> mapOf(K k1, V v1, K k2, V v2) {
        Map<K, V> map = mapOf(k1, v1);
        map.put(k2, v2);
        return map;
    }

    public static <K, V> Map<K, V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3) {
        Map<K, V> map = mapOf(k1, v1, k2, v2);
        map.put(k3, v3);
        return map;
    }

    public static <K, V> Map<K, V> mapOf(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        Map<K, V> map = mapOf(k1, v1, k2, v2, k3, v3);
        map.put(k4, v4);
        return map;
    }

    public static <T> List<T> setAll(List<T> list, Collection<? extends T> collection) {
        list.clear();
        list.addAll(collection);
        return list;
    }

    public static <T> void forEach(Iterable<T> iterable, Consumer<T> consumer) {
        if (iterable != null) {
            // Safe loop version (not causing ConcurrentModificationException)
            for (Iterator<T> it = iterable.iterator(); it.hasNext(); ) {
                consumer.accept(it.next());
            }
        }
    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        if (list != null) {
            // Safe loop version (not causing ConcurrentModificationException)
            for (int i = 0; i < list.size(); i++) {
                consumer.accept(list.get(i));
            }
        }
    }

    public static <A, B> List<B> map(Collection<A> aCollection, Converter<A, B> aToBConverter) {
        // return aCollection.stream().map(aToBConverter::convert).collect(Collectors.toList()); // Not GWT compilable for now
        List<B> bList = newList(aCollection.size());
        forEach(aCollection, a -> bList.add(aToBConverter.convert(a)));
        return bList;
    }

    public static <T> List<T> filter(Iterable<T> iterable, Predicate<? super T> predicate) {
        // return collection.stream().filter(predicate).collect(Collectors.toList()); // Not GWT compilable for now
        List<T> list = newList();
        forEach(iterable, element -> {
            if (predicate.test(element))
                list.add(element);
        });
        return list;
    }

    public static <A, B> List<B> filterMap(Collection<A> aCollection, Predicate<? super A> predicate, Converter<A, B> aToBConverter) {
        List<B> bList = newList(aCollection.size());
        forEach(aCollection, a -> {
            if (predicate == null || predicate.test(a))
                bList.add(aToBConverter.convert(a));
        });
        return bList;
    }

    public static <A, B> List<B> mapFilter(Collection<A> aCollection, Converter<A, B> aToBConverter, Predicate<? super B> predicate) {
        // return aCollection.stream().map(aToBConverter::convert).collect(Collectors.toList()); // Not GWT compilable for now
        List<B> bList = newList(aCollection.size());
        forEach(aCollection, a -> {
            B b = aToBConverter.convert(a);
            if (predicate == null || predicate.test(b))
                bList.add(b);
        });
        return bList;
    }

    public static <A> int sum(Collection<A> aCollection, Converter<A, Integer> aToIntConverter) {
        //return aCollection.stream().mapToInt(aToIntConverter).sum(); // Not GWT compilable for now
        int sum = 0;
        for(A a : aCollection) {
            Integer number = aToIntConverter.convert(a);
            if (number != null)
                sum += number;
        }
        return sum;
    }

    public static <T> T first(Iterable<T> iterable) {
        if (iterable != null)
            for (T element : iterable)
                return element;
        return null;
    }

    public static <T> T findFirst(Iterable<T> iterable, Predicate<? super T> predicate) {
        //return collection.stream().filter(predicate::test).findFirst().get(); // Not GWT compilable for now
        if (iterable != null)
            for (T element : iterable) {
                if (predicate.test(element))
                    return element;
            }
        return null;
    }

    public static <T> boolean noneMatch(Iterable<T> iterable, Predicate<? super T> predicate) {
        return !anyMatch(iterable, predicate);
    }

    public static <T> boolean anyMatch(Iterable<T> iterable, Predicate<? super T> predicate) {
        return findFirst(iterable, predicate) != null;
    }

    public static <T> int indexOf(Iterable<T> iterable, Predicate<? super T> predicate) {
        if (iterable != null) {
            int index = 0;
            for (T element : iterable) {
                if (predicate.test(element))
                    return index;
                index++;
            }
        }
        return -1;
    }

    public static <T> boolean removeIf(Iterable<T> iterable, Predicate<? super T> predicate) {
        //Doesn't work on Android: Collection.removeIf();
        boolean removed = false;
        final Iterator<T> each = iterable.iterator();
        while (each.hasNext()) {
            if (predicate.test(each.next())) {
                each.remove();
                removed = true;
            }
        }
        return removed;
    }

    public static <T> List<T> removeNulls(List<T> list) {
        removeIf(list, Objects::isNull);
        return list;
    }

    public static <T> void sort(List<T> list, Comparator<? super T> c) {
        //list.sort(c); // Java 8 API - doesn't work on Android
        Object[] a = list.toArray();
        Arrays.sort(a, (Comparator) c);
        ListIterator<T> i = list.listIterator();
        for (Object e : a) {
            i.next();
            i.set((T) e);
        }
    }

    public static <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<? super T, ? extends U> keyExtractor) {
        //return Comparator.comparing(keyExtractor); // Java 8 API - doesn't work on Android
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable) (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }

    public static <T> Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor) {
        // return Comparator.comparingInt(keyExtractor); // Java 8 API - doesn't work on Android
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable) (c1, c2) -> Integer.compare(keyExtractor.applyAsInt(c1), keyExtractor.applyAsInt(c2));
    }

    public static <T> Comparator<T> comparingLong(ToLongFunction<? super T> keyExtractor) {
        // return Comparator.comparingLong(keyExtractor); // Java 8 API - doesn't work on Android
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable) (c1, c2) -> Long.compare(keyExtractor.applyAsLong(c1), keyExtractor.applyAsLong(c2));
    }

    public static int size(Collection collection) {
        return collection == null ? 0 : collection.size();
    }

    public static boolean isEmpty(Collection collection) {
        return size(collection) == 0;
    }

    public static <T> T first(List<T> list) {
        return isEmpty(list) ? null : list.get(0);
    }

    public static <T> T last(List<T> list) {
        int size = size(list);
        return size == 0 ? null : list.get(size - 1);
    }

    public static <T> T get(List<T> list, int i) {
        if (list == null || i < 0 || i >= list.size())
            return null;
        return list.get(i);
    }

    public static int indexOf(List list, Object element) {
        return list == null ? -1 : list.indexOf(element);
    }

    public static int indexOf(Iterable iterable, Object element) {
        if (iterable != null) {
            int i = 0;
            for (Object e : iterable)
                if (Objects.equals(e, element))
                    return i;
                else
                    i++;
        }
        return -1;
    }

    public static boolean contains(List list, Object element) {
        return list != null && list.contains(element);
    }

    public static boolean contains(Iterable iterable, Object element) {
        return indexOf(iterable, element) != -1;
    }

    public static <T> boolean addIfNotNull(T element, Collection<T> collection) {
        if (element == null || collection == null)
            return false;
        collection.add(element);
        return true;
    }

    public static <T> boolean addIfNotContains(T element, Collection<T> collection) {
        if (collection == null || collection.contains(element))
            return false;
        collection.add(element);
        return true;
    }

    public static <T> boolean allNonNulls(List<T> list) {
        return indexOf(list, (T) null) == -1;
    }

    public static <T> Iterator<T> iterator(Iterable<T> iterable) {
        return iterable == null ? null : iterable.iterator();
    }

    public static <T> T next(Iterator<T> it) {
        return it == null || !it.hasNext() ? null : it.next();
    }

    public static <T> T[] toArray(Collection<T> collection, IntFunction<T[]> arrayGenerator) {
        return collection.toArray(arrayGenerator.apply(collection.size()));
    }

    public static long[] toLongArray(Collection<Long> collection) {
        int n = collection.size(), i = 0;
        long[] array = new long[n];
        for (Long value : collection)
            array[i++] = value;
        return array;
    }

    public static float[] toFloatArray(Collection<Float> collection) {
        int n = collection.size(), i = 0;
        float[] array = new float[n];
        for (Float value : collection)
            array[i++] = value;
        return array;
    }

    public static float[] doubleCollectionToFloatArray(Collection<Double> collection) {
        int n = collection.size(), i = 0;
        float[] array = new float[n];
        for (Double value : collection)
            array[i++] = value.floatValue();
        return array;
    }

    public static String toString(Iterable iterable, ToStringOptions options) {
        return toString(iterable != null ? iterable.iterator() : null, options);
    }

    public static String toString(Iterator it, ToStringOptions options) {
        return toString(it, options.getOpening(), options.getSeparator(), options.isLineFeeds(), options.getStringQuote(), options.getArrayOpening(), options.getArrayClosing(), options.getClosing());
    }

    private static String toString(Iterator it, CharSequence opening, CharSequence separator, boolean lineFeeds, CharSequence stringQuote, CharSequence arrayOpening, CharSequence arrayClosing, CharSequence closing) {
        if (it == null)
            return null;
        StringBuilder sb = new StringBuilder();
        toString(it, sb, opening, separator, lineFeeds, stringQuote, arrayOpening, arrayClosing, closing);
        return sb.toString();
    }

    private static void toString(Iterator it, StringBuilder sb, CharSequence opening, CharSequence separator, boolean lineFeeds, CharSequence stringQuote, CharSequence arrayOpening, CharSequence arrayClosing, CharSequence closing) {
        if (opening != null)
            sb.append(opening);
        int initialLength = sb.length();
        while (it.hasNext()) {
            int length = sb.length();
            if (length > 0) {
                if (length > initialLength)
                    sb.append(separator);
                if (lineFeeds)
                    sb.append('\n');
            }
            Object value = it.next();
            if (value instanceof Object[]) {
                toString(dev.webfx.platform.util.Arrays.asList(((Object[]) value)).iterator(), sb, arrayOpening, separator, lineFeeds, stringQuote, arrayOpening, arrayClosing, arrayClosing);
            } else if (stringQuote != null && value instanceof String)
                sb.append(stringQuote).append(value).append(stringQuote);
            else
                sb.append(value);
        }
        if (closing != null) {
            sb.append(closing);
        }
    }

    // Some shortcut toString() methods

    public static String toStringCommaSeparated(Iterable iterable) { // by default toString() is with comma separated
        return toString(iterable, ToStringOptions.COMMA_SEPARATED_TO_STRING_OPTIONS);
    }

    public static String toStringCommaSeparated(Iterator iterator) { // by default toString() is with comma separated
        return toString(iterator, ToStringOptions.COMMA_SEPARATED_TO_STRING_OPTIONS);
    }

    public static String toStringCommaSeparatedWithSingleQuotedStrings(Iterable iterable) {
        return toString(iterable, ToStringOptions.SINGLE_QUOTE_TO_STRING_OPTIONS);
    }

    public static String toStringCommaSeparatedWithSingleQuotedStrings(Iterator iterator) {
        return toString(iterator, ToStringOptions.SINGLE_QUOTE_TO_STRING_OPTIONS);
    }

    public static String toStringCommaSeparatedWithBrackets(Iterable iterable) {
        return toString(iterable, ToStringOptions.BRACKETS_TO_STRING_OPTIONS);
    }

    public static String toStringCommaSeparatedWithBrackets(Iterator iterator) {
        return toString(iterator, ToStringOptions.BRACKETS_TO_STRING_OPTIONS);
    }

    public static String toStringCommaSeparatedWithBracketsAndLineFeeds(Iterable iterable) {
        return toString(iterable, ToStringOptions.BRACKETS_LINE_FEEDS_TO_STRING_OPTIONS);
    }

    public static String toStringCommaSeparatedWithBracketsAndLineFeeds(Iterator iterator) {
        return toString(iterator, ToStringOptions.BRACKETS_LINE_FEEDS_TO_STRING_OPTIONS);
    }

    public static String toStringAmpersandSeparated(Iterable iterable) {
        return toString(iterable, ToStringOptions.AMPERSAND_SEPARATED_TO_STRING_OPTIONS);
    }

    public static String toStringAmpersandSeparated(Iterator iterator) {
        return toString(iterator, ToStringOptions.AMPERSAND_SEPARATED_TO_STRING_OPTIONS);
    }

}
