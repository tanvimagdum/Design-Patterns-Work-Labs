package solution.listadt;

import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Function;

/**
 * This is the implementation of a generic list. Specifically it implements
 * the listadt.ListADT interface.
 */
public class ListADTImpl<T> implements ListADT<T> {


  /**
   * Helper class for ListADTImpl.
   * @param <S> command to be given in string format
   * @param <T> the node following the command
   */

  public class Pair<S,T> {

    private String s;
    private GenericListADTNode<T> t;

    /**
     * Construct an object of Pair type that takes
     * string and a list of objects of type T.
     * @param s string or a command to be given
     * @param t the node following the command
     */

    private Pair(String s, GenericListADTNode<T> t) {
      this.s = s;
      this.t = t;
    }
  }

  /**
   * Helper class for ListADTImpl for mapping.
   * @param <S> command to be given in string format
   * @param <T> the node following the command
   */

  public class MapHelp<S,T> {

    private String s;
    private T t;

    /**
     * Construct an object of Pair type that takes
     * string and a list of objects of type T.
     * @param s string or a command to be given
     * @param t the node following the command
     */

    private MapHelp(String s, T t) {
      this.s = s;
      this.t = t;
    }
  }

  private GenericListADTNode<T> head;

  public ListADTImpl() {
    head = new GenericEmptyNode();
  }

  //a private constructor that is used internally (see map)
  private ListADTImpl(GenericListADTNode<T> head) {
    this.head = head;
  }

  @Override
  public void addFront(T b) {
    head = head.addFront(b);
  }

  @Override
  public void addBack(T b) {
    head = head.addBack(b);
  }

  @Override
  public void add(int index, T b) {
    head = head.add(index,b);
  }

  @Override
  public int getSize() {
    /*
    int acc = 0;
    GenericListADTNode<T> current = head;

    while (current instanceof GenericElementNode) {
      acc += 1;
      current = ((GenericElementNode<T>)current).getRest();
    }
    return acc;
     */

    int acc = 0;
    Deque<Pair> ts = new LinkedList<>();
    Deque<Integer> rs = new LinkedList<>();

    ts.push(new Pair<>("recur", head));
    while (!ts.isEmpty()) {
      Pair pNew = ts.pop();

      if (pNew.s.equals("recur")) {

        if (pNew.t instanceof GenericEmptyNode) {
          ts.push(new Pair<>("process", pNew.t));
        }

        if (pNew.t instanceof GenericElementNode) {
          ts.push(new Pair<>("process", pNew.t));
          ts.push(new Pair<>("recur", ((GenericElementNode<T>) pNew.t).getRest()));
        }

      }

      if (pNew.s.equals("process")) {

        if (pNew.t instanceof GenericEmptyNode) {
          rs.push(0);
        }

        if (pNew.t instanceof GenericElementNode) {
          acc = rs.pop();
          rs.push( 1 + acc);
        }

      }
    }

    return rs.pop();

  }

  @Override
  public void remove(T b) {
    head = head.remove(b);
  }

  @Override
  public T get(int index) throws IllegalArgumentException {
    if ((index >= 0) && (index < getSize())) {
      return head.get(index);
    }
    else {
      throw new IllegalArgumentException("Invalid index");
    }

  }

  @Override
  public <R> ListADT<R> map(Function<T,R> converter) {

    /*
    T acc;
    Deque<Pair> ts = new LinkedList<>();
    Deque<T> rs = new LinkedList<>();
    ListADT result = new ListADTImpl();

    ts.push(new Pair<>("recur", head));
    while (!ts.isEmpty()) {
      Pair pNew = ts.pop();

      if (pNew.s.equals("recur")) {

        if (pNew.t instanceof GenericEmptyNode) {
          ts.push(new Pair<>("process", pNew.t));
        }

        if (pNew.t instanceof GenericElementNode) {
          ts.push(new Pair<>("process", pNew.t));
          ts.push(new Pair<>("recur", ((GenericElementNode<T>) pNew.t).getRest()));
        }

      }

      if (pNew.s.equals("process")) {

        if (pNew.t instanceof GenericEmptyNode) {
          rs.push((T) new GenericEmptyNode());
        }

        if (pNew.t instanceof GenericElementNode) {
          acc= (T) converter.apply(((GenericElementNode<T>) pNew.t).getObject());
          rs.push(acc);
          result.addBack(rs.pop());
        }

      }
    }

    return result;
    */

    T acc;
    ListADT listMap = new ListADTImpl();
    GenericListADTNode<T> current = head;

    while (current instanceof GenericElementNode) {
      acc = (T) converter.apply(((GenericElementNode<T>) current).getObject());
      current = ((GenericElementNode<T>)current).getRest();
      listMap.addBack(acc);
    }
    return listMap;


    //return new ListADTImpl(head.map(converter));
  }

  @Override
  public String toString() {
    return "(" + head.toString() + ")";
  }
}

