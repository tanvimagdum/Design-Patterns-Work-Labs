package calculator;

/**
 * This interface represents all the operations
 * for a Calculator.
 */
public interface Calculator {

  /**
   * Take the input char for a Calculator,
   * process this input and return as the
   * resulting Calculator.
   *
   * @param ch the char to be added
   * @return the resulting Calculator
   */
  public Calculator input(char ch);

  /**
   * Return the real time output of Calculator.
   * @return the result of Calculator in a string
   */
  public String getResult();

  /**
   * Return the number of chars in this list.
   * @return the size of this list
   */
  public int size();

  /**
   * Add the given char to the front of this list and return the resulting list.
   *
   * @param ch the char to be added
   * @return the resulting list
   */
  public Calculator addFront(char ch);

  /**
   * Add the given char to the back of this list and return the resulting list.
   *
   * @param ch the char to be added
   * @return the resulting list
   */
  public Calculator addBack(char ch);

  /**
   * Get the char at the specified index, with 0 meaning the first char in
   * this list.
   *
   * @param index the specified index
   * @return the char at the specified index
   */
  public char get(int index);

  /**
   * Delete all the data from Calculator list.
   */
  public void delCalcData();

}
