package material.linear.stack;

/**
 * Interface for a Stack (LIFO collection)
 *
 * @author Rackumi
 **/

public interface Stack<E> {

    //returns number of elements in the stack.
    int size();

    //returns true if the stack is empty, false otherwise.
    boolean isEmpty();

    //returns element at the top of the stack.
    E top();

    //Inserts an element, the parameter, at the top of the stack.
    void push(E element);

    //Removes the element at the top of the stack and returns it
    E pop();

}
