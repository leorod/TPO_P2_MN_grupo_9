package ar.edu.uade.tpo.ejercicio3;
import java.util.Queue;


public interface QueueOfQueueInterface<T> {
    void concatenate(QueuOfQueue<T>... others);
    Queue<T> flat();
    void reverseWithDepth();
}
