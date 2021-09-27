package structures.tree.binarytree;

import structures.Position;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayBinaryTree<E> implements BinaryTree<E> {

    //To match the index in the array, the rank of the root is going to be 0,
    //and its children should be in 1 (x*2+1) and 2 (x*2+2) instead of x*2 and x*2+1
    //                                  left          right

    private class BTPos<E> implements Position<E>{

        private E element;
        private int parent;
        private int left;

        public void setElement(E element) {
            this.element = element;
        }

        public int getParent() {
            return parent;
        }

        public void setParent(int parent) {
            this.parent = parent;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public ArrayBinaryTree<E> getMyTree() {
            return myTree;
        }

        public void setMyTree(ArrayBinaryTree<E> myTree) {
            this.myTree = myTree;
        }

        private int right;
        private int index;
        private ArrayBinaryTree<E> myTree;

        @Override
        public E getElement() {
            return null;
        }
    }

    private ArrayList<BTPos<E>> tree;
    private int root;
    private int size;

    @Override
    public Position<E> left(Position<E> v) throws RuntimeException {
        BTPos<E> node = checkPosition(v);
        if(tree.get(node.getIndex()*2+1) != null){
            return (tree.get(node.getIndex()*2+1));
        }
        throw new RuntimeException("No left child");
    }

    @Override
    public Position<E> right(Position<E> v) throws RuntimeException {
        BTPos<E> node = checkPosition(v);
        if(tree.get(node.getIndex()*2+2) != null){
            return (tree.get(node.getIndex()*2+2));
        }
        throw new RuntimeException("No right child");
    }

    @Override
    public boolean hasLeft(Position<E> v) {
        BTPos<E> node = checkPosition(v);
        return tree.get(node.getIndex() * 2 + 1) != null;
    }

    @Override
    public boolean hasRight(Position<E> v) {
        BTPos<E> node = checkPosition(v);
        return tree.get(node.getIndex() * 2 + 2) != null;
    }

    @Override
    public E replace(Position<E> p, E e) {
        return null;
    }

    @Override
    public Position<E> sibling(Position<E> p) throws RuntimeException {
        BTPos<E> node = checkPosition(p);
        return null;
    }

    @Override
    public Position<E> insertLeft(Position<E> p, E e) throws RuntimeException {
        BTPos<E> node = checkPosition(p);
        return null;
    }

    @Override
    public Position<E> insertRight(Position<E> p, E e) throws RuntimeException {
        return null;
    }

    @Override
    public E remove(Position<E> p) throws RuntimeException {
        return null;
    }

    @Override
    public void swap(Position<E> p1, Position<E> p2) {

    }

    @Override
    public BinaryTree<E> subTree(Position<E> v) {
        return null;
    }

    @Override
    public void attachLeft(Position<E> p, BinaryTree<E> tree) throws RuntimeException {

    }

    @Override
    public void attachRight(Position<E> p, BinaryTree<E> tree) throws RuntimeException {

    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public Position<E> root() throws RuntimeException {
        if (this.isEmpty()){
            throw new RuntimeException("The tree is empty");
        }
        return tree.get(0);
    }

    @Override
    public Position<E> parent(Position<E> v) throws RuntimeException {
        return null;
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        return null;
    }

    @Override
    public boolean isInternal(Position<E> v) {
        return false;
    }

    @Override
    public boolean isLeaf(Position<E> v) throws RuntimeException {
        return false;
    }

    @Override
    public boolean isRoot(Position<E> v) {
        return false;
    }

    @Override
    public Position<E> addRoot(E e) throws RuntimeException {
        return null;
    }

    @Override
    public Iterator<Position<E>> iterator() {
        return null;
    }

    /**
     * If v is a good binary tree node, cast to BTPosition, else throw exception
     */
    private BTPos<E> checkPosition(Position<E> p) {
        if (!(p instanceof BTPos)) {
            throw new RuntimeException("The position is invalid");
        }
        return (BTPos<E>) p;
    }
    
}
