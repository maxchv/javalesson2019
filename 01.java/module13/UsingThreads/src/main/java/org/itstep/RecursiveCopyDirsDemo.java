package org.itstep;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class RecursiveCopyDirsDemo {
    static String from = "./orig" ;//"C:\\\\Users\\\\shaptala\\\\Desktop\\\\javalessons\\\\01.java\\\\module13\\\\UsingThreads\\\\orig";
    static String to = "./to" ;//"C:\\\\Users\\\\shaptala\\\\Desktop\\\\javalessons\\\\01.java\\\\module13\\\\UsingThreads\\\\cpy";

    public static void main(String[] args) throws IOException {
//        method1(from, to);
        method2();
    }

    private static void method2() throws IOException {
        Path orig = Paths.get(from);

        Files.walkFileTree(Paths.get(from), new SimpleFileVisitor<>(){
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Path relativize = orig.relativize(dir);
                Path dirName = Path.of(to, relativize.toString());
                if(!Files.isDirectory(dirName)) {
                    Files.createDirectories(dirName);
                }
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path relativize = orig.relativize(file);
                Path destFileName = Path.of(to, relativize.toString());
                Files.copy(file, destFileName);
                return super.visitFile(file, attrs);
            }
        });
    }

    static String getDir() {
        JFileChooser chooser = new JFileChooser(); // Создаем диалог
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // отображать только директории
        int returnVal = chooser.showOpenDialog(null); // показать диалог открытия файла
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getName(); // здесь находится имя выбранной папки
        }
        return null;
    }

    private static void method1(String from, String to) throws IOException {
        recursiveList(new File(from), new File(to));
    }

    private static void recursiveList(File from, File to) throws IOException {
        String absolutePath = from.getAbsolutePath();
        String relativeDirName = absolutePath.replaceFirst(RecursiveCopyDirsDemo.from, "");
        if (from.isDirectory()) {
            String createDir = to.getAbsolutePath() + relativeDirName;
            File dir = new File(createDir);
            if (!dir.exists()) {
                System.out.println("Create directory: " + createDir);
                dir.mkdirs();
            }

            for (File item : from.listFiles()) {
                recursiveList(item, to);
            }
        } else {
            System.out.println("Copy from: " + from);
            String dest = RecursiveCopyDirsDemo.to + relativeDirName;
            System.out.println("To: " + dest);
            Files.copy(Paths.get(from.getAbsolutePath()), Paths.get(dest));
        }
    }
}
