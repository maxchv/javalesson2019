package org.itstep;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public interface ListExt<T> extends List<T> {
    /**
     * Отфильтровывает записи, возвращает только записи, соответствующие условию
     *
     * @param predicate - условие при котором данные списка сохраняются
     * @return новый отфильтрованный список
     */
    ListExt<T> filter(Predicate<? super T> predicate);

    /**
     * Возвращает список размером n элементов, генерируемых функцией Supplier s.
     * @param s - генератор новых элементов списка
     * @param n - размер список
     * @return - новый список
     */
    static<T> ListExt<T> generate(Supplier<? extends T> s, int n) {
        ListExt<T> list = new ArrayListExt<>();
        for(int i=0; i<n; i++) {
            list.add(s.get());
        }
        return list;
    }

    /**
     * Преобразует каждый элемент списка
     * @param mapper - объект преобразующий данные (или типы) списка
     * @param <R> - тип, к которому необходимо преобразовать
     * @return новый перобразованный список
     */
    <R> ListExt<R> convert(Function<? super T, ? extends R> mapper);

    /**
     * Возвращает элементы до тех пор, пока они удовлетворяют условию,
     * то есть функция-предикат возвращает true.
     * @param predicate - условие извлечение данных списка
     * @return - новый список, данные которого соответсвуют предикату
     */
    ListExt<T> takeWhile(Predicate<? super T> predicate);

    /**
     * Пропускает элементы до тех пор, пока они удовлетворяют условию,
     * затем возвращает оставшуюся часть списка.
     * Если предикат вернул для первого элемента false, то ни единого элемента не будет пропущено.
     * @param predicate - условие пропуска данных
     * @return - новый список с пропущенными данными по предикату
     */
    ListExt<T> dropWhile(Predicate<? super T> predicate);

    /**
     * Позволяет выполнять агрегатные функции на всей коллекцией и возвращать один результат
     * @param identity - начальное значение
     * @param accumulator - объект определяющий способ накопления данных
     * @return - агрегатный результат
     */
    T reduce(T identity, BinaryOperator<T> accumulator);

    /**
     * Возвращает максимальный элемент, в качестве условия использует компаратор
     * @param comparator - объект используемый для сравнения элементов списка
     * @return - наибольший элемент списка
     */
    T max(Comparator<? super T> comparator);

    /**
     * Возвращает минимальный элемент, в качестве условия использует компаратор
     * @param comparator - объект используемый для сравнения элементов списка
     * @return - наименьший элемент списка
     */
    T min(Comparator<? super T> comparator);

    /**
     * Возвращает true, если условие выполняется хотя бы для одного элемента
     * @param predicate - условие
     * @return true, если хотя бы один элемент соответсвует условию, иначе - false
     */
    boolean anyMatch(Predicate<? super T> predicate);

    /**
     * Возвращает true, если условие выполняется для всех элементов
     * @param predicate - условие
     * @return true, если все элементы соответсвуют условию, иначе - false
     */
    boolean allMatch(Predicate<? super T> predicate);

    /**
     * Возвращает true, если условие не выполняется ни для одного элемента
     * @param predicate  - условие
     * @return true, если ни один элемент не соответсвует условию, иначе - false
     */
    boolean noneMatch(Predicate<? super T> predicate);
}
