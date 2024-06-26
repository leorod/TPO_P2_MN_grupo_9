package ar.edu.uade.tpo.common;

import ar.edu.uade.tpo.ejercicio7.graph.path.Path;
import ar.edu.uade.tpo.ejercicio7.graph.path.PathVisitor;

import java.util.HashSet;
import java.util.Set;

public class GraphNode {

    private final int value;
    private int index;
    private final Set<GraphNode> next;

    public GraphNode(int value, int index) {
        this.value = value;
        this.index = index;
        this.next = new HashSet<>();
    }

    public int getValue() {
        return value;
    }

    public Set<GraphNode> getNext() {
        return next;
    }

    public void addNext(GraphNode node) {
        if (node == null) {
            throw new NullPointerException("El nodo destino no debe ser null");
        }
        this.next.add(node);
    }

    public void removeNext(GraphNode node) {
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

    public void accept(PathVisitor visitor, Path path, Set<GraphNode> visited) {
        visitor.visit(this, path, visited);
    }
}
