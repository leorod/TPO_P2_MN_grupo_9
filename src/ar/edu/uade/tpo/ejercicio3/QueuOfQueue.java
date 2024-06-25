package ar.edu.uade.tpo.ejercicio3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueuOfQueue<T> implements QueueOfQueueInterface<T> {
    private Queue<Queue<T>> queueOfQueues;

    public QueuOfQueue() {
        queueOfQueues = new LinkedList<>();
    }

    @Override
    public void concatenate(QueuOfQueue<T>... others) {
        for (QueuOfQueue<T> other : others) {
            for (Queue<T> queue : other.queueOfQueues) {
                Queue<T> newQueue = new LinkedList<>(queue);
                this.queueOfQueues.add(newQueue);
            }
        }
    }

    @Override
    public Queue<T> flat() {
        Queue<T> flatQueue = new LinkedList<>();
        for (Queue<T> queue : queueOfQueues) {
            flatQueue.addAll(queue);
        }
        return flatQueue;
    }

    @Override
    public void reverseWithDepth() {
        Stack<Queue<T>> stack = new Stack<>();
        while (!queueOfQueues.isEmpty()) {
            stack.push(queueOfQueues.poll());
        }

        while (!stack.isEmpty()) {
            Queue<T> reversedQueue = new LinkedList<>();
            Queue<T> originalQueue = stack.pop();

            Stack<T> tempStack = new Stack<>();
            while (!originalQueue.isEmpty()) {
                tempStack.push(originalQueue.poll());
            }
            while (!tempStack.isEmpty()) {
                reversedQueue.add(tempStack.pop());
            }

            queueOfQueues.add(reversedQueue);
        }
    }

    public void addQueue(Queue<T> queue) {
        queueOfQueues.add(queue);
    }
}
