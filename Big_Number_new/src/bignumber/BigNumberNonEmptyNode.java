package bignumber;

/**
 * This class represents an element node in the list adt implementation.
 */
public class BigNumberNonEmptyNode implements BigNumberADTNode {

  private int bnum;
  private BigNumberADTNode rest;
  private int last;
  private static boolean flag = false;

  /**
   * Construct a BigNumberNonEmpty object that takes
   * a single digit number and the rest of the list
   * as arguments.
   * @param number the number at head position
   * @param rest the next item of the list
   */
  public BigNumberNonEmptyNode(int number, BigNumberADTNode rest) {
    this.bnum = number;
    this.rest = rest;
    this.last = this.bnum;
    this.flag = false;
  }

  @Override
  public int length() {
    return 1 + this.rest.length();
  }

  @Override
  public BigNumberADTNode shiftLeft(int shift) {
    BigNumberADTNode b = this;
    if (b.getBnum() == 0 && !flag) {
      return b;
    }
    if (shift < 0) {
      b = b.shiftRight(Math.abs(shift));
    }
    else {
      for (int i = 0; i < shift; i++) {
        b = new BigNumberNonEmptyNode(0, b);
        flag = true;
      }
    }
    return b;
  }

  @Override
  public BigNumberADTNode shiftRight(int shift) {
    BigNumberADTNode b = this;
    if (b.getBnum() == 0 && !flag) {
      return b;
    }
    if (shift < 0) {
      b = b.shiftLeft(Math.abs(shift));
    }
    else {
      for (int i = 0; i < shift; i++) {
        b = b.getRest();
      }
    }
    if (b.toString() == null) {
      b = b.addDigit(0);
    }
    return b;
  }

  @Override
  public BigNumberADTNode addDigit(int num) throws IllegalArgumentException {
    if (num > 9 || num < 0) {
      throw new IllegalArgumentException("Enter valid digit");
    }
    int temp = this.bnum + num;
    if (temp > 9) {
      throw new IllegalArgumentException("Enter less value");
    }
    this.bnum = temp;
    return this;
  }

  @Override
  public int getDigitAt(int index) throws IllegalArgumentException {
    if (index == 0) {
      return this.bnum;
    }
    return this.rest.getDigitAt(index - 1);
  }



  @Override
  public BigNumber add(BigNumber addBig) {
    return null;
  }


  @Override
  public String toString() {
    String str = "";
    for (int i = this.length() - 1; i >= 0; i--) {
      str = str + this.getDigitAt(i);
    }
    return str;
  }

  @Override
  public int getBnum() {
    return this.bnum;
  }

  @Override
  public BigNumberADTNode getRest() {
    return this.rest;
  }

}
