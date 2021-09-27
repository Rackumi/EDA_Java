package structures.linear.stack;

public class ArrayStackFloatNoExcept{

    /* Attributes */

    private float[] s;
    private int top; //marca la primera posicion vacia del array
    private final int MAX_SIZE;

    /* Constructors */

    public ArrayStackFloatNoExcept(int cap){
        this.MAX_SIZE = cap;
        this.top = 0; // no haria falta xq top ya se inicializa a 0 (Java siempre inicializa a estados conocidos)
        this.s = new float[cap];
    }

    /* Methods */

    public int size(){ // O(1)
        return this.top; // devolveria top y no top-1 xq cuenta la posicion 0
    }

    public boolean isEmpty(){ // O(1)
        return (this.top == 0);
    }

    public float top(){ // O(1)
        if(!this.isEmpty()){
            return this.s[this.top-1];
        }
        System.out.println("The stack is empty");
        return -1;
    }

    public float pop(){ // O(1)
        if(!this.isEmpty()){
            this.top--;
            return this.s[this.top];
        }
        System.out.println("The stack is empty");
        return -1;
    }

    public void push(float elem){ // O(1)
        if(this.top < this.MAX_SIZE-1){
            this.s[this.top] = elem;
            this.top++;
        }
        else{
            System.out.println("The stack is full");
        }
    }

}