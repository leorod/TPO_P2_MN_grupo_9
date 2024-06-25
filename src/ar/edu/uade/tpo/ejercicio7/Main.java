package ar.edu.uade.tpo.ejercicio7;

import ar.edu.uade.tpo.ejercicio7.graph.DynamicDirectedGraph;
import ar.edu.uade.tpo.ejercicio7.graph.Graph;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        DynamicDirectedGraph graph = new DynamicDirectedGraph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);

        Set<Graph> stronglyConnectedGraphs = graph.getStronglyConnectedComponents();
        for (Graph scc : stronglyConnectedGraphs) {
            System.out.println(scc);
        }
    }
}
