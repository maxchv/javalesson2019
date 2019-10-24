package org.itstep;


import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;


public class Demo7 {
    public static void main(String[] args) {
        // Конкурентные коллекции

        // CopyOnWriteArrayList<E>
        // CopyOnWriteArraySet<E>
        // ConcurrentSkipListSet<E>

        // ConcurrentHashMap<K, V>
        // ConcurrentSkipListMap<K, V>

        // ConcurrentLinkedQueue<E>
        // ConcurrentLinkedDeque<E>
        // ArrayBlockingQueue<E>
        // LinkedBlockingQueue<E>
        // PriorityBlockingQueue<E>
        // SynchronousQueue<E>

        Collection<Integer> list = new ConcurrentSkipListSet<>(Arrays.asList(1,2,3,4,5));//Arrays.asList(1,2,3,4,5);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next()+1);
        }
        System.out.println(list);
    }
}
