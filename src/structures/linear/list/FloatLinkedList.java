package structures.linear.list;

public class FloatLinkedList implements FloatList{

    private class FloatNode {

        private FloatNode next;
        private Float element;

        public FloatNode(float element){
            this.element = element;
            this.next = null;
        }

        public FloatNode getNext() {
            return next;
        }

        public void setNext(FloatNode next) {
            this.next = next;
        }

        public Float getElement() {
            return element;
        }

        public void setElement(Float element) {
            this.element = element;
        }
    }

    private FloatNode head;
    private int size;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isempty() {
        return this.size==0;
    }

    @Override
    public void add(Float value) {
        FloatNode node = new FloatNode(value);
        if(isempty()){
            head = node;
        }
        else{
            node.setNext(head);
            head = node;
        }
        this.size++;
    }

    @Override
    public void add(int index, Float value) {
        FloatNode node = new FloatNode(value);
        if(isempty()){
            head = node;
        }
        else{
            node.setNext(head);
            head = node;
        }
        this.size++;
    }

    @Override
    public Float remove() {
        this.size--;
        if(isempty()){
            head.setNext(null);
            return null;
        }
        else{
            head.setNext(head.getNext().getNext());
            return head.getNext().getElement();
        }
    }

    @Override
    public Float remove(int index) {
        this.size--;
        if(isempty()){
            head.setNext(null);
            return null;
        }
        else{
            head.setNext(head.getNext().getNext());
            return head.getNext().getElement();
        }

    }

    @Override
    public Float get() {
        if(isempty()){
            return null;
        }
        else{
            return head.getNext().getElement();
        }
    }

    @Override
    public Float get(int index) {
        if(isempty()){
            return null;
        }
        else{
            return head.getNext().getElement();
        }
    }

    @Override
    public int search(Float value) {
        if(!isempty()) {
            if (head.getElement().equals(value)) {
                return this.size+1-1;
            }
            else {
                int auxNum = 0;
                FloatNode aux = head;
                while(aux.getNext()!=null && !aux.getNext().getElement().equals(value)) {
                    auxNum++;
                    aux = aux.getNext();
                    if (aux.getElement().equals(value)) {
                        return this.size+1-auxNum;
                    }
                }
            }
        }
        return 0;
    }

    @Override
    public boolean contains(Float value) {
        if(!isempty()) {
            if (head.getElement().equals(value)) {
                return true;
            }
            else {
                FloatNode aux = head;
                while(aux.getNext()!=null && !aux.getNext().getElement().equals(value)) {
                    aux = aux.getNext();
                    if (aux.getElement().equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
}
