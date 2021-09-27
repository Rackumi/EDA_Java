package structures.linear.queue;

public class LinkedQueue<E> implements Queue<E> {

    /* Inner classes */

    private class Node<E>{

        /* Attributes */

        private E element; //element
        private Node<E> next; //next node

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

    private int size;
    private Node<E> head;
    private Node<E> tail;

    /* Methods */

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public E front() throws RuntimeException{
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return this.head.getElement();
    }

    @Override
    public void enqueue(E element){
        Node<E> newNode = new Node<>(element);
        if(isEmpty()){
            this.head = newNode;
        } else {
            this.tail.setNext(newNode); //haces que el que está apuntando tail apunte ahora a newNode
        }
        this.tail = newNode; //tail ahora apunta a newNode tmb
        size++;
    }

    @Override
    public E dequeue() throws RuntimeException{
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        E element = this.front(); //guarda el elemento
        this.head = this.head.getNext();
        if(this.head == null) { //si se head se queda apuntando a la nada es que está vacia
            this.tail = null; //asique hacemos que tail tmb apunte a la nada
        }
        size--;
        return element;
    }

}