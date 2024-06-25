package ar.edu.uade.tpo.ejercicio7.graph;

import ar.edu.uade.tpo.ejercicio7.graph.path.Path;
import ar.edu.uade.tpo.ejercicio7.graph.path.PathVisitor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DynamicDirectedGraph implements Graph {

    private static final int MAX_NODES = 15;

    private final Node[] adjacencyList;
    private int totalNodes;
    private final Set<Edge> edges;

    public DynamicDirectedGraph() {
        this.adjacencyList = new Node[MAX_NODES];
        this.totalNodes = 0;
        this.edges = new HashSet<>();
    }

    private Node getNode(int value) {
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
        this.adjacencyList[totalNodes] = new Node(newNode, totalNodes);
        this.totalNodes++;
    }

    @Override
    public void removeNode(int value) {
        Node target = getNode(value);
        if (target == null) {
            throw new NullPointerException("El nodo no existe");
        }

        for (Node node : adjacencyList) {
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
        Node nodeFrom = getNode(from);
        if (nodeFrom == null) {
            throw new NullPointerException("El nodo origen no existe");
        }
        Node nodeTo = getNode(to);
        nodeFrom.addNext(nodeTo);
        edges.add(new Edge(from, to));
    }

    @Override
    public void removeEdge(int from, int to) {
        Node nodeFrom = getNode(from);
        if (nodeFrom == null) {
            throw new NullPointerException("El nodo origen no existe");
        }
        Node nodeTo = getNode(to);
        nodeFrom.removeNext(nodeTo);
        this.edges.remove(new Edge(from, to));
    }

    @Override
    public boolean edgeExists(int from, int to) {
        Node nodeFrom = getNode(from);
        if (nodeFrom == null) {
            throw new NullPointerException("El nodo origen no existe");
        }
        Node nodeTo = getNode(to);
        return nodeFrom.getNext().contains(nodeTo);
    }

    public Set<Graph> getStronglyConnectedComponents() {
        Set<Graph> stronglyConnectedComponents = new HashSet<>();
        PathVisitor pathVisitor = new PathVisitor();
        for (int i = 0; i < this.totalNodes; i++) {
            pathVisitor.visit(adjacencyList[i]);
        }
        List<Path> paths = pathVisitor.getPaths();
        for (Path path : paths) {
            if (path.getStart() == path.getEnd()) {
                Graph graph = new DynamicDirectedGraph();
                int previous = -1;
                Set<Integer> added = new HashSet<>();
                for (int step : path.getSteps()) {
                    if (!added.contains(step)) {
                        graph.addNode(step);
                        added.add(step);
                    }
                    if (previous > -1) {
                        graph.addEdge(previous, step);
                    }
                    previous = step;
                }
                stronglyConnectedComponents.add(graph);
            }
        }
        return stronglyConnectedComponents;
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
