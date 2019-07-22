package org.itstep;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class ArrayListExt<T> extends ArrayList<T> implements ListExt<T> {

    public ArrayListExt(int initialCapacity) {
        super(initialCapacity);
    }

    public ArrayListExt() {
    }

    public ArrayListExt(Collection<? extends T> c) {
        super(c);
    }

    @Override
    public ListExt<T> filter(Predicate<? super T> predicate) {
        // FIXME: реализовать метод
        return null;
    }

    @Override
    public <R> ListExt<R> convert(Function<? super T, ? extends R> mapper) {
        // FIXME: реализовать метод
        return null;
    }

    @Override
    public ListExt<T> takeWhile(Predicate<? super T> predicate) {
        // FIXME: реализовать метод
        return null;
    }

    @Override
    public ListExt<T> dropWhile(Predicate<? super T> predicate) {
        // FIXME: реализовать метод
        return null;
    }

    @Override
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        // FIXME: реализовать метод
        return null;
    }

    @Override
    public T max(Comparator<? super T> comparator) {
        // FIXME: реализовать метод
        return null;
    }

    @Override
    public T min(Comparator<? super T> comparator) {
        // FIXME: реализовать метод
        return null;
    }

    @Override
    public boolean anyMatch(Predicate<? super T> predicate) {
        // FIXME: реализовать метод
        return false;
    }

    @Override
    public boolean allMatch(Predicate<? super T> predicate) {
        // FIXME: реализовать метод
        return false;
    }

    @Override
    public boolean noneMatch(Predicate<? super T> predicate) {
        // FIXME: реализовать метод
        return false;
    }
}
