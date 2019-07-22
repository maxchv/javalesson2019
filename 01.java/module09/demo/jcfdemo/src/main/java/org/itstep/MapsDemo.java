package org.itstep;

import java.util.*;

public class MapsDemo {
    public static void main(String[] args) {
        Map<String, List<Student>> groups = new HashMap<>();

        groups.put("Java Spring 2019", new ArrayList<>());

        ArrayList<Student> groupWinter2019 = new ArrayList<>();
        groups.put("Java Winter 2019", groupWinter2019);


        if(groups.containsKey("Java Spring 2019")) {
            List<Student> group = groups.get("Java Spring 2019");

            group.add(new Student("Вася", 10, 1));
            group.add(new Student("Маша", 21, 0));
            group.add(new Student("Рома", 23, 3));

            for (Map.Entry<String, List<Student>> entry : groups.entrySet()) {
                System.out.println(entry.getKey() + ": " + Arrays.toString(entry.getValue().toArray()));
            }

            for(String key: groups.keySet()) {
                System.out.println(key);
            }
        }
    }
}
