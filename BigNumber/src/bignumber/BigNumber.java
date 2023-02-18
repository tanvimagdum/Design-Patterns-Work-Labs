package bignumber;

/**
 * This interface represents the List of digits ADT.
 */
public interface BigNumber {

  /**
   * Return the number of digits in this list.
   * @return the length of this list
   */
  public int length();

  /**
   * Shift the number to left by given number of shifts.
   * @param shiftNum the number of shifts to be performed
   * @return the head of the resulting list
   */
  public BigNumber shiftLeft(int shiftNum);

  /**
   * Shift the number to right by given number of shifts.
   * @param shiftNum the number of shifts to be performed
   * @return the head of the resulting list
   */
  public BigNumber shiftRight(int shiftNum);

  /**
   * A method that adds the given digit to the digit at head position.
   * @param addNum the number to be added
   * @return the head of the resulting list
   * @throws IllegalArgumentException if an invalid number is passed
   */
  public BigNumber addDigit(int addNum) throws IllegalArgumentException;

  /**
   * Get the digit at the specified index, with 0 meaning the first digit in
   * this list.
   * @param index the specified index
   * @return the digit at the specified index
   * @throws IllegalArgumentException if an invalid index is passed
   */
  public int getDigitAt(int index) throws IllegalArgumentException;

  /**
   * Copy the list of digits to another list of similar type.
   * @return the identical copy of list as BigNumber
   */
  public BigNumber copy();

  /**
   * A method that adds two BigNumbers and returns the sum.
   * @param addBig the BigNumber to be added
   * @return the sum of two BigNumbers as a BigNumber
   */
  public BigNumber add(BigNumber addBig);

  /**
   * A method that compares two BigNumbers.
   * @param b the BigNumber to be compared
   * @return 0 if the two strings are equal lexicographically
   */
  public int compareTo(BigNumber b);

  public boolean equals(BigNumber b);
}
