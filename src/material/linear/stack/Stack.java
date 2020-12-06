package material.linear.stack;

/**
 * Interface for a Stack (LIFO collection)
 *
 * @author Rackumi
 * @param <E> The generic type of the list
 */
public interface Stack<E> {

    /**
     * Checks the number of elements in this stack.
     *
     * @return the number of elements in the stack
     */
    int size();

    /**
     * Checks if the stack is empty.
     *
     * @return TRUE if the list is empty, FALSE otherwise
     */
    boolean isEmpty();

    /**
     * Inspects the element at the top of the stack.
     *
     * @return the element at the top of the stack.
     */
    E top();

    /**
     * Inserts an element at the top of the stack.
     *
     * @param element is the new element to be inserted.
     */
    void push(E element);

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element removed.
     */
    E pop();

}