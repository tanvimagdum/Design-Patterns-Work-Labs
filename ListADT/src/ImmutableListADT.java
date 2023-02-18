package listadt;

/**
 * This interface represents an immutable list.
 * @param <T> the type of elements in this list
 */

public interface ImmutableListADT<T> extends CommonListADT<T> {

  /**
   * Get the mutable list.
   * @return a mutable list
   */
  public MutableListADT<T> getMutableList();
}
