package ar.edu.uade.tpo.ejercicio6;

import ar.edu.uade.tpo.common.Graph;
import ar.edu.uade.tpo.ejercicio6.collections.graph.RandomGraph;
import ar.edu.uade.tpo.ejercicio6.collections.queue.DynamicCircularQueue;
import ar.edu.uade.tpo.ejercicio6.collections.queue.Queue;
import ar.edu.uade.tpo.ejercicio6.collections.set.DynamicRepeatableSet;
import ar.edu.uade.tpo.ejercicio6.collections.set.DynamicSuperSet;
import ar.edu.uade.tpo.ejercicio6.collections.set.Set;
import ar.edu.uade.tpo.ejercicio6.collections.set.SuperSet;
import ar.edu.uade.tpo.ejercicio6.collections.stack.DynamicLimitedStack;
import ar.edu.uade.tpo.common.Stack;

public class Main {
    public static void main(String[] args) {
        //1 - Pila dinámica con capacidad limitada
        Stack limitedStack = new DynamicLimitedStack(3);
        limitedStack.add(1);
        limitedStack.add(2);
        limitedStack.add(3);
        try {
            limitedStack.add(4);
        } catch (IllegalStateException e) {
            System.out.println("Error al apilar el 4to elemento. " + e.getMessage());
        }

        System.out.println("\n=====\n");

        //2 - Superconjunto
        SuperSet superSet = new DynamicSuperSet();
        superSet.add(1);
        superSet.add(2);
        superSet.add(3);
        superSet.add(4);
        superSet.add(5);
        Set subSet = new DynamicSuperSet();
        subSet.add(1);
        subSet.add(2);
        subSet.add(3);
        System.out.println(superSet.isSubSet(subSet)
                ? "El conjunto pasado por parámetro es un subconjunto"
                : "El conjunto pasado por parámetro no es un subconjunto");

        Set otherSet = new DynamicSuperSet();
        otherSet.add(1);
        otherSet.add(2);
        otherSet.add(3);
        otherSet.add(10);
        otherSet.add(11);
        System.out.println("Conjunto complemento: " + superSet.complement(otherSet));

        System.out.println("\n=====\n");

        //3 - Cola cíclica doblemente enlazada
        Queue queue = new DynamicCircularQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println("Estado de cola inicial:");
        System.out.println(queue);
        System.out.println("Estado de cola post borrado:");
        queue.remove();
        System.out.println(queue);

        System.out.println("\n=====\n");

        //4 - Conjunto de repetidos
        Set repeatableSet = new DynamicRepeatableSet();
        repeatableSet.add(1);
        repeatableSet.add(2);
        repeatableSet.add(3);
        repeatableSet.add(4);
        repeatableSet.add(1);
        repeatableSet.add(2);
        repeatableSet.add(2);
        System.out.println("Conjunto de repetidos:");
        System.out.println(repeatableSet);

        System.out.println("\n=====\n");

        //5 - Grafo aleatorio
        Graph randomGraph = new RandomGraph();
        System.out.println(randomGraph);

    }
}
