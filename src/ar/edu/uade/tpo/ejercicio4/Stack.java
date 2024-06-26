package ar.edu.uade.tpo.ejercicio4;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack<T> {
    private List<T> items = new ArrayList<>();

    public static class Builder<T> {
        private Stack<T> stack;

        public Builder() {
            stack = new Stack<>();
        }

        public Builder<T> add(T item) {
            stack.items.add(item);
            return this;
        }

        public Stack<T> build() {
            return stack;
        }
    }

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items.remove(items.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        return "Stack{" + "items=" + items + '}';
    }
}

