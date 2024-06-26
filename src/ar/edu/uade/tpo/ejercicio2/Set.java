package ar.edu.uade.tpo.ejercicio2;

import java.util.HashSet;

public class Set<T> {
    private HashSet<T> items = new HashSet<>();

    public void add(T item) {
        items.add(item);
    }

    public boolean remove(T item) {
        return items.remove(item);
    }

    public boolean contains(T item) {
        return items.contains(item);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        return "Set{" + "items=" + items + '}';
    }

    public HashSet<T> getItems() {
        return items;
    }
}
