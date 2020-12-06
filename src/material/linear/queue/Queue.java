package material.linear.queue;

/**
 * Interface for a Queue (FIFO collection)
 *
 * @author Rackumi
 * @param <E> The generic type of the list
 */
public interface Queue<E> {

    /**
     * Checks the number of elements in this queue.
     *
     * @return the number of elements in the queue.
     */
    int size();

    /**
     * Checks if the queue is empty.
     *
     * @return TRUE if the queue is empty, FALSE otherwise.
     */
    boolean isEmpty();

    /**
     * Inspects the element at the front of the queue.
     *
     * @return the element at the front of the queue.
     */
    E front();

    /**
     * Inserts an element at the rear of the queue.
     *
     * @param element is the new element to be inserted.
     */
    void enqueue(E element);

    /**
     * Removes the element at the front of the queue.
     *
     * @return the element removed.
     */
    E dequeue();

}