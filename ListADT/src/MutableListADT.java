package listadt;

/**
 * This interface represents a mutable list.
 * @param <T> the type of elements in this list
 */
public interface MutableListADT<T> extends ListADT<T> {

  /**
   * Get the immutable list.
   * @return an immutable list
   */
  public ImmutableListADT<T> getImmutableList();
}
