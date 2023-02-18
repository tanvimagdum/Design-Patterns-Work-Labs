import bignumber.BigNumber;
import bignumber.BigNumberImpl;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.math.BigInteger;
import java.util.Random;
import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class to test BigNumberImpl class.
 */

public class BigNumberImplTest {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testConstructor1() {
    BigNumber b = new BigNumberImpl();
    assertEquals(0, b.getDigitAt(0));
  }

  @Test
  public void testLength1() {
    BigNumber b = new BigNumberImpl();
    assertEquals(1, b.length());
  }

  @Test
  public void testLength2() {
    BigNumber b = new BigNumberImpl();
    b = b.addDigit(3);
    b = b.shiftLeft(4);
    assertEquals(5, b.length());
  }

  @Test
  public void testToString1() {
    BigNumber b = new BigNumberImpl();
    assertEquals("0", b.toString());
  }

  @Test
  public void testToString2() {
    BigNumber b = new BigNumberImpl("1234567890");
    assertEquals("1234567890", b.toString());
  }

  @Test
  public void testInvalidString1() throws IllegalArgumentException {
    String str = "123yt#5+";
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid number");
    BigNumber b = new BigNumberImpl(str);
  }

  @Test
  public void testInvalidString2() throws IllegalArgumentException {
    String str = "-12345";
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid number");
    BigNumber b = new BigNumberImpl(str);
  }

  @Test
  public void testInvalidString3() throws IllegalArgumentException {
    String str = "";
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid number");
    BigNumber b = new BigNumberImpl(str);
  }

  @Test
  public void testValidString() {
    String str = "32411";
    int i;
    int j;
    BigNumber b = new BigNumberImpl(str);
    for (i = (b.length() - 1) , j = 0 ;
         i >= 0 && (str.charAt(j) != '\0') ;
         i = (i - 1) , j = (j + 1)) {
      assertEquals(Character.getNumericValue(str.charAt(j)), b.getDigitAt(i));
    }
    assertEquals("32411", b.toString());
  }

  @Test
  public void testFuzzyValidString() {
    Random r = new Random();
    int s = r.nextInt();
    String str = String.valueOf(Math.abs(s));
    int i;
    int j;
    BigNumber b = new BigNumberImpl(str);
    for (i = (b.length() - 1) , j = 0 ;
         i >= 0 && (str.charAt(j) != '\0') ;
         i = (i - 1) , j = (j + 1)) {
      assertEquals(Character.getNumericValue(str.charAt(j)), b.getDigitAt(i));
    }
  }

  @Test
  public void testValidStringZeros() {
    BigNumber b = new BigNumberImpl("0000");
    assertEquals("0", b.toString());
  }

  @Test
  public void testValidStringZeroAppended() {
    BigNumber b = new BigNumberImpl("012345");
    assertEquals("12345", b.toString());
  }

  @Test
  public void testLengthString() {
    BigNumber b = new BigNumberImpl("123456789");
    assertEquals(9, b.length());
  }

  @Test
  public void testGetDigitAt1() {
    BigNumber b = new BigNumberImpl();
    assertEquals(0, b.getDigitAt(0));
  }

  @Test
  public void testGetDigitAt2() {
    BigNumber b = new BigNumberImpl();
    assertEquals(0, b.getDigitAt(1));
  }

  @Test
  public void testGetDigitAt3() {
    BigNumber b = new BigNumberImpl();
    assertEquals(0, b.getDigitAt(1000));
  }

  @Test
  public void testGetDigitAt4() throws IllegalArgumentException {
    BigNumber b = new BigNumberImpl();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid index");
    int i = b.getDigitAt(-1);
  }

  @Test
  public void testGetDigitAtString1() {
    BigNumber b = new BigNumberImpl("1234");
    assertEquals(4, b.getDigitAt(0));
    assertEquals(3, b.getDigitAt(1));
    assertEquals(2, b.getDigitAt(2));
    assertEquals(1, b.getDigitAt(3));
  }

  @Test
  public void testGetDigitAtString2() {
    BigNumber b = new BigNumberImpl("1234");
    assertEquals(0, b.getDigitAt(4));
  }

  @Test
  public void testGetDigitAtString3() {
    BigNumber b = new BigNumberImpl("1234");
    assertEquals(0, b.getDigitAt(100));
  }

  @Test
  public void testGetDigitAtString4() throws IllegalArgumentException {
    BigNumber b = new BigNumberImpl("9999");
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Invalid index");
    int i = b.getDigitAt(-1);
  }

  @Test
  public void testAddDigit() {
    BigNumber b = new BigNumberImpl();
    b = b.addDigit(4);
    assertEquals(4, b.getDigitAt(0));
    assertEquals("4", b.toString());
  }

  @Test
  public void testAddDigitInvalidInput1() throws IllegalArgumentException {
    BigNumber b = new BigNumberImpl();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Enter valid digit");
    b = b.addDigit(12);
  }

  @Test
  public void testAddDigitInvalidInput2() throws IllegalArgumentException {
    BigNumber b = new BigNumberImpl();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Enter valid digit");
    b = b.addDigit(-1);
  }

  @Test
  public void testAddDigitZero() throws IllegalArgumentException {
    BigNumber b = new BigNumberImpl();
    b = b.addDigit(0);
    assertEquals(0, b.getDigitAt(0));
    assertEquals("0", b.toString());
  }

  @Test
  public void testAddDigitMultiple() throws IllegalArgumentException {
    BigNumber b = new BigNumberImpl();
    b = b.addDigit(4);
    b = b.addDigit(2);
    b = b.addDigit(1);
    assertEquals(7, b.getDigitAt(0));
    assertEquals("7", b.toString());
  }

  @Test
  public void testShiftLeft1() {
    BigNumber b = new BigNumberImpl();
    b = b.addDigit(3);
    b = b.shiftLeft(1);
    assertEquals("30", b.toString());
  }

  @Test
  public void testShiftLeft2() {
    BigNumber b = new BigNumberImpl();
    b = b.addDigit(3);
    b = b.shiftLeft(1);
    b = b.shiftLeft(1);
    assertEquals("300", b.toString());
  }

  @Test
  public void testShiftLeft3() {
    BigNumber b = new BigNumberImpl();
    b = b.addDigit(3);
    b = b.shiftLeft(2);
    assertEquals("300", b.toString());
  }

  @Test
  public void testShiftLeft4() {
    BigNumber b = new BigNumberImpl();
    b = b.shiftLeft(3);
    b = b.addDigit(4);
    b = b.shiftLeft(2);
    assertEquals("400", b.toString());
  }

  @Test
  public void testShiftLeftNegative() {
    BigNumber b = new BigNumberImpl();
    b = b.addDigit(3);
    b = b.shiftLeft(2);
    b = b.shiftLeft(-2);
    assertEquals("3", b.toString());
  }

  @Test
  public void testShiftLeftZero() {
    BigNumber b = new BigNumberImpl();
    b = b.addDigit(3);
    b = b.shiftLeft(0);
    assertEquals("3", b.toString());
  }

  @Test
  public void testShiftRight1() {
    BigNumber b = new BigNumberImpl();
    b = b.addDigit(3);
    b = b.shiftLeft(2);
    b = b.addDigit(1);
    assertEquals("301",b.toString());
    b = b.shiftRight(1);
    assertEquals("30", b.toString());
    b = b.shiftRight(1);
    assertEquals("3", b.toString());
  }

  @Test
  public void testShiftRight2() {
    BigNumber b = new BigNumberImpl();
    b = b.addDigit(3);
    b = b.shiftLeft(2);
    b = b.addDigit(1);
    b = b.shiftRight(2);
    assertEquals("3", b.toString());
  }

  @Test
  public void testShiftRight4() {
    BigNumber b = new BigNumberImpl();
    b = b.addDigit(3);
    b = b.shiftLeft(2);
    b = b.addDigit(1);
    b = b.shiftRight(3);
    assertEquals("0", b.toString());
  }

  @Test
  public void testRightShiftNegative() {
    BigNumber b = new BigNumberImpl();
    b = b.addDigit(3);
    b = b.shiftRight(-2);
    assertEquals("300", b.toString());
  }

  @Test
  public void testRightShiftZero() {
    BigNumber b = new BigNumberImpl();
    b = b.addDigit(3);
    b = b.shiftRight(0);
    assertEquals("3", b.toString());
  }

  @Test
  public void testEnterInput() {
    BigNumber b = new BigNumberImpl();
    b = b.addDigit(3);
    b = b.shiftLeft(1);
    b = b.addDigit(2);
    b = b.shiftLeft(1);
    b = b.addDigit(4);
    b = b.shiftLeft(1);
    b = b.addDigit(1);
    b = b.shiftLeft(1);
    b = b.addDigit(1);
    assertEquals("32411", b.toString());
  }

  @Test
  public void testCompare() {
    BigNumber b1 = new BigNumberImpl("10000000");
    BigNumber b2 = new BigNumberImpl("200000000");
    assertEquals(1, b2.compareTo(b1));
    assertEquals(-1, b1.compareTo(b2));
  }

  @Test
  public void testEquals1() {
    BigNumber b1 = new BigNumberImpl("100000000");
    BigNumber b2 = new BigNumberImpl("2000000000");
    assertEquals(1, b2.compareTo(b1));
    assertEquals(-1, b1.compareTo(b2));
  }

  @Test
  public void testEquals2() {
    BigNumber b1 = new BigNumberImpl("100000000");
    BigNumber b2 = new BigNumberImpl("200000000");
    assertEquals(false, b2.equals(b1));
    assertEquals(false, b1.compareTo(b2));
  }

  @Test
  public void testCompareLengthEquals3() {
    BigNumber b1 = new BigNumberImpl("111111110");
    BigNumber b2 = new BigNumberImpl("111111111");
    assertEquals(1, b2.compareTo(b1));
    assertEquals(-1, b1.compareTo(b2));
  }

  @Test
  public void testCompareLengthEquals4() {
    BigNumber b1 = new BigNumberImpl("111111111");
    BigNumber b2 = new BigNumberImpl("111111111");
    assertEquals(0, b2.compareTo(b1));
  }

  @Test
  public void testCompareLengthEquals5() {
    BigInteger b1 = new BigInteger("1111111112222222222");
    BigInteger b2 = new BigInteger("1111111112222222222");
    assertEquals(0, b2.compareTo(b1));
  }

  @Test
  public void testTimeOutShiftLeft() {
    BigNumber b = new BigNumberImpl();
    b = b.addDigit(1);
    b = b.shiftLeft(10000);
    assertEquals(10001, b.length());
  }

  @Test
  public void testAddBigNumber1() {
    BigNumber b1 = new BigNumberImpl("100000");
    BigNumber b2 = new BigNumberImpl("200000");
    BigNumber b3 = b2.add(b1);
    assertEquals("300000", b3.toString());
  }

  @Test
  public void testAddBigNumber2() {
    BigNumber b1 = new BigNumberImpl("100");
    BigNumber b2 = new BigNumberImpl("200000");
    BigNumber b3 = b2.add(b1);
    assertEquals("200100", b3.toString());
  }

}
