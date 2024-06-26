package ar.edu.uade.tpo.ejercicio7.graph.path;

import ar.edu.uade.tpo.common.GraphNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PathVisitor {
    private List<Path> paths;

    public PathVisitor() {
        this.paths = new LinkedList<>();
    }

    public void visit(GraphNode root) {
        visit(root, new Path(root.getValue()), new HashSet<>());
    }

    public void visit(GraphNode node, Path path, Set<GraphNode> visited) {
        visited.add(node);
        path.addStep(node.getValue());
        for (GraphNode nextNode : node.getNext()) {
            if (!visited.contains(nextNode) || nextNode.getValue() == path.getStart()) {
                nextNode.accept(this, new Path(path), visited);
            }
        }

        path.setEnd(node.getValue());
        paths.add(path);
    }

    public List<Path> getPaths() {
        return paths;
    }


}
