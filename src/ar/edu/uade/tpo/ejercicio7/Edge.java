package ar.edu.uade.tpo.ejercicio7;

public class Edge {
    private final int from;
    private final int to;

    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Edge)) {
            return false;
        }
        Edge other = (Edge) o;
        return this.from == other.from && this.to == other.to;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("[ From: ").append(this.from)
                .append(", To: ").append(this.to)
                .append(" ]")
                .toString();
    }
}
