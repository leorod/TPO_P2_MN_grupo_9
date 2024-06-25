package ar.edu.uade.tpo.ejercicio7.graph;

import ar.edu.uade.tpo.ejercicio7.graph.path.Path;
import ar.edu.uade.tpo.ejercicio7.graph.path.PathVisitor;

import java.util.HashSet;
import java.util.Set;

public class Node {

    private final int value;
    private int index;
    private final Set<Node> next;

    public Node(int value, int index) {
        this.value = value;
        this.index = index;
        this.next = new HashSet<>();
    }

    public int getValue() {
        return value;
    }

    public Set<Node> getNext() {
        return next;
    }

    public void addNext(Node node) {
        if (node == null) {
            throw new NullPointerException("El nodo destino no debe ser null");
        }
        this.next.add(node);
    }

    public void removeNext(Node node) {
        if (node == null) {
            throw new NullPointerException("El nodo destino no debe ser null");
        }
        this.next.remove(node);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void accept(PathVisitor visitor, Path path, Set<Node> visited) {
        visitor.visit(this, path, visited);
    }
}
