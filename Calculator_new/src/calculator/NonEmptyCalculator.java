package calculator;

/**
 * This represents a non-empty node of the Calculator list.
 * It contains a piece of data along with the rest of the list.
 */
public class NonEmptyCalculator implements Calculator {
  protected char ch;
  protected Calculator rest;

  public NonEmptyCalculator(char ch, Calculator rest) {
    this.ch = ch;
    this.rest = rest;
  }

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
    return 1 + this.rest.size();
  }

  @Override
  public Calculator addFront(char ch) {
    return new NonEmptyCalculator(ch, this);
  }

  @Override
  public Calculator addBack(char ch) {
    this.rest = this.rest.addBack(ch);
    return this;
  }

  @Override
  public char get(int index) {
    if (index == 0) {
      return this.ch;
    }
    return this.rest.get(index - 1);
  }

  @Override
  public void delCalcData() {
    this.ch = '\0';
    this.rest = null;
  }

}
