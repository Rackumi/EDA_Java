package material.tree.binarytree;

import material.Position;
import material.tree.binarytree.BinaryTree;
import material.tree.iterators.InorderBinaryTreeIterator;

import java.util.Iterator;

public class BinaryTreeUtils<E> {

    private BinaryTree<E> tree;

    public BinaryTreeUtils(BinaryTree<E> tree) {
        this.tree = tree;
    }

    /**
     * Given a tree the method returns a new tree where all left children
     * become right children and vice versa
     */
    public BinaryTree<E> mirror() {
        BinaryTreeUtils<E> t = new BinaryTreeUtils<>(tree);
        Position<E> r = tree.root();
        if(tree.isLeaf(r)){
        }
        else{
            t = (BinaryTreeUtils<E>) tree.subTree(tree.root());
            t.mirror();
            tree.swap(tree.left(tree.root()), tree.right(tree.root()));
        }
        return tree;
    }
    /**
     * Determines whether the element e is in the tree or not
     */
    public boolean contains (E e) {
        Iterator<Position<E>> it = tree.iterator();
        while(it.hasNext()){
            Position<E> a = it.next();
            return(a.equals(e));
        }
        return false;
    }
    /**
     * Determines the level of a node in the tree (root is located at level 1)
     */
    public int level(Position<E> p) {
        if(tree.root() == p){
            return 1;
        }
        Iterator<Position<E>> it = tree.iterator();
        while(it.hasNext()){
            Position<E> a = it.next();

        }
        return 0;
    }

}