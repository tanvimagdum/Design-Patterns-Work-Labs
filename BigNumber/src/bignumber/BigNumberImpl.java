package bignumber;

/**
 * This class implements the list of digits ADT.
 */
public class BigNumberImpl implements BigNumber {

  private BigNumberADTNode head;

  /**
   * Construct a BigNumberImpl object that takes no arguments
   * and initializes head to digit 0.
   */
  public BigNumberImpl() {
    this.head = new BigNumberEmptyNode();
    this.head = this.head.addDigit(0);
  }

  /**
   * Construct another BigNumberImpl object that takes
   * a string as an argument and stores all the digits
   * from the string in a list.
   * It throws an IllegalArgumentException when a character
   * other than a digit is present in the string.
   */
  public BigNumberImpl(String s) throws IllegalArgumentException {
    if (!s.matches("[0-9]+")) {
      throw new IllegalArgumentException("Invalid number");
    }

    this.head = new BigNumberEmptyNode();
    this.head = this.head.addDigit(0);
    for (int i = 0 ; i < s.toCharArray().length ; i++) {
      this.head = this.head.shiftLeft(1);
      this.head = this.head.addDigit(Character.getNumericValue(s.charAt(i)));
    }
  }

  @Override
  public int length() {
    return this.head.length();
  }

  @Override
  public BigNumber shiftLeft(int shiftNum) {
    this.head = this.head.shiftLeft(shiftNum);
    return this;
  }

  @Override
  public BigNumber shiftRight(int shiftNum) {
    this.head = this.head.shiftRight(shiftNum);
    return this;
  }

  @Override
  public BigNumber addDigit(int addNum) throws IllegalArgumentException {
    this.head = this.head.addDigit(addNum);
    return this;
  }

  @Override
  public int getDigitAt(int index) throws IllegalArgumentException {
    if (index >= length()) {
      return 0;
    }
    else if (index >= 0) {
      return this.head.getDigitAt(index);
    }
    else {
      throw new IllegalArgumentException("Invalid index");
    }

  }

  @Override
  public BigNumber copy() {
    BigNumber bcopy = this;
    return bcopy;
  }

  @Override
  public BigNumber add(BigNumber addBig) {

    long b1 = Integer.parseInt(this.toString());
    long b2 = Integer.parseInt(addBig.toString());

    long temp = b1 + b2;
    String str = String.valueOf(temp);
    BigNumber addition = new BigNumberImpl(str);
    return addition;

  }

  @Override
  public int compareTo(BigNumber b) {
    int i;
    int currLen = this.length();
    int varLen = b.length();

    if (currLen > varLen) {
      return 1;
    }
    else if (currLen < varLen) {
      return -1;
    }
    else {
      for (i = varLen - 1 ; i >= 0 ; i--) {
        int currDigit = this.getDigitAt(i);
        int varDigit = b.getDigitAt(i);
        if (currDigit > varDigit) {
          return 1;
        }
        if (currDigit < varDigit) {
          return -1;
        }
      }

      if (i == -1) {
        return 0;
      }
    }
    return 0;
  }

  @Override
  public boolean equals(BigNumber b) {
    int i;
    int currLen = this.length();
    int varLen = b.length();

    if (currLen > varLen) {
      return false;
    }
    else if (currLen < varLen) {
      return false;
    }
    else {
      for (i = varLen - 1 ; i >= 0 ; i--) {
        int currDigit = this.getDigitAt(i);
        int varDigit = b.getDigitAt(i);
        if (currDigit > varDigit) {
          return false;
        }
        if (currDigit < varDigit) {
          return false;
        }
      }

      if (i == -1) {
        return true;
      }
    }

    return false;
  }

  @Override
  public String toString() {
    return head.toString();
  }


}


