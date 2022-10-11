package calculator;


/**
 * A SimpleCalculator class that implements
 * the functions of a calculator.
 */

public class SimpleCalculator extends EmptyCalculator {

  /**
   * SimpleCalculator class extends EmptyCalculator class
   * which contains the list implementation where
   * a list of calculator inputs is being stored.
   * @param outp contains the real time result of calculator
   * @param num is a dummy calculator object
   *            used for performing processes
   * @param n1 contains the parsed integer output
   *           of the resulting string
   * @param cnt used to store the length of
   *            operand string
   * @param flag used for identifying multiple operators
   *             in one transaction without equals operator
   * @param operator used to store the operator
   * @param n2 used for identifying if operand has overflown
   *
   */

  private String outp;
  private Calculator num;
  private long n1;
  private int cnt;
  private static boolean flag;
  private long n2;
  private char operator;
  String str = "";

  /**
   * Construct a SimpleCalculator object
   * that performs basic calculator operations.
   */
  public SimpleCalculator() {
    super();
    this.num = new EmptyCalculator();
    this.n1 = 0;
    this.n2 = 0;
    this.cnt = 0;
    this.outp = "";
  }

  @Override
  public Calculator input(char c) throws IllegalArgumentException {

    if (!((c > 47 && c < 58)
            || c == '+'
            || c == '-'
            || c == '*'
            || c == '='
            || c == 'C')) {
      throw new IllegalArgumentException("Please enter a valid input.");
    }

    if (c == 'C') {
      this.delCalcData();
      num = new EmptyCalculator();
      n1 = 0;
      n2 = 0;
      cnt = 0;
      outp = "";
      flag = false;
    }

    else if (c > 47 && c < 58) {

      if (!flag) {
        this.delCalcData();
        num = new EmptyCalculator();
        cnt = 0;
        n2 = 0;
        flag = true;
      }

      this.addBack(c);
      str = str + c;

      n2 = Long.parseLong(str);
      if (n2 > Integer.MAX_VALUE) {
        throw new IllegalArgumentException("Operand overflow occurred.");
      }

      outp = outp + c;
      num = num.addBack(c);
      cnt++;
    }

    else if (c == '+' || c == '-' || c == '*' || c == '=') {
      str = "";
      n2 = 0;
      if (num.get(0) == '\0') {
        throw new IllegalArgumentException("Please enter a number first.");
      }

      for (int i = 0; i < cnt; i++) {
        str = str + num.get(i);
      }

      switch (operator) {
        case '+':
          n1 = n1 + Long.parseLong(str);
          if (n1 > Integer.MAX_VALUE) {
            n1 = 0;
          }
          num = new EmptyCalculator();
          cnt = 0;
          flag = true;
          break;
        case '-':
          n1 = n1 - Long.parseLong(str);
          if (n1 < Integer.MIN_VALUE) {
            n1 = 0;
          }
          num = new EmptyCalculator();
          cnt = 0;
          flag = true;
          break;
        case '*':
          n1 = n1 * Long.parseLong(str);
          if (n1 > Integer.MAX_VALUE) {
            n1 = 0;
          }
          num = new EmptyCalculator();
          flag = true;
          cnt = 0;
          break;
        default:
          n1 = Long.parseLong(str);
          if (n1 > Integer.MAX_VALUE) {
            n1 = 0;
          }
          num = new EmptyCalculator();
          cnt = 0;
          break;
      }
      str = "";

      operator = c;

      if (c != '=' && flag) {
        flag = true;
        String numbers = String.valueOf(n1);
        this.delCalcData();

        for (int i = 0; i < numbers.length(); i++) {
          this.addBack(numbers.charAt(i));
        }
        outp = numbers;
      }

      this.addBack(c);
      outp = outp + c;

      if (c == '=') {
        String numbers = String.valueOf(n1);
        this.delCalcData();
        num.delCalcData();

        for (int i = 0; i < numbers.length(); i++) {
          this.addBack(numbers.charAt(i));
          num = num.addBack(numbers.charAt(i));
          cnt++;
        }

        outp = numbers;
        flag = false;
      }
    }

    return this;
  }

  @Override
  public String getResult() {
    return this.outp;
  }


}
