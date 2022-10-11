package calculator;

/**
 * This represents an empty node in the Calculator list.
 */
public class EmptyCalculator implements Calculator {

  @Override
  public Calculator input(char ch) {
    return null;
  }

  @Override
  public String getResult() {
    return null;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public Calculator addFront(char ch) {
    return new NonEmptyCalculator(ch, this);
  }

  @Override
  public Calculator addBack(char ch) {
    return addFront(ch);
  }

  @Override
  public char get(int index) {
    return '\0';
  }

  @Override
  public void delCalcData() {
    return ;
  }


}
