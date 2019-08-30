package org.itstep;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

public class Application {

    private Application() {

    }

    public static Application newInstance() {
        return new Application();
    }

    public static void main(String[] args) throws IOException {
        //printDir(new File("."));

        Application application = Application.newInstance();

        // nio 2
        Path path = Paths.get("c:", "Program Files", "Java", "..", "JetBrains");
        System.out.println(path.normalize());

        //Files.copy(new URL("https://itstep.dp.ua").openStream(), Paths.get("index.html"));

        //Files.createDirectories(Paths.get(".", "a", "b", "c"));
        Path tempFile = Files.createTempFile("pref-", "-suff");
        System.out.println(tempFile);

//        Files.list(Paths.get("."))
//                .filter(p -> Files.isDirectory(path))
//                .forEach(System.out::println);

//        Files.walk(Paths.get("."))
//                .forEach(System.out::println);

        Files.walkFileTree(Paths.get("."), new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return dir.toString().contains(".idea") ? FileVisitResult.SKIP_SUBTREE : FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static void printDir(File file) {
        printDir(file, "");
    }

    private static void printDir(File file, String prefix) {
        if(file.exists()) {
            System.out.print(prefix);
            if(file.isDirectory()) {
                for(File f: file.listFiles()) {
                    printDir(f, file.getName() + File.separator);
                }
            } else {
                System.out.println(file.getName());
            }
        }
    }
}
