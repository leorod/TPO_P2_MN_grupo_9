package ar.edu.uade.tpo.ejercicio3;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);

        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(4);
        queue2.add(5);
        queue2.add(6);

        QueuOfQueue<Integer> qoq = new QueuOfQueue<>();
        qoq.addQueue(queue1);
        qoq.addQueue(queue2);

        System.out.println("Flat queue: " + qoq.flat().toString());
        qoq.reverseWithDepth();
        System.out.println("Reversed queue of queues: " + qoq.flat().toString());
    }
}
