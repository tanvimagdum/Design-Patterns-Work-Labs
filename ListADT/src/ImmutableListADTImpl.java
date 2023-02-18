package listadt;

import java.util.function.Function;

/**
 * This is an implementation for an Immutable list.
 */

public class ImmutableListADTImpl<T> implements ImmutableListADT<T> {
  private final ListADT<T> delegate;

  /**
   * Construct an ImmutableListADT object.
   */
  public ImmutableListADTImpl() {
    delegate = new ListADTImpl<>();
  }

  @Override
  public <R> CommonListADT<R> map(Function<T, R> converter) {
    return ImmutableListADTImpl.BuilderClass.build(delegate.map(converter));
    //return new ImmutableListADTImpl<>(delegate.map(converter));
  }

  @Override
  public int getSize() {
    return delegate.getSize();
  }

  @Override
  public T get(int index) throws IllegalArgumentException {
    return delegate.get(index);
  }

  @Override
  public MutableListADT<T> getMutableList() {
    return new MutableListADTImpl<>(delegate);
  }

  private void addBack(T b) {
    delegate.addBack(b);
  }

  /**
   * A builder class to build final Immutable list.
   * @param <T> the type of elements in this list
   */

  public static class BuilderClass<T> {

    /**
     * Build method to build the final immutable list.
     * @param delegate ListADT used to build immutable list
     * @return a final immutable list
     */
    public static ImmutableListADT build(ListADT delegate) {
      ImmutableListADTImpl imm = new ImmutableListADTImpl<>();
      imm.addBack(delegate);
      return imm;
    }

  }

  public BuilderClass<T> getBuilder() {
    return new BuilderClass<T>();
  }
}
