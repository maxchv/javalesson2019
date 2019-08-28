package org.itstep;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Slf4j
public class Application {

    public static void main(String[] args) {
        // 1.  File
        File file = new File("test.txt");
        if(!file.exists()) {
            System.out.println("Create file");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());

        File driveC = new File("c:\\");
        if(driveC.isDirectory()) {
            //Arrays.stream(driveC.list()).forEach(System.out::println);
        }

        File newDir = new File("dir");
        newDir.mkdir();

        // 2.  Byte Streams
        // 2.1 InputStream
        if(file.exists()) {
            try {
                InputStream in = new FileInputStream(file.getPath());
                //int _byte;
                //byte[] buffer = new byte[256];
                //while((_byte = in.read()) > 0) {
                //int count;
//                while((count = in.read(buffer)) > 0) {
//                    //System.out.print((char)_byte);
//                    String line = new String(buffer, 0, count);
//                    System.out.print(line);
//                }
                Scanner scanner = new Scanner(in);
                String line;
                try {
                    while(true) {
                        line = scanner.nextLine();
                        System.out.println(line);
                    }
                }catch (NoSuchElementException ex) {

                }
                System.out.println();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 2.2 OutputStream
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your task: ");
        String task = scanner.nextLine();
        try {
            OutputStream out = new FileOutputStream("task.txt");
            out.write(task.getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3.  Try with resources

        // 4.  Character Streams
        // 4.1 Reader

        // 4.2 Writer

        // 5.  Serialization
    }
}
