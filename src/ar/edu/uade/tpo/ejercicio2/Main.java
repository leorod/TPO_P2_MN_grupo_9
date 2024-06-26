package ar.edu.uade.tpo.ejercicio2;

import java.util.Stack;

import static ar.edu.uade.tpo.ejercicio2.SetUtils.copySet;
import static ar.edu.uade.tpo.ejercicio2.StackUtils.reverseStack;

public class Main {
    public static void main(String[] args) {
        // Ejercicio 2.1
        Set<String> originalSet = new Set<>();
        originalSet.add("a");
        originalSet.add("b");
        originalSet.add("c");

        System.out.println("Original Set: " + originalSet);

        Set<String> copiedSet = copySet(originalSet);
        System.out.println("Copied Set: " + copiedSet);

        // Ejercicio 2.2
        java.util.Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Original Stack: " + stack);

        reverseStack(stack);
        System.out.println("Reversed Stack: " + stack);
    }
}
