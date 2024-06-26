package ar.edu.uade.tpo.ejercicio6.collections;

public class Tuple {
    private final int value;
    private int quantity;

    public Tuple(int value, int quantity) {
        this.value = value;
        this.quantity = quantity;
    }

    public int getValue() {
        return value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
