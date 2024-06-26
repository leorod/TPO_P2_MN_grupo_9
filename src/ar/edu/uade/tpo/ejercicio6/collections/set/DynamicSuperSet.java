package ar.edu.uade.tpo.ejercicio6.collections.set;

import ar.edu.uade.tpo.ejercicio6.collections.Node;

import java.util.Random;

public class DynamicSuperSet implements SuperSet {

    private Node<Integer> first;
    private int count;

    @Override
    public void add(int a) {
        Node<Integer> current = this.first;
        while(current != null && current.getValue() != a) {
            current = current.getNext();
        }
        if(current == null) {
            this.first = new Node<>(a, this.first);
            this.count++;
        }
    }

    @Override
    public void remove(int a) {
        if(this.isEmpty()) {
            return;
        }
        if(this.first.getNext() == null) {
            if(this.first.getValue() == a) {
                this.first = null;
                this.count--;
            }
            return;
        }

        if(this.first.getValue() == a) {
            this.first = this.first.getNext();
            this.count--;
            return;
        }

        Node<Integer> backup = this.first;
        Node<Integer> current = this.first.getNext();
        while(current != null && current.getValue() != a) {
            backup = current;
            current = current.getNext();
        }

        if(current != null) {
            backup.setNext(current.getNext());
            this.count--;
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
        Node<Integer> current = this.first;
        for(int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    @Override
    public Set copy() {
        Set set = new DynamicSuperSet();
        Node<Integer> current = this.first;
        while (current != null) {
            set.add(current.getValue());
            current = current.getNext();
        }
        return set;
    }

    /**
     * Calculo el conjunto complemento y devuelvo el resultado de evaluar si está vacío.
     * Si el conjunto complemento está vacío, significa que el conjunto recibido por parámetro es un subconjunto del original,
     * ya que todos sus elementos están presentes en el mismo.
     * @param other Conjunto para evaluar contra el conjunto original
     * @return true si es un subconjunto, false si no lo es.
     */
    @Override
    public boolean isSubSet(Set other) {
        return this.complement(other).isEmpty();
    }

    /**
     * Calculo el complemento haciendo una copia del Conjunto recibido por parámetro, y eliminando todos los elementos
     * que existan en el Conjunto original.
     * El resultado es el conjunto complemento, ya que en la copia sólo quedarán los elementos que no existen en el conjunto original.
     * @param other Conjunto a partir del cual calcular el complemento, sobre el Conjunto original (this)
     * @return Conjunto complemento
     */
    @Override
    public Set complement(Set other) {
        Set copy = other.copy();
        Node<Integer> current = this.first;
        while (current != null) {
            copy.remove(current.getValue());
            current = current.getNext();
        }
        return copy;
    }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        Node<Integer> current = this.first;
        while (current != null) {
            stringBuilder.append(current.getValue()).append(" ");
            current = current.getNext();
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
