package material.linear.stack;

public class ArrayStack<E> implements Stack<E>{

    /* Attributes */

    private int top; // posicion de la cabeza de la pila
    private int capacity;
    private E[] s;

    /* Constructors */

    public ArrayStack(){
        this.top = 0;
        this.capacity = 15;
        this.s = (E[]) new Object[this.capacity];
    }

    public ArrayStack(int capacity){
        this.top = 0;
        this.capacity = capacity;
        this.s = (E[]) new Object[this.capacity];
    }

    /* Methods */

    @Override
    public int size(){
        return this.top;
    }

    @Override
    public boolean isEmpty(){
        return this.top == 0;
    }

    @Override
    public E top() throws RuntimeException{
        if (isEmpty()){
            throw new RuntimeException("The stack is empty");
        }
        return s[this.top-1];
    }

    @Override
    public void push(E element){
        if(this.top == capacity/2){
            capacity *= 2;
            E[] s2 = (E[]) new Object[this.capacity];
            System.arraycopy(s,0,s2,0,top);
            s = s2;
        }
        this.s[this.top] = element;
        this.top++;
    }

    @Override
    public E pop() throws RuntimeException{
        if (isEmpty()){
            throw new RuntimeException("The stack is empty");
        }
        this.top--;
        return s[this.top];
    }

}