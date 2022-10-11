package calculator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


/**
 * A JUnit test class for Simple Calculator tests.
 */

public class SimpleCalculatorTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setup() {
    Calculator c1 = new SimpleCalculator();
  }

  @Test
  public void testSetup() {
    Calculator c2 = new SimpleCalculator();
    assertEquals('\0', c2.get(0));
  }

  @Test
  public void testBeforeInput() {
    Calculator c2 = new SimpleCalculator();
    assertEquals("", c2.getResult());
  }

  @Test
  public void testInvalidInput1() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Please enter a valid input.");
    c2.input('!');
  }

  @Test
  public void testInvalidInput2() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Please enter a valid input.");
    c2.input('Q');
  }

  @Test
  public void testInvalidInput3() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Please enter a valid input.");
    c2.input(' ');
  }

  @Test
  public void testInvalidInput4() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Please enter a valid input.");
    c2.input('c');
  }

  @Test
  public void testInvalidOperand1() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Please enter a valid input.");
    c2.input('&');
  }

  @Test
  public void testInvalidOperand2() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Please enter a valid input.");
    c2.input('Z');
  }

  @Test
  public void testInvalidOperand3() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Please enter a valid input.");
    c2.input('(');
  }

  @Test
  public void testInvalidOperand4() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Please enter a valid input.");
    c2.input('.');
  }

  @Test
  public void testInvalidOperator1() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Please enter a valid input.");
    c2.input('/');
  }

  @Test
  public void testInvalidOperator2() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Please enter a valid input.");
    c2.input('%');
  }

  @Test
  public void testInvalidOperatorAfterOperand1() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Please enter a valid input.");
    c2.input('3');
    c2.input('/');
  }

  @Test
  public void testInvalidOperatorAfterOperand2() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Please enter a valid input.");
    c2.input('3');
    c2.input('%');
    c2.input('1');
    c2.input('=');
  }


  @Test
  public void testFirstCharOperatorPlus() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Please enter a number first.");
    c2.input('+');
  }

  @Test
  public void testFirstCharOperatorMinus() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Please enter a number first.");
    c2.input('-');
  }

  @Test
  public void testFirstCharOperatorInto() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Please enter a number first.");
    c2.input('*');
  }

  @Test
  public void testFirstCharOperatorEqual() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Please enter a number first.");
    c2.input('=');

  }

  @Test
  public void testNegativeInput() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Please enter a number first.");
    c2.input('-');
    c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Please enter a number first.");
    c2.input('3');
    c2.input('+');
    c2.input('-');
    c2.input('2');
  }


  @Test
  public void testMultipleOperatorsAtTime() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Please enter a number first.");
    c2.input('3');
    c2.input('+');
    c2.input('=');
    c2.input('2');
  }

  @Test
  public void testRealTimeOutput() {
    Calculator c2 = new SimpleCalculator();
    c2.input('3');
    assertEquals("3", c2.getResult());
    c2.input('2');
    assertEquals("32", c2.getResult());
    c2.input('+');
    assertEquals("32+", c2.getResult());
    c2.input('4');
    assertEquals("32+4", c2.getResult());
    c2.input('2');
    assertEquals("32+42", c2.getResult());
  }

  @Test
  public void testEqualTo() {
    Calculator c2 = new SimpleCalculator();
    c2.input('1');
    assertEquals("1", c2.getResult());
    c2.input('1');
    assertEquals("11", c2.getResult());
    c2.input('+');
    assertEquals("11+", c2.getResult());
    c2.input('1');
    assertEquals("11+1", c2.getResult());
    c2.input('1');
    assertEquals("11+11", c2.getResult());
    c2.input('=');
    assertEquals("22", c2.getResult());
  }

  @Test
  public void testEqualToAfterNumber() {
    Calculator c2 = new SimpleCalculator();
    c2.input('1');
    c2.input('=');
    assertEquals("1", c2.getResult());
    c2.input('1');
    c2.input('1');
    c2.input('=');
    assertEquals("11", c2.getResult());
  }

  @Test
  public void testOperandAfterEqualTo() {
    Calculator c2 = new SimpleCalculator();
    c2.input('5');
    c2.input('+');
    c2.input('3');
    c2.input('=');
    assertEquals("8", c2.getResult());
    c2.input('4');
    assertEquals("4", c2.getResult());
    c2.input('*');
    c2.input('3');
    c2.input('=');
    assertEquals("12", c2.getResult());
  }

  @Test
  public void testAddition() {
    Calculator c2 = new SimpleCalculator();
    c2.input('5');
    assertEquals("5", c2.getResult());
    c2.input('0');
    assertEquals("50", c2.getResult());
    c2.input('+');
    assertEquals("50+", c2.getResult());
    c2.input('7');
    assertEquals("50+7", c2.getResult());
    c2.input('2');
    assertEquals("50+72", c2.getResult());
    c2.input('=');
    assertEquals("122", c2.getResult());
  }

  @Test
  public void testSubtraction() {
    Calculator c2 = new SimpleCalculator();
    c2.input('5');
    assertEquals("5", c2.getResult());
    c2.input('0');
    assertEquals("50", c2.getResult());
    c2.input('-');
    assertEquals("50-", c2.getResult());
    c2.input('4');
    assertEquals("50-4", c2.getResult());
    c2.input('0');
    assertEquals("50-40", c2.getResult());
    c2.input('=');
    assertEquals("10", c2.getResult());
  }

  @Test
  public void testSubtractionNegOutput() {
    Calculator c2 = new SimpleCalculator();
    c2.input('5');
    assertEquals("5", c2.getResult());
    c2.input('0');
    assertEquals("50", c2.getResult());
    c2.input('-');
    assertEquals("50-", c2.getResult());
    c2.input('6');
    assertEquals("50-6", c2.getResult());
    c2.input('0');
    assertEquals("50-60", c2.getResult());
    c2.input('=');
    assertEquals("-10", c2.getResult());
  }

  @Test
  public void testMultiplication() {
    Calculator c2 = new SimpleCalculator();
    c2.input('5');
    assertEquals("5", c2.getResult());
    c2.input('0');
    assertEquals("50", c2.getResult());
    c2.input('*');
    assertEquals("50*", c2.getResult());
    c2.input('2');
    assertEquals("50*2", c2.getResult());
    c2.input('0');
    assertEquals("50*20", c2.getResult());
    c2.input('=');
    assertEquals("1000", c2.getResult());
  }

  @Test
  public void testMultipleEqualTo() {
    Calculator c2 = new SimpleCalculator();
    c2.input('3');
    assertEquals("3", c2.getResult());
    c2.input('2');
    assertEquals("32", c2.getResult());
    c2.input('+');
    assertEquals("32+", c2.getResult());
    c2.input('4');
    assertEquals("32+4", c2.getResult());
    c2.input('2');
    assertEquals("32+42", c2.getResult());
    c2.input('=');
    assertEquals("74", c2.getResult());
    c2.input('=');
    assertEquals("74", c2.getResult());
    c2.input('=');
    assertEquals("74", c2.getResult());
  }

  @Test
  public void testMultipleEqualToNegOutput() {
    Calculator c2 = new SimpleCalculator();
    c2.input('5');
    assertEquals("5", c2.getResult());
    c2.input('0');
    assertEquals("50", c2.getResult());
    c2.input('-');
    assertEquals("50-", c2.getResult());
    c2.input('6');
    assertEquals("50-6", c2.getResult());
    c2.input('0');
    assertEquals("50-60", c2.getResult());
    c2.input('=');
    assertEquals("-10", c2.getResult());
    c2.input('=');
    assertEquals("-10", c2.getResult());
    c2.input('=');
    assertEquals("-10", c2.getResult());
  }

  @Test
  public void testMultipleOperators() {
    Calculator c2 = new SimpleCalculator();
    c2.input('3');
    assertEquals("3", c2.getResult());
    c2.input('2');
    assertEquals("32", c2.getResult());
    c2.input('+');
    assertEquals("32+", c2.getResult());
    c2.input('4');
    assertEquals("32+4", c2.getResult());
    c2.input('2');
    assertEquals("32+42", c2.getResult());
    c2.input('-');
    assertEquals("74-", c2.getResult());
    c2.input('1');
    assertEquals("74-1", c2.getResult());
    c2.input('0');
    assertEquals("74-10", c2.getResult());
    c2.input('*');
    assertEquals("64*", c2.getResult());
    c2.input('1');
    assertEquals("64*1", c2.getResult());
    c2.input('0');
    assertEquals("64*10", c2.getResult());
    c2.input('=');
    assertEquals("640", c2.getResult());
  }

  @Test
  public void testClear() {
    Calculator c2 = new SimpleCalculator();
    c2.input('C');
    assertEquals("", c2.getResult());
    c2.input('3');
    assertEquals("3", c2.getResult());
    c2.input('C');
    assertEquals("", c2.getResult());
  }

  @Test
  public void testClearMultiple() {
    Calculator c2 = new SimpleCalculator();
    c2.input('3');
    assertEquals("3", c2.getResult());
    c2.input('C');
    assertEquals( "", c2.getResult());
    c2.input('2');
    assertEquals("2", c2.getResult());
    c2.input('+');
    assertEquals( "2+", c2.getResult());
    c2.input('C');
    assertEquals( "", c2.getResult());
    c2.input('5');
    assertEquals("5", c2.getResult());
    c2.input('+');
    assertEquals( "5+", c2.getResult());
    c2.input('3');
    assertEquals("5+3", c2.getResult());
    c2.input('C');
    assertEquals( "", c2.getResult());
    c2.input('3');
    assertEquals("3", c2.getResult());
    c2.input('2');
    assertEquals("32", c2.getResult());
    c2.input('+');
    assertEquals( "32+", c2.getResult());
    c2.input('4');
    assertEquals("32+4", c2.getResult());
    c2.input('2');
    assertEquals("32+42", c2.getResult());
    c2.input('=');
    assertEquals("74", c2.getResult());
    c2.input('C');
    assertEquals("", c2.getResult());
  }

  @Test
  public void testClearMultipleAtTime() {
    Calculator c2 = new SimpleCalculator();
    c2.input('3');
    assertEquals("3", c2.getResult());
    c2.input('C');
    assertEquals("", c2.getResult());
    c2.input('C');
    assertEquals("", c2.getResult());
    c2.input('C');
    assertEquals("", c2.getResult());
    c2.input('3');
    assertEquals("3", c2.getResult());
  }

  @Test
  public void testZeroStart() {
    Calculator c2 = new SimpleCalculator();
    c2.input('0');
    assertEquals("0", c2.getResult());
    c2.input('3');
    assertEquals("3", c2.getResult());
    c2.input('+');
    assertEquals("3+", c2.getResult());
    c2.input('0');
    assertEquals("3+0", c2.getResult());
    c2.input('2');
    assertEquals("3+2", c2.getResult());
    c2.input('=');
    assertEquals("5", c2.getResult());
  }

  @Test
  public void testOperandOverflow1() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Operand overflow occurred.");
    c2.input('2');
    c2.input('1');
    c2.input('4');
    c2.input('7');
    c2.input('4');
    c2.input('8');
    c2.input('3');
    c2.input('6');
    c2.input('4');
    c2.input('8');
    c2.input('+');
    c2.input('2');
    c2.input('1');
    c2.input('4');
    c2.input('7');
    c2.input('4');
    c2.input('8');
    c2.input('3');
    c2.input('6');
    c2.input('4');
    c2.input('8');
  }

  @Test
  public void testOperandOverflow2() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Operand overflow occurred.");
    c2.input('2');
    c2.input('1');
    c2.input('4');
    c2.input('7');
    c2.input('4');
    c2.input('8');
    c2.input('3');
    c2.input('6');
    c2.input('4');
    c2.input('8');
    c2.input('+');
    c2.input('1');
    c2.input('=');
  }

  @Test
  public void testOperandOverflow3() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Operand overflow occurred.");
    c2.input('1');
    c2.input('+');
    c2.input('2');
    c2.input('1');
    c2.input('4');
    c2.input('7');
    c2.input('4');
    c2.input('8');
    c2.input('3');
    c2.input('6');
    c2.input('4');
    c2.input('8');
    c2.input('=');
  }

  @Test
  public void testOperandOverflow4() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Operand overflow occurred.");
    c2.input('1');
    c2.input('-');
    c2.input('2');
    c2.input('1');
    c2.input('4');
    c2.input('7');
    c2.input('4');
    c2.input('8');
    c2.input('3');
    c2.input('6');
    c2.input('4');
    c2.input('8');
    c2.input('=');
  }

  @Test
  public void testResultOverflowAddition() {
    Calculator c2 = new SimpleCalculator();
    c2.input('2');
    c2.input('1');
    c2.input('4');
    c2.input('7');
    c2.input('4');
    c2.input('8');
    c2.input('3');
    c2.input('6');
    c2.input('4');
    c2.input('7');
    c2.input('+');
    c2.input('1');
    c2.input('=');
    assertEquals("0",c2.getResult());
  }

  @Test
  public void testResultOverflowSubtraction() {
    Calculator c2 = new SimpleCalculator();
    c2.input('0');
    c2.input('-');
    c2.input('2');
    c2.input('-');
    c2.input('2');
    c2.input('1');
    c2.input('4');
    c2.input('7');
    c2.input('4');
    c2.input('8');
    c2.input('3');
    c2.input('6');
    c2.input('4');
    c2.input('7');
    c2.input('=');
    assertEquals("0",c2.getResult());
  }

  @Test
  public void testResultOverflowMultiplication() {
    Calculator c2 = new SimpleCalculator();
    c2.input('2');
    c2.input('1');
    c2.input('4');
    c2.input('7');
    c2.input('4');
    c2.input('8');
    c2.input('3');
    c2.input('6');
    c2.input('4');
    c2.input('7');
    c2.input('*');
    c2.input('2');
    c2.input('=');
    assertEquals("0",c2.getResult());
  }

  @Test
  public void testResultOverflowMultipleOperators() {
    Calculator c2 = new SimpleCalculator();
    c2.input('2');
    c2.input('1');
    c2.input('4');
    c2.input('7');
    c2.input('4');
    c2.input('8');
    c2.input('3');
    c2.input('6');
    c2.input('4');
    c2.input('7');
    c2.input('+');
    c2.input('1');
    assertEquals("2147483647+1",c2.getResult());
    c2.input('-');
    assertEquals("0-",c2.getResult());
    c2.input('2');
    c2.input('0');
    c2.input('=');
    assertEquals("-20",c2.getResult());
  }

  @Test
  public void testOperandOverflowResult1() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    try {
      c2.input('2');
      c2.input('1');
      c2.input('4');
      c2.input('7');
      c2.input('4');
      c2.input('8');
      c2.input('3');
      c2.input('6');
      c2.input('4');
      c2.input('8');
      c2.input('+');
      c2.input('2');
      c2.input('1');
      c2.input('4');
      c2.input('7');
      c2.input('4');
      c2.input('8');
      c2.input('3');
      c2.input('6');
      c2.input('4');
      c2.input('8');
    }
    catch (IllegalArgumentException e) {
      assertEquals("214748364", c2.getResult());
    }
  }

  @Test
  public void testOperandOverflowResult2() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    try {
      c2.input('2');
      c2.input('1');
      c2.input('4');
      c2.input('7');
      c2.input('4');
      c2.input('8');
      c2.input('3');
      c2.input('6');
      c2.input('4');
      c2.input('8');
      c2.input('+');
      c2.input('1');
      c2.input('=');
    }
    catch (IllegalArgumentException e) {
      assertEquals("214748364", c2.getResult());
    }
  }

  @Test
  public void testOperandOverflowResult3() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    try {
      c2.input('1');
      c2.input('+');
      c2.input('2');
      c2.input('1');
      c2.input('4');
      c2.input('7');
      c2.input('4');
      c2.input('8');
      c2.input('3');
      c2.input('6');
      c2.input('4');
      c2.input('8');
      c2.input('=');
    }
    catch (IllegalArgumentException e) {
      assertEquals("1+214748364", c2.getResult());
    }
  }

  @Test
  public void testOperandOverflowResult4() throws IllegalArgumentException {
    Calculator c2 = new SimpleCalculator();
    try {
      c2.input('0');
      c2.input('-');
      c2.input('2');
      c2.input('-');
      c2.input('2');
      c2.input('1');
      c2.input('4');
      c2.input('7');
      c2.input('4');
      c2.input('8');
      c2.input('3');
      c2.input('6');
      c2.input('4');
      c2.input('7');
      c2.input('=');
    }
    catch (IllegalArgumentException e) {
      assertEquals("-2-2147483647", c2.getResult());
    }
  }

  @Test
  public void testOperandMaxValue() {
    Calculator c2 = new SimpleCalculator();
    c2.input('2');
    c2.input('1');
    c2.input('4');
    c2.input('7');
    c2.input('4');
    c2.input('8');
    c2.input('3');
    c2.input('6');
    c2.input('4');
    c2.input('7');
    c2.input('*');
    assertEquals("2147483647*", c2.getResult());
  }

}