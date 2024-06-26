package ar.edu.uade.tpo.ejercicio5;

import ar.edu.uade.tpo.common.Node;
import ar.edu.uade.tpo.common.Stack;

import java.util.Objects;

public class DynamicStack implements Stack<Character> {

    private Node<Character> first;


    @Override
    public void add(Character a) {
        this.first = new Node<>(a, this.first);
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        this.first = this.first.getNext();
    }

    @Override
    public Character getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        return this.first.getValue();
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(this.first);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Stack: [ ");
        Node<Character> current = this.first;
        while(current.getNext() != null) {
            stringBuilder.append(current.getValue()).append(", ");
            current = current.getNext();
        }
        stringBuilder.append(current.getValue()).append(" ]");

        return stringBuilder.toString();
    }
}
