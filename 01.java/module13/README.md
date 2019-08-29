# Module 13

## Multithreading

**Module duration**: 3 double-classes

1. Multithreading in Java.
2. The use of ExecutorService.
3. Case study.

## Summary

### Create worker threads using Runnable, Callable, and use an ExecutorService to concurrently execute tasks

* You can create classes that are capable of multi-threading by implementing the
Runnable interface or by extending the Thread class.

* Always implement the `run()` method. The default `run()` method in Thread does
nothing.

* Call the `start()` method and not the `run()` method directly in code. (Leave it to the
JVM to call the `run()` method.)

* The Callable interface represents a task that needs to be completed by a thread.
Once the task completes, the `call()` method of a Callable implementation returns
a value.

* The Executor hierarchy abstracts the lower-level details of multi-threaded
programming and offers high-level user-friendly concurrency constructs.

### Identify potential threading problems among deadlock, starvation, livelock, and race conditions

* Concurrent reads and writes to resources may lead to the race condition problem.

* You must use thread synchronization (i.e., locks) to access shared values and avoid
race conditions. Java provides thread synchronization features to provide protected
access to shared resources—namely, synchronized blocks and synchronized
methods.

* Using locks can introduce problems such as deadlocks. When a deadlock happens,
the process will hang and will never terminate.

* A deadlock typically happens when two threads acquire locks in opposite order.
When one thread has acquired one lock and waits for another lock, another thread
has acquired that other lock and waits for the first lock to be released. So, no progress
is made and the program deadlocks.

* When a change done by a thread is repeatedly undone by another thread, both
the threads are busy but the application as a whole does not make progress; this
situation is known as a livelock.

* The situation in which low-priority threads “starve” for a long time trying to obtain
the lock is known as lock starvation.

### Use synchronized keyword and java.util.concurrent.atomic package to control the order of thread execution

* In synchronized blocks, you use the synchronized keyword for a reference variable
and follow it by a block of code. A thread has to acquire a lock on the synchronized
variable to enter the block; when the execution of the block completes, the thread
releases the lock.

* Java provides an efficient alternative in the form of atomic variables where one needs
to acquire and release a lock just to carry out primitive operations on variables.

* A lock ensures that only one thread accesses a shared resource at a time.

* Performing locking and unlocking for performing operations on primitive
types is inefficient. A better alternative is to use atomic variables provided in
`java.util.concurrent.atomic` package including `AtomicBoolean`, `AtomicInteger`,
`AtomicIntegerArray`, `AtomicLong`, `AtomicLongArray`, `AtomicReference<V>`, and
`AtomicReferenceArray<E>`.

### Use java.util.concurrent collections and classes including CyclicBarrier and CopyOnWriteArrayList

* `Semaphore` controls access to one or more shared resources.

* `CountDownLatch` allows threads to wait for a countdown to complete.

* Exchanger supports exchanging data between two threads.

* `Phaser` is used to support a synchronization barrier.

* `CyclicBarrier` enables threads to wait at a predefined execution point.

* The `java.util.concurrent` package provides a number of classes that are threadsafe
equivalents of the ones provided in the collections framework classes in the
`java.util` package; for example, `java.util.concurrent.ConcurrentHashMap` is a
concurrent equivalent to `java.util.HashMap`.

* `CopyOnWriteArrayList` is similar to `ArrayList`, but provides safe concurrent access.
When you modify a `CopyOnWriteArrayList`, a fresh copy of the underlying array is
created.

### Use Parallel Fork/Join Framework

* The Fork/Join framework is a portable means of executing a program with decent
parallelism.

* The framework is an implementation of the ExecutorService interface and provides
an easy-to-use concurrent platform in order to exploit multiple processors.

* This framework is very useful for modeling divide-and-conquer problems.

* The Fork/Join framework uses the work-stealing algorithm: when a worker thread
completes its work and is free, it takes (or “steals”) work from other threads that are
still busy doing some work.

* The work-stealing technique results in decent load balancing thread management
with minimal synchronization cost.

* `ForkJoinPool` is the most important class in the Fork/Join framework. It is a thread
pool for running fork/join tasks—it executes an instance of ForkJoinTask. It
executes tasks and manages their lifecycles.

* `ForkJoinTask<V>` is a lightweight thread-like entity representing a task that defines
methods such as `fork()` and `join()`.

### Use parallel Streams including reduction, decomposition, merging processes, pipelines, and performance

* Parallel streams split the elements into multiple chunks, process each chunk with
different threads, and (if necessary) combine the results from those threads to
evaluate the final result.

* When you call the `stream()` method of the `Collection` class, you will get a
sequential stream. When you call the `parallelStream()` method of the `Collection`
class, you will get a parallel stream.

* Parallel streams internally use the fork/join framework. To use parallel streams
correctly, the process steps should consist of stateless and independent tasks.

* You can convert a sequential stream to a parallel stream by calling the `parallel()`
method; similarly, you can convert a parallel stream to a sequential stream by calling
the `sequential()` method.

* You can check if the stream is sequential or parallel by calling the `isParallel()`
method.

## Usefull links

1. []()