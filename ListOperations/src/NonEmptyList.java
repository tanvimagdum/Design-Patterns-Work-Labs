
/**
 * This represents a non-empty node of the list. It contains a piece of data
 * along with the rest of the list.
 */
public class NonEmptyList implements ListOfString {
  private String str;
  private ListOfString rest;

  public NonEmptyList(String s, ListOfString rest) {
    this.str = s;
    this.rest = rest;
  }

  @Override
  public int size() {
    return 1 + this.rest.size();
  }

  @Override
  public ListOfString addFront(String s) {
    return new NonEmptyList(s, this);
  }

  @Override
  public ListOfString addBack(String s) {
    this.rest = this.rest.addBack(s);
    return this;
  }

  @Override
  public ListOfString add(int index, String s) {
    if (index == 0) {
      return addFront(s);
    } else {
      return new NonEmptyList(this.str, this.rest.add(index - 1, s));
    }
  }

  @Override
  public String get(int index) throws IllegalArgumentException {
    if (index == 0) {
      return this.str;
    }
    return this.rest.get(index - 1);
  }


  @Override
  public ListOfString reverse() {
    ListOfString rev = new EmptyList();

    for (int i = this.size() - 2; i >= 0 ; i--) {
      rev = rev.addBack(this.rest.get(i));
    }
    rev = rev.addBack(this.str);

    return rev;
  }



  @Override
  public ListOfString interleave(ListOfString other) {

    ListOfString temp = new EmptyList();
    if (other.size() == 0) {
      return this;
    }

    int i = 0;
    int j = 0;
    int n = 0;
    int m = 0;

    while (n < (this.size() + other.size())) {
      if ((j + m) < this.size()) {
        temp = temp.add(i + n, this.get(j + m));
        n++;
      }
      if ((j + m) < other.size()) {
        temp = temp.add(i + n, other.get(j + m));
        n++;
      }
      m++;
    }
    return temp;
  }

  @Override
  public String toString() {
    String str = "";
    int n = this.size();
    for (int i = 0; i < n; i++) {
      str = str + this.get(i);
      if (i == n - 1) {
        break;
      }
      str = str + ",";
    }

    return str;
  }

  public static void main(String args[]) {

    ListOfString sentence = new EmptyList();
    ListOfString sen1 = new EmptyList();
    sentence = sentence.addFront("Boston");
    sentence = sentence.addBack("is");
    //sentence = sentence.addBack("USA");
    sentence = sentence.addBack("the");
    sentence = sentence.addBack("capital");
    sentence = sentence.addBack("of");
    sentence = sentence.addBack("MA");

    sentence = sentence.reverse();

    for (int i = 0; i < sentence.size(); i++) {
      System.out.println(sentence.get(i));
    }


  }
}
