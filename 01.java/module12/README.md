# Module 12

## Stream API

**Module duration**: 2 double-classes

1. Stream API.
2. What is Stream API?
3. Tasks and objectives.
4. Example use.

## Summary

### Develop code to extract data from an object using peek() and map() methods including primitive versions of the map() method

* The `peek()` method is useful for debugging: it helps us understand how the elements
are transformed in the pipeline.

* You can transform (or just extract) elements in a stream using `map()` method

### Search for data by using search methods of the Stream classes including findFirst, findAny, anyMatch, allMatch, noneMatch

* You can match for a given predicate in a stream using the `allMatch()`, `noneMatch()`,
and `anyMatch()` methods. Unlike the `anyMatch()` method that returns false when the
stream is empty, the `allMatch()` and `noneMatch()` methods return `true` if the stream
is empty.

* You can look for elements in a stream using the `findFirst()` and `findAny()`
methods. The `findAny()` method is faster to use than the `findFirst()` method in
case of parallel streams.

* The “match” and “find” methods “short-circuit”: the evaluation stops once the result
is found and the rest of the stream is not evaluated.

### Develop code that uses the Optional class

* When there are no entries in a stream and operations such as max are called, then
instead of returning null or throwing an exception, the (better) approach taken in
Java 8 is to return Optional values.

* Primitive type versions of `Optional<T>` for `int`, `long`, and double are
`OptionalInteger`, `OptionalLong`, and `OptionalDouble` respectively.
Develop code that uses Stream data methods and calculation methods

* The `Stream<T>` interface has data and calculation methods `count()`, `min()` and
`max()`; you need to pass a Comparator object as the parameter when invoking these
`min()` and `max()` methods.

* The primitive type versions of Stream interface have the following data and
calculation methods: `count()`, `sum()`, `average()`, `min()`, and `max()`.

* The `summaryStatistics()` method in `IntStream`, `LongStream`, and `DoubleStream`
have methods for calculating count, sum, average, minimum, and maximum values
of elements in the stream.

### Sort a collection using Stream API

* One way to sort a collection is to get a stream from the collection and call `sorted()`
method on that stream. The `sorted()` method sorts the elements in the stream
in natural order (it requires that the stream elements implements the Comparable
interface).

* When you want to sort elements in the stream other than the natural order, you can
pass a Comparator object to the `sorted()` method.

* The Comparator interface has been enhanced with many useful static or default
methods in Java 8 such as `thenComparing()` and `reversed()` methods.
Save results to a collection using the collect method and group/partition data using the
Collectors class

* The `collect()` method of the Collectors class has methods that support the task of
collecting elements to a collection.

* The Collectors class provides methods such as `toList()`, `toSet()`, `toMap()`, and
`toCollection()` to create a collection from a stream.

* You can group the elements in a stream using the `Collectors.groupingBy()`
method and pass the criteria for grouping (given as a Function) as the argument.

* You can separate the elements in a stream based on a condition (given as a
Predicate) using the `partition()` method in the Collectors class. .
Use `flatMap()` method of the Stream API

* The `flatMap()` method in Stream flattens the streams that result from mapping each
element into one flat stream.

## Usefull links

1. [Полное руководство по Java 8 Stream API в картинках и примерах](https://annimon.com/article/2778)
2. [Шпаргалка Java программиста 4. Java Stream API](https://habr.com/ru/company/luxoft/blog/270383/)
