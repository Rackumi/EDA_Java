package structures.tree.iterators;

import structures.Position;
import structures.tree.Tree;

import java.util.Iterator;
import java.util.function.Predicate;

/**
 * Generic preorder iterator for trees.
 *
 * @param <E>
 * @author
 */
public class PostorderIterator<E> implements Iterator<Position<E>> {

    //TODO: Implementar (alumnos)

    public PostorderIterator(Tree<E> tree) {
        throw new RuntimeException("Not yet implemented");
    }

    public PostorderIterator(Tree<E> tree, Position<E> start) {
        throw new RuntimeException("Not yet implemented");
    }

    public PostorderIterator(Tree<E> tree, Position<E> start, Predicate<Position<E>> predicate) {
        throw new RuntimeException("Not yet implemented");
    }


    @Override
    public boolean hasNext() {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public Position<E> next() {
        throw new RuntimeException("Not yet implemented");
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not implemented.");
    }

}