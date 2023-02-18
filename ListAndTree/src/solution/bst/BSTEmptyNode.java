package solution.bst;

import java.util.List;

/**
 * This node represents an empty node in the binary search tree (i.e. the
 * leaves).
 */
public class BSTEmptyNode<T extends Comparable<T>> implements BSTNode<T> {
  @Override
  public int count() {
    return 0;
  }

  @Override
  public BSTNode<T> insert(T data) {
    return new BSTElementNode(data, new BSTEmptyNode(), new BSTEmptyNode());
  }

  @Override
  public T minimum() {
    return null;
  }

  @Override
  public T maximum() {
    return null;
  }

  @Override
  public boolean contains(T data) {
    return false;
  }

  @Override
  public String toString() {
    return "";
  }

  @Override
  public void preorder(List<T> result) {
    //Cannot preorder an empty list.
    return;
  }

  @Override
  public void inorder(List<T> result) {
    //Cannot inorder an empty list.
  }

  @Override
  public void postorder(List<T> result) {
    //Cannot postorder an empty list.
  }

  public BSTNode<T> getRight() {
    return new BSTEmptyNode<>();
  }

  public BSTNode<T> getLeft() {
    return new BSTEmptyNode<>();
  }

}
