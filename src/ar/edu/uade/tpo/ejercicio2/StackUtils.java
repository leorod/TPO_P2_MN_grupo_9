package ar.edu.uade.tpo.ejercicio2;

import java.util.Stack;

public class StackUtils {
    public static <T> void reverseStack(Stack<T> stack) {
        if (stack.isEmpty()) {
            return;
        }
        T bottom = popBottom(stack);
        reverseStack(stack);
        stack.push(bottom);
    }

    private static <T> T popBottom(Stack<T> stack) {
        T top = stack.pop();
        if (stack.isEmpty()) {
            return top;
        } else {
            T bottom = popBottom(stack);
            stack.push(top);
            return bottom;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Original Stack: " + stack);
        
        reverseStack(stack);
        System.out.println("Reversed Stack: " + stack);
    }
}

