package SDET_Day9;

import java.util.*;

public class Q2_linkedList {
    public static void main(String[] args) {

        LinkedList<String> queue = new LinkedList<>();

        queue.addLast("Rahul");
        queue.addLast("Aman");
        queue.addFirst("Critical Patient");
        System.out.println("Queue: " + queue);

        if (!queue.isEmpty()) {
            System.out.println("First: " + queue.getFirst());
            System.out.println("Last: " + queue.getLast());
        }

        if (!queue.isEmpty()) {
            System.out.println(queue.removeFirst() + " treated and removed.");
        }
        
        System.out.println("Updated Queue: " + queue);
    }
}