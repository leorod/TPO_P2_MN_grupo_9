package ar.edu.uade.tpo.ejercicio6.collections;

public class TwoWayNode {
    private int value;
    private TwoWayNode previous;
    private TwoWayNode next;

    public TwoWayNode(int value, TwoWayNode next, TwoWayNode previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TwoWayNode getNext() {
        return next;
    }

    public void setNext(TwoWayNode next) {
        this.next = next;
    }

    public TwoWayNode getPrevious() {
        return previous;
    }

    public void setPrevious(TwoWayNode previous) {
        this.previous = previous;
    }
}
