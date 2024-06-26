package ar.edu.uade.tpo.common;

import java.util.Set;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface Graph {

    /**
     * Precondicion: El nodo no existe.
     * @param node, valor del nodo a agregar.
     */
    void addNode(int node);

    /**
     * Precondicion: El nodo existe.
     * @param node, valor que representa el nodo a borrar.
     */
    void removeNode(int node);

    /**
     * @return conjunto con todos los nodos presentes.
     */
    Set<Integer> nodes();

    /**
     * Precondicion: No existe la arista pero existen los nodos.
     * @param from, nodo del cual sale la arista.
     * @param to, nodo al cual llega la arista.
     */
    void addEdge(int from, int to);

    /**
     * Precondicion: Existe la arista
     * @param from, nodo del cual sale la arista.
     * @param to, nodo al cual llega la arista.
     */
    void removeEdge(int from, int to);

    /**
     * Precondicion: Existen los nodos
     * @param from, nodo del cual sale la arista.
     * @param to, nodo al cual llega la arista.
     * @return <code>true</code> si la arista existe, <code>false</code> en otro caso.
     */
    boolean edgeExists(int from, int to);

}
