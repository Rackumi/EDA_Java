package material.linear.queue;

/**
 * Interface for a Queue (FIFO collection)
 *
 * @author Rackumi
 **/

public interface Queue<E>{

    //returns number of elements in the queue.
    int size();

    //returns true if the queue is empty, false otherwise.
    boolean isEmpty();

    //returns element at the front of the queue.
    E front();

    //Inserts an element, the parameter, at the rear of the queue.
    void enqueue(E element);

    //Removes the element at the front of the queue and returns it
    E dequeue();
}