package bignumber;

/**
 * This class implements the list of digits ADT.
 */
public class BigNumberImpl implements BigNumber {

  private BigNumberADTNode head;
  private BigNumberADTNode tail;

  /**
   * Construct a BigNumberImpl object that takes no arguments
   * and initializes head to digit 0.
   */
  public BigNumberImpl() {
    this.head = new BigNumberEmptyNode();
    this.head = this.head.addDigit(0);
    this.tail = this.head;
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
    this.tail = this.head;
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
    if ((index >= 0) && (index < length())) {
      return this.head.getDigitAt(index);
    }
    else if (index >= length()) {
      return 0;
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

    if (this.length() > b.length()) {
      return 1;
    }
    else if (this.length() < b.length()) {
      return -1;
    }
    else {
      for (i = b.length() - 1 ; i >= 0 ; i--) {
        if (this.getDigitAt(i) > b.getDigitAt(i)) {
          return 1;
        }
        if (this.getDigitAt(i) < b.getDigitAt(i)) {
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
  public String toString() {
    return head.toString();
  }


  public static void main(String args[]) {
    String str = "00012300400";
    BigNumber b = new BigNumberImpl();
    b = b.addDigit(3);
    b = b.shiftLeft(2);
    b = b.addDigit(1);
    b = b.shiftRight(3);
    System.out.println(b.toString());

  }


}


