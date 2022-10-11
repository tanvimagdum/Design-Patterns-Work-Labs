package calculator;


import java.util.Scanner;

/**
 * A SmartCalculator class that implements
 * the functions of a calculator.
 */

public class SmartCalculator extends EmptyCalculator {

  /**
   * SmartCalculator class extends EmptyCalculator class
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
   * @param operatorFlag used for identifying multiple equals
   *                     operators
   * @param tempOperator used for storing most recent operator
   *                     before equals
   * @param operator used to store the operator
   * @param n2 used for identifying if operand has overflown
   * @param str used for storing the operand value
   * @param tempOperand used to store an operand temporarily
   * @param cntEquals counts how many times equalTo appears
   *
   */

  private String outp;
  private Calculator num;
  private long n1;
  private int cnt;
  private static boolean flag;
  private static boolean operatorFlag;
  private char tempOperator;
  private char operator;
  private long n2;
  private String str = "";
  private static long tempOperand;
  private int cntEquals;

  /**
   * Construct a SmartCalculator object
   * that performs basic calculator operations.
   */
  public SmartCalculator() {
    super();
    this.outp = "";
    this.num = new EmptyCalculator();
    this.n1 = 0;
    this.cnt = 0;
    this.n2 = 0;
    this.tempOperator = '\0';
    this.operator = '\0';
    this.str = "";
    this.flag = false;
    this.operatorFlag = false;
    this.tempOperand = 0;
    this.cntEquals = 0;
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

      if (outp.equals("")) {
        if (c == '-' || c == '*' || c == '=') {
          throw new IllegalArgumentException("Please enter a valid input.");
        }
      }

      if (num.get(0) == '\0') {
        tempOperator = operator;
        operator = '$';
      }

      if (operatorFlag) {
        operator = '$';
      }
      else if (cntEquals > 0) {
        tempOperator = operator;
        operator = '$';
      }

      for (int i = 0; i < cnt; i++) {
        str = str + num.get(i);
      }

      switch (operator) {
        case '+':
          tempOperand = Long.parseLong(str);
          n1 = n1 + Long.parseLong(str);
          if (n1 > Integer.MAX_VALUE) {
            n1 = 0;
          }
          num = new EmptyCalculator();
          cnt = 0;
          cntEquals = 0;
          flag = true;
          break;
        case '-':
          tempOperand = Long.parseLong(str);
          n1 = n1 - Long.parseLong(str);
          if (n1 < Integer.MIN_VALUE) {
            n1 = 0;
          }
          num = new EmptyCalculator();
          cnt = 0;
          cntEquals = 0;
          flag = true;
          break;
        case '*':
          tempOperand = Long.parseLong(str);
          n1 = n1 * Long.parseLong(str);
          if (n1 > Integer.MAX_VALUE) {
            n1 = 0;
          }
          num = new EmptyCalculator();
          flag = true;
          cnt = 0;
          cntEquals = 0;
          break;
        case '$':
          break;
        default:
          tempOperand = Long.parseLong(str);
          n1 = Long.parseLong(str);
          if (n1 > Integer.MAX_VALUE) {
            n1 = 0;
          }
          num = new EmptyCalculator();
          cnt = 0;
          cntEquals = 0;
          break;
      }

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
        cntEquals++;
        if (operator == '$') {
          operatorFlag = true;
          switch (tempOperator) {
            case '+':
              n1 = n1 + tempOperand;
              if (n1 > Integer.MAX_VALUE) {
                n1 = 0;
              }
              num = new EmptyCalculator();
              cnt = 0;
              flag = true;
              break;
            case '-':
              n1 = n1 - tempOperand;
              num = new EmptyCalculator();
              cnt = 0;
              flag = true;
              break;
            case '*':
              n1 = n1 * tempOperand;
              if (n1 > Integer.MAX_VALUE) {
                n1 = 0;
              }
              num = new EmptyCalculator();
              flag = true;
              cnt = 0;
              break;
            default:
              if (n1 > Integer.MAX_VALUE) {
                n1 = 0;
              }
              num = new EmptyCalculator();
              cnt = 0;
              break;
          }
        }

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

      str = "";
      operator = c;
    }

    return this;
  }


  @Override
  public String getResult() {
    return this.outp;
  }

  public static void main(String args[]) {

    Calculator calc1 = new SmartCalculator();
    Scanner sc = new Scanner(System.in);
    char in;

    while (true) {
      in = sc.nextLine().charAt(0);
      if (in == 'E')
        break;
      calc1 = calc1.input(in);
      System.out.println(calc1.getResult());
    }
  }

}
