package structures.linear.list;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mayte
 */
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
            node.setNext(head.getNext());
            head.setNext(node);
        }
    }

    @Override
    public void add(int index, Float value) {
        FloatNode node = new FloatNode(value);
        if(isempty()){
            head.setNext(node);
        }
        else{
            node.setNext(head.getNext());
            head.setNext(node);
        }
    }

    @Override
    public Float remove() {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Float get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Float get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int search(Float value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Float value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
