package ar.edu.uade.tpo.ejercicio7;

import java.util.LinkedList;
import java.util.List;

public class Path {
    private final int start;
    private final List<Integer> steps;
    private int end;

    public Path(int start) {
        this.start = start;
        this.steps = new LinkedList<>();
    }

    public Path(Path source) {
        this.start = source.start;
        this.steps = new LinkedList<>(source.getSteps());
    }

    public void addStep(int node) {
        this.steps.add(node);
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public List<Integer> getSteps() {
        return steps;
    }
}
