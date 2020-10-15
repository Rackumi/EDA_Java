package material.linear.queue;

public class ArrayQueue<E> implements Queue<E> {

    /* Attributes */

    private int tail; //el head siempre seria la posicion 0
    private int capacity;
    private E[] q;

    /* Constructors */

    public ArrayQueue(){
        this.tail = 0;
        this.capacity= 15;
        this.q = (E[]) new Object[this.capacity];
    }

    public ArrayQueue(int capacity){
        this.tail = 0;
        this.capacity = capacity;
        q = (E[]) new Object[this.capacity];
    }

    @Override
    public int size() {
        return this.tail;
    }

    @Override
    public boolean isEmpty() {
        return (size()==0);
    }

    @Override
    public E front() throws RuntimeException{
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return this.q[0];
    }

    @Override
    public void enqueue(E element){
        if(this.tail == capacity/2){
            capacity *= 2;
            E[] q2 = (E[]) new Object[this.capacity];
            System.arraycopy(q,0,q2,0,tail);
            q = q2;
        }
        this.q[this.tail] = element;
        tail++;
    }

    @Override
    public E dequeue() throws RuntimeException {
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        E elem = this.q[0];
        System.arraycopy(q, 1, q, 0, this.tail - 1);
        this.tail--;
        return elem;
    }
}