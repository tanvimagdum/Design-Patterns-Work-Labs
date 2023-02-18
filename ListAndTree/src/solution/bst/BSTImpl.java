package solution.bst;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a binary search tree. It implements the BSTADT
 * interface.
 */
public class BSTImpl<T extends Comparable<T>>
        implements BST<T> {

  Deque<Pair> ts = new LinkedList<>();
  Deque<Integer> rs = new LinkedList<>();

  /**
   * Helper class for ListADTImpl.
   * @param <S> command to be given in string format
   * @param <T> the node following the command
   */

  public class Pair<S,T extends Comparable<T>> {

    private String s;
    private BSTNode<T> t;

    /**
     * Construct an object of Pair type that takes
     * string and a list of objects of type T.
     * @param s string or a command to be given
     * @param t the node following the command
     */

    private Pair(String s, BSTNode<T> t) {
      this.s = s;
      this.t = t;
    }
  }

  private BSTNode<T> root;

  public BSTImpl() {
    root = new BSTEmptyNode<T>(); //no tree
  }

  @Override
  public int size() {
    //return root.count();

    int acc1 = 0;
    int acc2 = 0;

    ts.push(new Pair("recur",root));

    while (!ts.isEmpty()) {
      Pair pNew = ts.pop();

      if (pNew.s.equals("recur")) {

        if (pNew.t instanceof BSTEmptyNode) {
          ts.push(new Pair("process", pNew.t));
        }

        if (pNew.t instanceof BSTElementNode) {
          ts.push(new Pair<>("process", pNew.t));
          ts.push(new Pair<>("recur", ((BSTElementNode<T>) pNew.t).getRight()));
          ts.push(new Pair("recur", ((BSTElementNode<T>) pNew.t).getLeft()));
        }

      }

      if (pNew.s.equals("process")) {

        if (pNew.t instanceof BSTEmptyNode) {
          rs.push(0);
        }

        if (pNew.t instanceof BSTElementNode) {
          acc1 = rs.pop();
          acc2 = rs.pop();
          rs.push(1 + acc1 + acc2);
        }

      }
    }

    return rs.pop();

  }

  @Override
  public void insert(T data) {
    root = root.insert(data);
  }

  @Override
  public boolean present(T data) {
    return root.contains(data);
  }

  @Override
  public T minimum() {
    return root.minimum();
  }

  @Override
  public T maximum() {
    return root.maximum();
  }

  public String toString() {
    return "[" + root.toString() + "]";
  }

  @Override
  public List<T> preorder() {
    List<T> result = new ArrayList<T>();
    BSTNode current = root;
    Deque<BSTNode> ts = new LinkedList<>();


    while (current instanceof BSTElementNode || !ts.isEmpty()) {
      while (current instanceof BSTElementNode) {
        result.add((T) ((BSTElementNode<T>) current).getData());
        if (((BSTElementNode<T>) current).getRight() instanceof BSTElementNode) {
          ts.push(((BSTElementNode<T>) current).getRight());
        }
        current = ((BSTElementNode<T>) current).getLeft();
      }
      if (!ts.isEmpty()) {
        current = ts.pop();
      }
    }

    return result;
  }

  @Override
  public List<T> inorder() {

    List<T> result = new ArrayList<T>();
    BSTNode current = root;
    Deque<BSTNode> ts = new LinkedList<>();


    while (current instanceof BSTElementNode || !ts.isEmpty()) {

      while (current instanceof BSTElementNode) {
        ts.push(current);
        current = ((BSTElementNode<?>) current).getLeft();
      }
      current = ts.pop();
      result.add((T) ((BSTElementNode<T>) current).getData());
      current = ((BSTElementNode<T>) current).getRight();

    }

    return result;

    //root.inorder(result);
  }

  @Override
  public List<T> postorder() {

    List<T> result = new ArrayList<T>();
    BSTNode current;
    Deque<BSTNode> ts = new LinkedList<>();

    while (root instanceof BSTElementNode || !ts.isEmpty()) {
      while (root instanceof BSTElementNode) {
        ts.push(root);
        ts.push(root);
        root = ((BSTElementNode<T>) root).getLeft();
      }

      root = ts.pop();
      if (!ts.isEmpty() && ts.peek() == root) {
        root = root.getRight();
      }
      else {
        result.add((T) ((BSTElementNode<T>) root).getData());
        root = new BSTEmptyNode<>();
      }

    }

    return result;

    //root.postorder(result);

  }
}
