package org.itstep;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Slf4j
public class Application {

    public static void main(String[] args) throws MalformedURLException {
        //start();

        String testData = "Hello ByteArrayInputStream";
        try {
            //System.setIn(new FileInputStream("test.txt"));
            System.setIn(new ByteArrayInputStream(testData.getBytes()));
            Scanner sc = new Scanner(System.in);
            while (true) {
                String line = sc.nextLine();
                System.out.println(line);
            }
        } catch (Throwable e) {

        }

        System.setIn(null);

        // unified resource locator: http://itstep.dp.ua, file:///c/program files
        URL url = new URL("https://itstep.dp.ua");

        // 3.  Try with resources. Since jdk 7
        try (InputStream in = url.openStream();
        //     BufferedInputStream bin = new BufferedInputStream(in)
             InputStreamReader inRdr = new InputStreamReader(in, "utf-8");
             BufferedReader buffRdr = new BufferedReader(inRdr)
        ) {

            String line;
            while((line = buffRdr.readLine()) != null) {
                System.out.println(line);
            }
//            byte[] buff = new byte[256];
//            int count = 0;
//            while ((count = bin.read(buff)) > 0) {
//                System.out.println(new String(buff, 0, count));
//            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(OutputStream out = new FileOutputStream("data.txt");
            DataOutputStream dout = new DataOutputStream(out)) {
            dout.writeInt(10);
            dout.writeInt(20);
            dout.writeBoolean(true);
            dout.writeUTF("Привет Мир");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(InputStream in = new FileInputStream("data.txt");
            DataInputStream din = new DataInputStream(in)) {
            int num1 = din.readInt();
            int num2 = din.readInt();
            boolean b = din.readBoolean();
            String s = din.readUTF();
            System.out.println(num1 + " " + num2 + " " + b + " " + s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4.  Character Streams
        // 4.1 Reader
        try(Reader reader = new FileReader("test.txt")) {
            int ch;
            while((ch = reader.read()) > 0) {
                System.out.print((char)ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

        // 4.2 Writer



        // 5.  Serialization
        // Сериализация
        try(OutputStream out = new FileOutputStream("car.data");
            ObjectOutputStream objOut = new ObjectOutputStream(out)) {
            Car car = new Car("Таврия", 100, "Баклажан");
            objOut.writeObject(car);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Десериализация
        try(InputStream in = new FileInputStream("car.data");
            ObjectInputStream objOut = new ObjectInputStream(in)) {
            Car car = (Car) objOut.readObject();
            System.out.println(car);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 6.  Path

        // 7.  Files

    }

    private static void start() {
        // 1.  File
        File file = new File("test.txt");
        if (!file.exists()) {
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
        if (driveC.isDirectory()) {
            //Arrays.stream(driveC.list()).forEach(System.out::println);
        }

        File newDir = new File("dir");
        newDir.mkdir();

        // 2.  Byte Streams
        // 2.1 InputStream
        if (file.exists()) {
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
                    while (true) {
                        line = scanner.nextLine();
                        System.out.println(line);
                    }
                } catch (NoSuchElementException ex) {

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
    }
}

class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private transient String model;
    private double price;
    private String color;

    public Car(String model, double price, String color) {
        this.model = model;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
