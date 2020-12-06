package material.tree.narytree;

import material.Position;
import material.tree.iterators.BFSIterator;

import javax.swing.tree.TreeNode;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * A linked class for a tree where nodes have an arbitrary number of children.
 *
 * @param <E> the elements stored in the tree
 * @author Rackumi
 */
public class LCRSTree<E> implements NAryTree<E> {

    private class LCRSNode<E> implements Position<E> {

        private E element; // The element stored in the position
        private LCRSNode<E> parent;// The parent of the node
        private LCRSNode<E> leftChild; //the left child
        private LCRSNode<E> rightSibling; //the brothers of the left child
        private LCRSTree<E> myTree; // A reference to the tree where the node belongs

        public LCRSNode(E element, LCRSNode<E> parent, LCRSNode<E> leftChild, LCRSNode<E> rightSibling, LCRSTree<E> myTree) {
            this.element = element;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightSibling = rightSibling;
            this.myTree = myTree;
        }

        @Override
        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public LCRSNode<E> getParent() {
            return parent;
        }

        public void setParent(LCRSNode<E> parent) {
            this.parent = parent;
        }

        public LCRSNode<E> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(LCRSNode<E> leftChild) {
            this.leftChild = leftChild;
        }

        public LCRSNode<E> getRightSibling() {
            return rightSibling;
        }

        public void setRightSibling(LCRSNode<E> rightSibling) {
            this.rightSibling = rightSibling;
        }

        public LCRSTree<E> getMyTree() {
            return myTree;
        }

        public void setMyTree(LCRSTree<E> myTree) {
            this.myTree = myTree;
        }
    }

    private LCRSNode<E> root; // The root of the tree
    private int size; // The number of nodes in the tree

    public LCRSTree() {
        root = null;
        size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public Position<E> root() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root;
    }

    @Override
    public Position<E> parent(Position<E> v) throws RuntimeException {
        LCRSNode<E> node = checkPosition(v);
        if (isRoot(v)) {
            throw new RuntimeException("The node has not parent");
        }
        return node.getParent();
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> p) {
        LCRSNode<E> node = checkPosition(p);
        List<Position<E>> l = new LinkedList<>();
        if (node.getLeftChild() != null) {
            LCRSNode<E> aux = node.getLeftChild();
            while (aux != null) {
                l.add(aux);
                aux = aux.getRightSibling();
            }
        }
        return l;
    }

    @Override
    public boolean isInternal(Position<E> v) {
        return !isLeaf(v);
    }

    @Override
    public boolean isLeaf(Position<E> v) throws RuntimeException {
        LCRSNode<E> node = checkPosition(v);
        return (node.getLeftChild() == null);
    }

    @Override
    public boolean isRoot(Position<E> v) throws RuntimeException {
        LCRSNode<E> node = checkPosition(v);
        return (node == this.root);
    }

    @Override
    public Position<E> addRoot(E e) throws RuntimeException {
        if (!isEmpty()) {
            throw new IllegalStateException("Tree already has a root");
        }
        this.size++;
        this.root = new LCRSNode<>(e, null, null, null, this);
        return this.root;
    }

    @Override
    public Iterator<Position<E>> iterator() {
        return new BFSIterator<>(this);
    }

    @Override
    public E replace(Position<E> p, E e) {
        LCRSNode<E> node = checkPosition(p);
        E temp = p.getElement();
        node.setElement(e);
        return temp;
    }

    @Override
    public void swapElements(Position<E> p1, Position<E> p2) throws RuntimeException {
        LCRSNode<E> node1 = checkPosition(p1);
        LCRSNode<E> node2 = checkPosition(p2);

        E aux = node1.getElement();
        node1.setElement(node2.getElement());
        node2.setElement(aux);
    }

    @Override
    public Position<E> add(E element, Position<E> p) {
        LCRSNode<E> parent = checkPosition(p);
        LCRSNode<E> newNode = new LCRSNode<>(element, parent, null, null, this);
        if (parent.getLeftChild() == null) {
            parent.setLeftChild(newNode);
        } else {
            LCRSNode<E> pAux = parent.getLeftChild();
            while (pAux.getRightSibling() != null) {
                pAux = pAux.getRightSibling();
            }
            pAux.setRightSibling(newNode);
        }
        this.size++;
        return newNode;
    }

    @Override
    public void remove(Position<E> p) {
        LCRSNode<E> node = checkPosition(p);
        if(node.getParent()==null){
            this.root=null;
            this.size=0;
            for (Position<E> pos : this) {
                LCRSNode<E> next = checkPosition(pos);
                next.setMyTree(null);
            }
        }
        else{
            int cont = 0;
            Iterator<Position<E>> it = new BFSIterator<E>(this, node);
            while (it.hasNext()) {
                LCRSNode<E> next = checkPosition(it.next());
                next.setMyTree(null);
                cont++;
            }
            this.size -= cont;
            if(node.getRightSibling() != null){
                LCRSNode<E> aux = node.getParent();
                if(aux.getLeftChild() != node){
                    aux = aux.getLeftChild();
                    while(aux.getRightSibling() != node){
                        aux = aux.getRightSibling();
                    }
                    aux.setRightSibling(node.getRightSibling());
                }
            }
        }
        node.setMyTree(null);
    }

    @Override
    public void moveSubtree(Position<E> pOrig, Position<E> pDest) throws RuntimeException {
        if (pOrig.equals(pDest)){
            throw new RuntimeException("Both positions are the same");
        }

        LCRSNode<E> nodeO = checkPosition(pOrig);
        if (isRoot(nodeO)){
            throw new RuntimeException("Root node can't be moved");
        }

        LCRSNode<E> nodeD = checkPosition(pDest);
        Iterator<Position<E>> it = new BFSIterator<>(this, pOrig);
        while (it.hasNext()){
            Position<E> a = it.next();
            if(a==nodeD){
                throw new RuntimeException("Target position can't be a subtree of origin");
            }
        }

        LCRSNode<E> padreO = nodeO.getParent();
        LCRSNode<E> prev = null;
        if(padreO.getLeftChild() == nodeO){
            prev = padreO;
        }
        else{
            prev = padreO.getLeftChild();
            while(prev.getRightSibling() != nodeO){
                prev = prev.getRightSibling();
            }
        }
        if(nodeO.getRightSibling() != null){
            prev.setRightSibling(nodeO.getRightSibling());
        }
        else{
            prev.setRightSibling(null);
        }
        if(nodeD.getLeftChild() != null){
            LCRSNode<E> aux = nodeD.getLeftChild();
            while(aux.getRightSibling() != null){
                aux = aux.getRightSibling();
            }
            aux.setRightSibling(nodeO);
        }
        else{
            nodeD.setLeftChild(nodeO);
        }
        nodeO.setParent(nodeD);
    }

    /**
     * Validates the given position, casting it to TreeNode if valid
     *
     * @param p the position to be converted
     * @return the position casted to TreeNode
     * @throws IllegalStateException if the position is not valid
     */
    private LCRSNode<E> checkPosition(Position<E> p) throws RuntimeException  { //O(1)
        if (!(p instanceof LCRSNode)) { //tmb se encarga de ver si p es nulo o no
            throw new RuntimeException("The position is invalid");
        }
        LCRSNode<E> aux = (LCRSNode<E>) p;

        if (aux.getMyTree() != this ) {
            throw new RuntimeException("The node is not from this tree");
        }
        return aux;
    }

}