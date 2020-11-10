package material;

/**
 * Interface for position, which is a holder object storing a single
 * element(XNode).
 *
 * @param <E> the type of the element stored in the position
 * @author Rackumi
 */
public interface Position<E> {

    /**
     * Checks the element stored at this position.
     *
     * @return the element stored in the given position
     */
    E getElement();


}
