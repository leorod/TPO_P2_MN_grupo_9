package ar.edu.uade.tpo.ejercicio4;

import java.util.LinkedList;

public class Queue<T> {
    private LinkedList<T> items = new LinkedList<>();

    @SafeVarargs
    public Queue(T... elements) {
        for (T element : elements) {
            items.addLast(element);
        }
    }

    public void enqueue(T item) {
        items.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return items.removeFirst();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        return "Queue{" + "items=" + items + '}';
    }
}
