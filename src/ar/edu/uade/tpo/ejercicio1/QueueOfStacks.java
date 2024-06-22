package ar.edu.uade.tpo.ejercicio1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// COMPLEJIDAD COMPUTACIONAL DE LOS ALGORITMOS DE LA CLASE QueueOfStacks

// push(int stackIndex, int value)
// - Complejidad: O(n)
// - Justificación: Se recorre la lista de stacks hasta encontrar el stack con el índice stackIndex.

// getSize()
// - Complejidad: O(1)
// - Justificación: Se retorna el tamaño de la lista de stacks.

// transpose(QueueOfStacks qOfStacks)
// - Complejidad: O(n^2)
// - Justificación: Se recorren las n filas y n columnas de la matriz original.

// addMatrices(QueueOfStacks q1, QueueOfStacks q2)
// - Complejidad: O(n^2)
// - Justificación: Se recorren las n filas y n columnas de las matrices originales.

// CONCLUSIÓN
// La complejidad computacional de los algoritmos de la clase QueueOfStacks es O(n^2).


public class QueueOfStacks {
    private Queue<Stack<Integer>> queueOfStacks;

    public QueueOfStacks(int n) {
        queueOfStacks = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queueOfStacks.add(new Stack<>());
        }
    }

    public Queue<Stack<Integer>> getQueueOfStacks() {
        return queueOfStacks;
    }

    public void push(int stackIndex, int value) {
        int i = 0;
        for (Stack<Integer> stack : queueOfStacks) {
            if (i == stackIndex) {
                stack.push(value);
                return;
            }
            i++;
        }
    }

    public int getSize() {
        return queueOfStacks.size();
    }

    public QueueOfStacks transpose(QueueOfStacks qOfStacks) {
        int n = qOfStacks.getSize();
        QueueOfStacks transposed = new QueueOfStacks(n);
        Stack<Integer>[] stacks = new Stack[n];

        int i = 0;
        for (Stack<Integer> stack : qOfStacks.getQueueOfStacks()) {
            stacks[i] = stack;
            i++;
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (stacks[col].size() > row) {
                    transposed.push(row, stacks[col].get(row));
                }
            }
        }

        return transposed;
    }

    public QueueOfStacks addMatrices(QueueOfStacks q1, QueueOfStacks q2) {
        int n = q1.getSize();
        QueueOfStacks result = new QueueOfStacks(n);

        Stack<Integer>[] stacks1 = new Stack[n];
        Stack<Integer>[] stacks2 = new Stack[n];

        int i = 0;
        for (Stack<Integer> stack : q1.getQueueOfStacks()) {
            stacks1[i] = stack;
            i++;
        }

        i = 0;
        for (Stack<Integer> stack : q2.getQueueOfStacks()) {
            stacks2[i] = stack;
            i++;
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int value1 = stacks1[col].size() > row ? stacks1[col].get(row) : 0;
                int value2 = stacks2[col].size() > row ? stacks2[col].get(row) : 0;
                result.push(col, value1 + value2);
            }
        }

        return result;
    }
}
