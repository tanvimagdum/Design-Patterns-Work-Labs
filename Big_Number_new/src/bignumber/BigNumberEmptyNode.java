package bignumber;

/**
 * This class represents an empty node in the list adt implementation.
 */

public class BigNumberEmptyNode implements BigNumberADTNode {

  @Override
  public int length() {
    return 0;
  }

  @Override
  public BigNumberADTNode shiftLeft(int shift) {
    return this;
  }

  @Override
  public BigNumberADTNode shiftRight(int shift) {
    return this;
  }

  @Override
  public BigNumberADTNode addDigit(int num) throws IllegalArgumentException {
    if (num != 0) {
      throw new IllegalArgumentException("Enter valid digit");
    }
    return new BigNumberNonEmptyNode(num,this);
  }

  @Override
  public int getDigitAt(int index) throws IllegalArgumentException {
    throw new IllegalArgumentException("Wrong index");
  }


  @Override
  public BigNumber add(BigNumber addBig) {
    return addBig;
  }


  @Override
  public String toString() {
    return "0";
  }

  @Override
  public BigNumberADTNode getRest() {
    return this.getRest();
  }

  @Override
  public int getBnum() {
    return 0;
  }


}
