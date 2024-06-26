package ar.edu.uade.tpo.ejercicio6.collections.set;

public interface SuperSet extends Set {
    boolean isSubSet(Set other);
    Set complement(Set other);
}
