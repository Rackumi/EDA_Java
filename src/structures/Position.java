package structures;

/**
 * Interface for position, which is a holder object storing a single element(XNode).
 *
 * @author Rackumi
 * @param <E> the type of the element stored in the position
 */
public interface Position<E>{

    /**
     * Gets the element stored at this position.
     *
     * @return the element stored in the given position
     */
    E getElement();

}
