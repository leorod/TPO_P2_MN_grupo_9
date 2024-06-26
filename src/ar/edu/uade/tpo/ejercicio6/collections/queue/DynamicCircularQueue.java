package ar.edu.uade.tpo.ejercicio6.collections.queue;

import ar.edu.uade.tpo.ejercicio6.collections.TwoWayNode;

import java.util.Objects;

public class DynamicCircularQueue implements Queue {

    private TwoWayNode first;
    private TwoWayNode last;


    @Override
    public void add(int a) {
        if (this.first == null) {
            this.first = new TwoWayNode(a, null, null);
            this.last = this.first;
        } else {
            TwoWayNode next = this.first;
            this.first = new TwoWayNode(a, next, null);
            if (next.getNext() == null) {
                this.last = next;
            }
            next.setPrevious(this.first);
            this.first.setPrevious(this.last);
        }
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacia");
        }

        if(this.first.getNext() == null) {
            this.first = null;
            this.last = null;
            return;
        }

        TwoWayNode newLast = this.last.getPrevious();
        newLast.setNext(null);
        this.first.setPrevious(newLast);
        this.last = newLast;
    }

    @Override
    public int getFirst() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar una pila vacia");
        }
        return this.last.getValue();
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(this.first);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Queue: [ ");
        TwoWayNode current = this.first;
        while(current.getNext() != null) {
            stringBuilder.append(current.getValue()).append(", ");
            current = current.getNext();
        }
        stringBuilder.append(current.getValue()).append(" ]");
        if (this.first != null) {
            stringBuilder.append(" - First: ").append(this.first.getValue()).append(" | Last: ").append(this.last.getValue());
        }

        return stringBuilder.toString();
    }
}
