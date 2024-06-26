package ar.edu.uade.tpo.ejercicio4;

import java.util.HashSet;

public class Set<T> {
    private HashSet<T> items = new HashSet<>();

    public static class Builder<T> {
        private Set<T> set;

        public Builder() {
            set = new Set<>();
        }

        public Builder<T> add(T item) {
            set.items.add(item);
            return this;
        }

        public Builder<T> addAll(Set<T> otherSet) {
            set.items.addAll(otherSet.items);
            return this;
        }

        public Set<T> build() {
            return set;
        }
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
}
