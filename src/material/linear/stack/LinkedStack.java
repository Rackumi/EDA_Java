package material.linear.stack;

public class LinkedStack<E> implements Stack<E> {

    private class Node<T> {

        private E element;
        private Node<T> next;

        public Node(E element){
            this.setElement(element);
            setNext(null);
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

    }

    /* Attributes */

    private Node<E> top;
    private int size;

    /* Methods */

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (size==0);
    }

    @Override
    public E top() {
        if(!isEmpty()){
            return this.top.getElement();
        }
        throw new RuntimeException("The stack is empty");
    }

    @Override
    public void push(E element) {
        Node<E> nodo = new Node<>(element);
        if(isEmpty()){
            this.top = nodo;
        }
        else {
            nodo.setNext(this.top);
            this.top = nodo;
        }
        size++;
    }

    @Override
    public E pop() {
        if(!isEmpty()){
            size--;
            E element = this.top.getElement();
            this.top = this.top.getNext();
            return element;
        }
        throw new RuntimeException("The stack is empty");
    }

}