package bignumber;

/**
 * This interface represents all operations for a node in a list of digits
 * implemented as an ADT.
 */
public interface BigNumberADTNode {

  /**
   * Return the number of digits in this list.
   * @return the length of this list
   */
  int length();

  /**
   * Helper method for length.
   * @param i is length counted so far
   * @return length
   */

  int lengthHelp(int i);

  /**
   * Shift the number to left by given number of shifts.
   * @param shift the number of shifts to be performed
   * @return the head of the resulting list
   */
  BigNumberADTNode shiftLeft(int shift);

  /**
   * Shift the number to right by given number of shifts.
   * @param shift the number of shifts to be performed
   * @return the head of the resulting list
   */
  BigNumberADTNode shiftRight(int shift);

  /**
   * A method that adds the given digit to the digit at head position.
   * @param num the number to be added
   * @return the head of the resulting list
   * @throws IllegalArgumentException if an invalid number is passed
   */
  BigNumberADTNode addDigit(int num) throws IllegalArgumentException;

  /**
   * Get the digit at the specified index, with 0 meaning the first digit in
   * this list.
   * @param index the specified index
   * @return the digit at the specified index
   * @throws IllegalArgumentException if an invalid index is passed
   */
  int getDigitAt(int index) throws IllegalArgumentException;


  /**
   * A method that adds two BigNumbers and returns the sum.
   * @param addBig the BigNumber to be added
   * @return the sum of two BigNumbers as a BigNumber
   */
  //BigNumberADTNode addHelper(BigNumberADTNode addBig);


  /**
   * Get the rest of the list of digits.
   * @return the rest of the list
   */
  BigNumberADTNode getRest();

  /**
   * Get the digit at the first node of the list.
   * @return the rest of the list
   */
  int getBnum();

}
