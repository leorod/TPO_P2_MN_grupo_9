package ar.edu.uade.tpo.ejercicio6.collections.stack;

import ar.edu.uade.tpo.ejercicio6.collections.Node;

import java.util.Objects;

public class DynamicLimitedStack implements Stack {
    private final int maxSize;
    private int count;
    private Node<Integer> first;

    public DynamicLimitedStack(int maxSize) {
        this.maxSize = maxSize;
        this.count = 0;
    }

    @Override
    public void add(int a) {
        if (this.count == maxSize) {
            throw new IllegalStateException("La pila está llena, no es posible apilar");
        }
        this.first = new Node(a, this.first);
        this.count++;
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        this.first = this.first.getNext();
        this.count--;
    }

    @Override
    public int getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        return this.first.getValue();
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(this.first);
    }
}
