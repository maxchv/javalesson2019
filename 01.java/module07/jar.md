# Using libraries in java

## Compile jar file

1. Create Intellij IDEA Project
2. Add module `library`
3. Add to module `library` class org.itstep.SuperClass.java

```java
package org.itstep;

public class SuperClass {
    public static void usefullMethod() {
        System.out.println("I am " + SuperClass.class.getName());
    }
}
```

4. Compile

```bash
javac SuperClass.java
```

5. Create jar file

```bash
jar --create --file library.jar SuperClass.class
```

## Using jar file

1. Create file `org.itstep.App.java` in main module
```java
package org.itstep;

public class App {
    public static void main(String[] args) {
        SuperClass.usefullMethod();
    }
}
``` 

2. Compile using argument -classpath (-cp)
```bash
javac -cp library.jar org\itstep\App.java -d bin
```

3. Run using library
```bash
java -cp ".;..\library.jar"  org.itstep.App
```