package ar.edu.uade.tpo.ejercicio4;

public class Main {
    public static void main(String[] args) {
        // Uso del Set con el patrón Builder
        Set<String> set = new Set.Builder<String>()
                .add("a")
                .add("b")
                .build();
        
        Set<String> anotherSet = new Set.Builder<String>()
                .add("c")
                .addAll(set)
                .build();

        System.out.println("Set: " + set);
        System.out.println("Another Set: " + anotherSet);

        // Uso del Stack con el patrón Builder
        Stack<Integer> stack = new Stack.Builder<Integer>()
                .add(1)
                .add(2)
                .add(3)
                .build();

        System.out.println("Stack: " + stack);

        // Uso del Queue con cantidad de parámetros variables
        Queue<Integer> queue = new Queue<>(4, 5, 6);
        System.out.println("Queue: " + queue);
    }
}
