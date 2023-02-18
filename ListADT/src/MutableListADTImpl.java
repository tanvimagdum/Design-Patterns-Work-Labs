package listadt;

import java.util.function.Function;

/**
 * This is an implementation for a Mutable list.
 */
public class MutableListADTImpl<T> implements MutableListADT<T> {

  private ListADT<T> head;

  public MutableListADTImpl(ListADT<T> head) {
    this.head = head;
  }

  @Override
  public void addFront(T b) {
    head.addFront(b);
  }

  @Override
  public void addBack(T b) {
    head.addBack(b);
  }

  @Override
  public void add(int index, T b) {
    head.add(index, b);
  }

  @Override
  public void remove(T b) {
    head.remove(b);
  }

  @Override
  public <R> MutableListADTImpl<R> map(Function<T, R> converter) {
    return new MutableListADTImpl<>(head.map(converter));
  }

  @Override
  public int getSize() {
    return head.getSize();
  }

  @Override
  public T get(int index) throws IllegalArgumentException {
    return head.get(index);
  }

  @Override
  public ImmutableListADT<T> getImmutableList() {
    return ImmutableListADTImpl.BuilderClass.build(head);
  }
}
