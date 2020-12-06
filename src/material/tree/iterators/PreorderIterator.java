package material.tree.iterators;

import material.Position;
import material.tree.Tree;
import java.util.*;
import java.util.function.Predicate;


public class PreorderIterator<E> implements Iterator<Position<E>> {

    private final Tree<E> tree;
    private final Deque<Position<E>> nodeStack;
    private final Predicate<Position<E>> predicate;
    private final boolean hasPredicate;
    private boolean oneLeft = false;

    public PreorderIterator(Tree<E> tree) {
        nodeStack= new LinkedList<>();
        this.tree = tree;
        if(!tree.isEmpty())
            nodeStack.push(tree.root());
        predicate = null;
        hasPredicate = false;
    }

    public PreorderIterator(Tree<E> tree, Position<E> start) {
        nodeStack= new LinkedList<>();
        this.tree = tree;
        nodeStack.push(start);
        predicate = null;
        hasPredicate = false;
    }

    public PreorderIterator(Tree<E> tree, Position<E> start, Predicate<Position<E>> predicate) {
        nodeStack= new LinkedList<>();
        this.tree = tree;
        nodeStack.push(start);
        this.predicate = predicate;
        hasPredicate = true;
    }

    @Override
    public boolean hasNext() {
        if(nodeStack.isEmpty())
            return false;
        if(hasPredicate&&!oneLeft){
            for(Position<E> p : nodeStack){         //This verification tests if there is at least another element left
                if (predicate.test(p)) {            //that verifies the predicate test, and avoids NoSuchElementException
                    oneLeft=true;                   //when the last element doesn't verify the test. With the oneLeft
                    return true;                    //variable, we avoid sacnning the list multiple times, as that would
                }                                   //left us with an iterator close to O(n^2)
            }
            nodeStack.clear();
            return false;
        }
        return true;
    }

    @Override
    public Position<E> next() {
        if(nodeStack.isEmpty())
            throw new NoSuchElementException();

        Position<E> node = nodeStack.pop();
        List<Position<E>> reverseList = new LinkedList<>();
        for(Position<E> p:tree.children(node))
            reverseList.add(p);
        Collections.reverse(reverseList);
        for(Position<E> p:reverseList)
            nodeStack.push(p);
        if(hasPredicate)
            if(predicate.test(node)){
                oneLeft=false;
                return node;
            }
            else
                return this.next();
        else
            return node;
    }

}