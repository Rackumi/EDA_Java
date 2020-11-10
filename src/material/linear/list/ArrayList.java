package material.linear.list;

import material.Position;

public class ArrayList<E> implements List<E> {
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Position<E> first() {
        return null;
    }

    @Override
    public Position<E> last() {
        return null;
    }

    @Override
    public Position<E> next(Position<E> p) throws RuntimeException {
        return null;
    }

    @Override
    public Position<E> prev(Position<E> p) throws RuntimeException {
        return null;
    }

    @Override
    public Position<E> addFirst(E e) {
        return null;
    }

    @Override
    public Position<E> addLast(E e) {
        return null;
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws RuntimeException {
        return null;
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws RuntimeException {
        return null;
    }

    @Override
    public E remove(Position<E> p) throws RuntimeException {
        return null;
    }

    @Override
    public E set(Position<E> p, E e) throws RuntimeException {
        return null;
    }
}
