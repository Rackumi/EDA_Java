package structures.linear.stack;

public class LinkedStack<E> implements Stack<E> {

    /* Inner classes */

    private class Node<E>{

        /* Attributes */

        private E element;
        private Node<E> next;

        /* Constructors */

        public Node(E element){
            this.setElement(element);
            setNext(null);
        }

        /* Getters and Setters */

        public E getElement(){
            return element;
        }

        public void setElement(E element){
            this.element = element;
        }

        public Node<E> getNext(){
            return next;
        }

        public void setNext(Node<E> next){
            this.next = next;
        }

    }

    /* Attributes */

    private Node<E> top;
    private int size;

    /* Methods */

    @Override
    public int size(){
        return this.size;
    }

    @Override
    public boolean isEmpty(){
        return (size==0);
    }

    @Override
    public E top() throws RuntimeException{
        if(!isEmpty()){
            return this.top.getElement();
        }
        throw new RuntimeException("The stack is empty");
    }

    @Override
    public void push(E element){
        Node<E> nodo = new Node<>(element);
        if(!isEmpty()){ // si no esta vacia hacemos que el nodo apunte al nodo anterior(apuntado por top)
            nodo.setNext(this.top);
        }
        this.top = nodo;
        size++;
    }

    @Override
    public E pop() throws RuntimeException{
        if(!isEmpty()){
            size--;
            E element = this.top.getElement();
            this.top = this.top.getNext();
            return element;
        }
        throw new RuntimeException("The stack is empty");
    }

}