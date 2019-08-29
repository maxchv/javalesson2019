# Module 11

## Working with files

**Module duration**: 3 double-classes

1. Introduction to the java.io package.
2. Input/output streams.
3. Object serialization.

## Summary

### Read and write data from the console

* The public static fields `in`, `out`, and `err` in `java.lang.System` class respectively
represent the standard input, output and error streams. `System.in` is of type
`java.io.InputStream` and `System.out` and `System.err` are of type
`java.io.PrintStream`.

* You can redirect standard streams by calling the methods `System.setIn`,
`System.setOut` and `System.setError`.

* You can obtain a reference to the console using the `System.console()` method; if the
JVM is not associated with any console, this method will fail and return null.

* Many methods are provided in Console-support formatted I/O. You can use the
`printf()` and `format()` methods available in the Console class to print formatted
text; the overloaded `readLine()` and `readPassword()` methods take format strings as
arguments.

* The template of format specifiers is: `%[flags][width][.precision]datatype_specifier`
Each format specifier starts with the `%` sign, followed by flags, width, and precision
information, and ending with a data type specifier. In the format string, the flags,
width, and precision information are optional but the `%` sign and data type specifier
are mandatory.

* Use the `readPassword()` method for reading secure strings such as passwords. It is
recommended to use Array’s `fill()` method to “empty” the password read into the
character array (to avoid malicious access to the typed passwords).

### Use BufferedReader, BufferedWriter, File, FileReader, FileWriter, FileInputStream, FileOutputStream, ObjectOutputStream, ObjectInputStream, and PrintWriter in the java.io package

* The `java.io` package has classes supporting both character streams and byte streams.

* You can use character streams for text-based I/O. Byte streams are used for databased
I/O.

* Character streams for reading and writing are called readers and writers respectively
(represented by the abstract classes of `Reader` and `Writer`).

* Byte streams for reading and writing are called input streams and output streams
respectively (represented by the abstract classes of `InputStream` and `OutputStream`).

* You should only use character streams for processing text files (or human-readable
files), and byte streams for data files. If you try using one type of stream instead of
another, your program won’t work as you would expect; even if it works by chance,
you’ll get nasty bugs. So don’t mix up streams, and use the right stream for a given
task at hand.

* For both byte and character streams, you can use buffering. The buffer classes are
provided as wrapper classes for the underlying streams. Using buffering will speed
up the I/O when performing bulk I/O operations.

* For processing data with primitive data types and strings, you can use data streams.

* You can use object streams (classes `ObjectInputStream` and `ObjectOutputStream`)
for reading and writing objects in memory to files and vice versa.

### Use Path interface to operate on file and directory paths

* A Path object is a programming abstraction to represent the path of a file/directory.

* You can get an instance of Path using the `get()` method of the Paths class.

* Path provides two methods to compare Path objects: `equals()` and `compareTo()`.
Even if two Path objects point to the same file/directory, the equals() method is not
guaranteed to return true.

### Use Files class to check, read, delete, copy, move, manage metadata of a file or directory

* You can check the existence of a file using the `exists()` method of the Files class.

* The Files class provides the methods `isReadable()`, `isWritable()`, and
`isExecutable()` to check the ability of the program to read, write, and execute
programmatically, respectively.

* You can retrieve the attributes of a file using the `getAttributes()` method.

* You can use the `readAttributes()` method of the Files class to read file attributes
in bulk.

* The `copy()` method can be used to copy a file from one location to another. Similarly,
the `move()` method moves a file from one location to another.

* While copying, all the directories (except the last one, if you are copying a directory)
on the specified path must exist to avoid a `NoSuchFileException`.

* Use the `delete()` method to delete a file; use the `deleteIfExists()` method to
delete a file only if it exists.

### Use Stream API with NIO.2

* The `Files.list()` method returns a `Stream<Path>`. It does not recursively traverse
the directories in the given Path.
* The `Files.walk()` method returns a `Stream<Path>` by recursively traversing the
entries from the given Path; in one of its overloaded versions, you can also pass the
maximum depth for such traversal and provide `FileVisitOption.FOLLOW_LINKS` as
the third option.
* The `Files.find()` method returns a `Stream<Path>` by recursively traversing
the entries from the given Path; it also takes the maximum depth to search, a
BiPredicate, and an optional FileVisitOption as arguments.
* `Files.lines()` is a very convenient method to read the contents of a file. It returns a
`Stream<String>`.

## Usefull links

1. []()