package ar.edu.uade.tpo.ejercicio6.collections.set;

import ar.edu.uade.tpo.ejercicio6.collections.Node;
import ar.edu.uade.tpo.ejercicio6.collections.Tuple;

import java.util.Random;

public class DynamicRepeatableSet implements Set {

    private Node<Tuple> first;
    private int count;

    @Override
    public void add(int a) {
        Node<Tuple> current = this.first;
        while(current != null && current.getValue().getValue() != a) {
            current = current.getNext();
        }
        if(current == null) {
            this.first = new Node<>(new Tuple(a, 1), this.first);
            this.count++;
        } else {
            int quantity = current.getValue().getQuantity();
            current.getValue().setQuantity(quantity + 1);
        }
    }

    @Override
    public void remove(int a) {
        if(this.isEmpty()) {
            return;
        }
        if(this.first.getNext() == null) {
            if(this.first.getValue().getValue() == a) {
                int quantity = this.first.getValue().getQuantity();
                if (quantity == 1) {
                    this.first = null;
                    this.count--;
                } else {
                    this.first.getValue().setQuantity(quantity - 1);
                }
            }
            return;
        }

        Node<Tuple> backup = this.first;
        Node<Tuple> current = this.first.getNext();
        while(current != null && current.getValue().getValue() != a) {
            backup = current;
            current = current.getNext();
        }

        if(current != null) {
            int quantity = current.getValue().getQuantity();
            if (quantity == 1) {
                backup.setNext(current.getNext());
                this.count--;
            } else {
                current.getValue().setQuantity(quantity - 1);
            }
        }
        if (this.count == 0) {
            this.first = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int choose() {
        if(this.count == 0) {
            throw new RuntimeException("No se puede elegir un valor de un conjunto vacio");
        }
        int index = new Random().nextInt(count);
        Node<Tuple> current = this.first;
        for(int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue().getValue();
    }

    @Override
    public Set copy() {
        throw new RuntimeException("Metodo no implementado");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        Node<Tuple> current = this.first;
        while (current != null) {
            stringBuilder.append("(Val: ").append(current.getValue().getValue())
                    .append(", Qty: ").append(current.getValue().getQuantity()).append(") ");
            current = current.getNext();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
