package structures.linear.stack;

public class LinkedStackFloatNoExcept{

    /* Classes */

    private class Node{ // this.top = nodo; con esto haces que el objeto top apunte a nodo

        /* Attributes */

        private float element;
        private Node next;

        /* Constructors */

        public Node(float e, Node n){
            this.element = e;
            this.next = n;
        }

        /* Getters and Setters */

        public float getElement(){
            return this.element;
        }

        public Node getNext(){
            return this.next;
        }

    }

    /* Attributes */

    private Node top;
    private int size;

    /* Constructors */

    public LinkedStackFloatNoExcept(){
        this.top = null;
        this.size = 0;
    }

    /* Methods */

    public int size(){ // O(1)
        return this.size;
    }

    public boolean isEmpty(){ // O(1)
        return (this.size == 0); // this.top==null
    }

    public float top(){ // O(1) no devolver el nodo
        if(!this.isEmpty()){
            return this.top.getElement();
        }
        System.out.println("The stack is empty");
        return -1;
    }

    public float pop(){ // O(1)
        if(!this.isEmpty()){
            this.size--;
            float e = this.top.getElement(); //float e = this.top();
            this.top = this.top.getNext();
            return e;
        }
        System.out.println("The stack is empty");
        return -1;
    }

    public void push(float elem){ // O(1)
        Node nodo = new Node(elem, this.top);
        this.top = nodo;
        this.size++;
    }

}