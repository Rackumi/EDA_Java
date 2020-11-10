package material.linear.list;

import material.Position;

/**
 * DoubleLinkedList with Position (list of nodes).
 * @author Rackumi
 */

public class DoubleLinkedList<E> implements List<E> {

    /**
     * Node implemented with position
     * @param <E>
     */
    private class DNode<E> implements Position<E> {

        /* Attributes */

        private E elem;
        private DNode<E> prev, next;
        private DoubleLinkedList<E> myList;

        /* Constructors */

        public DNode(E e, DNode<E> p, DNode<E> n, DoubleLinkedList<E> l) {
            this.elem = e;
            this.prev = p;
            this.next = n;
            this.myList = l;
        }

        /* Methods */

        public E getElement() {
            return this.elem;
        }

        public void setElement(E elem) {
            this.elem = elem;
        }

        public DNode<E> getPrev() {
            return prev;
        }

        public void setPrev(DNode<E> prev) {
            this.prev = prev;
        }

        public DNode<E> getNext() {
            return next;
        }

        public void setNext(DNode<E> next) {
            this.next = next;
        }

        public DoubleLinkedList<E> getMyList() {
            return myList;
        }

        public void setMyList(DoubleLinkedList<E> myList) {
            this.myList = myList;
        }
    }

    /* Attributes */

    private int size;
    private DNode<E> head, tail; // Special sentinels ¿son size head y tail protected?

    /* Constructors */

    public DoubleLinkedList(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    /* Methods */

    /**
     * Private
     * Checks if position is valid for this list and converts it to DNode if it
     * is valid; O(1) time
     *
     * @param p the position to check
     * @return the position converted to DNode
     * @throws RuntimeException
     */
    private DNode<E> checkPosition(Position<E> p) throws RuntimeException {
        if ((p == null) || !(p instanceof DNode)) { //no haria falta la primera condicion
            throw new RuntimeException("The position is invalid. It´s either null or not an instance of DNode");
        }

        DNode<E> node = (DNode<E>) p;
        if (this != node.getMyList()) {
            throw new RuntimeException("The position refers to a node that is not in this list");
        }
        return node;
    }

    @Override
    public int size(){
        return this.size;
    }

    @Override
    public boolean isEmpty(){
        return this.size==0;
    }

    @Override
    public Position<E> first() throws RuntimeException {
        if (isEmpty()){
            throw new RuntimeException("List is empty");
        }
        return this.head;
    }

    @Override
    public Position<E> last() throws RuntimeException{
        if (isEmpty()){
            throw new RuntimeException("List is empty");
        }
        return this.tail;
    }

    @Override
    public Position<E> next(Position<E> p) throws RuntimeException {
        DNode<E> node = checkPosition(p);
        DNode<E> next = node.getNext();

        if(next == null){
            throw new RuntimeException("Cannot advance past the end of the list");
        }
        return next;
    }

    @Override
    public Position<E> prev(Position<E> p) throws RuntimeException {
        DNode<E> node = checkPosition(p);
        DNode<E> prev = node.getPrev();

        if(prev == null){
            throw new RuntimeException("Cannot advance past the beginning of the list");
        }
        return prev;
    }

    public Position<E> addFirst(E e){
        DNode<E> newNode;
        if(this.isEmpty()){
            newNode = new DNode<E>(e,null, null,this);
            this.head = newNode;
            this.tail = newNode;
        }
        else{
            newNode = new DNode<E>(e, null, this.head, this);
            this.head.setPrev(newNode);
            this.head = newNode;
        }
        this.size++;
        return newNode;
    }

    @Override
    public Position<E> addLast(E e) {
        DNode<E> newNode;
        if(this.isEmpty()){
            newNode = new DNode<E>(e,null, null,this);
            this.head = newNode;
            this.tail = newNode;
        }
        else{
            newNode = new DNode<E>(e, this.tail, null, this);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
        return newNode;
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws RuntimeException {
        DNode<E> node = checkPosition(p);
        DNode<E> newNode;

        if(node == tail){
            newNode = new DNode<E>(e,node,null,this);
            node.setNext(newNode);
            this.tail = newNode;
        }
        else{
            newNode = new DNode<E>(e,node,node.getNext(),this);
            node.getNext().setPrev(newNode);
            node.setNext(newNode);
        }

        this.size++;
        return newNode;
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws RuntimeException {
        DNode<E> node = checkPosition(p);
        DNode<E> newNode;

        if(node == head){
            newNode = new DNode<E>(e,null,node,this);
            node.setPrev(newNode);
            this.head = newNode;
        }
        else{
            newNode = new DNode<E>(e,node.getPrev(),node,this);
            node.getPrev().setNext(newNode);
            node.setPrev(newNode);
        }

        this.size++;
        return newNode;
    }

    public E remove(Position<E> p) throws RuntimeException{

        DNode<E> node = checkPosition(p);

        E elem = p.getElement(); //E elem.getElement();

        if(this.head == this.tail){ //un solo elemento en la lista
            this.head = null;
            this.tail = null;
        }
        else if(node == this.head){ //borrar el primer elemento
            this.head = this.head.getNext();
            node.getNext().setPrev(null);
        }
        else if(node == this.tail){ //borrar el ultimo elemento
            this.tail = this.tail.getPrev();
            node.getPrev().setNext(null);
        }
        else{ //borrar un elemento del medio
            DNode<E> nodePrev = node.getPrev();
            DNode<E> nodeNext = node.getNext();
            nodePrev.setNext(nodeNext);
            nodeNext.setPrev(nodePrev);
        }
        this.size--;
        return elem;
    }

    @Override
    public E set(Position<E> p, E e) throws RuntimeException {
        DNode<E> node = checkPosition(p);
        E oldElt = node.getElement();
        node.setElement(e);
        return oldElt;
    }

    // Convenience methods
    /**
     * Checks if a position is the first one in the list; O(1) time
     *
     * @param p the position to check
     * @return TRUE if p is the first position, FALSE otherwise
     */
    public boolean isFirst(Position<E> p) throws RuntimeException {
        DNode<E> v = checkPosition(p);
        return v == head;
    }

    /**
     * Checks if a position is the last one in the list; O(1) time
     *
     * @param p the position to check
     * @return TRUE if p is the last position, FALSE otherwise
     */
    public boolean isLast(Position<E> p) throws RuntimeException {
        DNode<E> v = checkPosition(p);
        return v == tail;
    }

    /**
     * Swaps the elements of two give positions; O(1) time
     *
     * @param a the first position to swap
     * @param b the second position to swap
     */
    public void swapElements(Position<E> a, Position<E> b)
            throws RuntimeException {
        DNode<E> pA = checkPosition(a);
        DNode<E> pB = checkPosition(b);
        E temp = pA.getElement();
        pA.setElement(pB.getElement());
        pB.setElement(temp);
    }

}