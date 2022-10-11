
/**
 * This represents an empty node in the list.
 */
public class EmptyList implements ListOfString {


  @Override
  public int size() {
    return 0;
  }

  @Override
  public ListOfString addFront(String s) {
    return new NonEmptyList(s, this);
  }

  @Override
  public ListOfString addBack(String s) {
    return addFront(s);
  }

  @Override
  public ListOfString add(int index, String s) throws
          IllegalArgumentException {
    if (index == 0) {
      return addFront(s);
    }
    throw new IllegalArgumentException("Invalid index to add an element");
  }

  @Override
  public String get(int index) throws IllegalArgumentException {
    throw new IllegalArgumentException("Wrong index");
  }

  @Override
  public ListOfString reverse() {
    return null;
  }

  @Override
  public ListOfString interleave(ListOfString other) {
    if (other.size() == 0) {
      return null;
    }
    return other;
  }

  @Override
  public String toString() {
    return null;
  }


}
