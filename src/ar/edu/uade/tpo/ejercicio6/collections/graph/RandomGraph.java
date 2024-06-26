package ar.edu.uade.tpo.ejercicio6.collections.graph;

import ar.edu.uade.tpo.common.Edge;
import ar.edu.uade.tpo.common.Graph;
import ar.edu.uade.tpo.common.GraphNode;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomGraph implements Graph {

    private static final int MAX_NODES = 15;

    private final GraphNode[] adjacencyList;
    private int totalNodes;
    private final Set<Edge> edges;

    public RandomGraph() {
        Random random = new Random();
        this.adjacencyList = new GraphNode[MAX_NODES];
        this.edges = new HashSet<>();

        int nodes = random.nextInt(MAX_NODES) + 1;
        for (int i = 0; i < nodes; i ++) {
            addNode(i);
        }

        int totalEdges = random.nextInt(totalNodes * (totalNodes - 1) / 2) + 1;
        for (int i = 0; i < totalEdges; i++) {
            GraphNode from = adjacencyList[random.nextInt(totalNodes)];
            GraphNode to = adjacencyList[random.nextInt(totalNodes)];
            addEdge(from.getValue(), to.getValue());
        }
    }

    private GraphNode getNode(int value) {
        for (int i = 0; i < this.totalNodes; i++) {
            if (adjacencyList[i].getValue() == value) {
                return adjacencyList[i];
            }
        }
        return null;
    }

    @Override
    public void addNode(int newNode) {
        if (this.totalNodes == MAX_NODES) {
            throw new IllegalArgumentException("Cantidad máxima de nodos alcanzada");
        }
        if (getNode(newNode) != null) {
            throw new IllegalArgumentException("El nodo ya existe");
        }
        this.adjacencyList[totalNodes] = new GraphNode(newNode, totalNodes);
        this.totalNodes++;
    }

    @Override
    public void removeNode(int value) {
        GraphNode target = getNode(value);
        if (target == null) {
            throw new NullPointerException("El nodo no existe");
        }

        for (GraphNode node : adjacencyList) {
            if (node != null && !node.equals(target) && node.getNext().contains(target)) {
                node.removeNext(target);
            }
        }
        this.totalNodes--;
        if (target.getIndex() == this.totalNodes) {
            adjacencyList[this.totalNodes] = null;
            return;
        }
        for (int i = target.getIndex(); i < totalNodes; i++) {
            adjacencyList[i] = adjacencyList[i + 1];
            adjacencyList[i].setIndex(i);
        }
    }

    @Override
    public Set<Integer> nodes() {
        Set<Integer> values = new HashSet<>();
        for (int i = 0; i < this.totalNodes; i++) {
            values.add(this.adjacencyList[i].getValue());
        }
        return values;
    }

    @Override
    public void addEdge(int from, int to) {
        GraphNode nodeFrom = getNode(from);
        if (nodeFrom == null) {
            throw new NullPointerException("El nodo origen no existe");
        }
        GraphNode nodeTo = getNode(to);
        nodeFrom.addNext(nodeTo);
        edges.add(new Edge(from, to));
    }

    @Override
    public void removeEdge(int from, int to) {
        GraphNode nodeFrom = getNode(from);
        if (nodeFrom == null) {
            throw new NullPointerException("El nodo origen no existe");
        }
        GraphNode nodeTo = getNode(to);
        nodeFrom.removeNext(nodeTo);
        this.edges.remove(new Edge(from, to));
    }

    @Override
    public boolean edgeExists(int from, int to) {
        GraphNode nodeFrom = getNode(from);
        if (nodeFrom == null) {
            throw new NullPointerException("El nodo origen no existe");
        }
        GraphNode nodeTo = getNode(to);
        return nodeFrom.getNext().contains(nodeTo);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Nodes: ").append(this.nodes());
        stringBuilder.append("\nEdges: \n");
        for (Edge edge : this.edges) {
            stringBuilder.append("  - ").append(edge).append("\n");
        }
        return stringBuilder.toString();
    }
}
