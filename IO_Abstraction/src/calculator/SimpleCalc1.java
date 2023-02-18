package calculator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Demonstrates a simple command-line-based calculator
 */
public class SimpleCalc1 {
  public static void main(String[] args) {

    CalculatorModel model = new CalculatorModelImpl();
    CalcController controller = new CalcControllerImpl(model, System.in, System.out);

    controller.go();

    /*int num1, num2;
    Scanner scan = new Scanner(System.in);
    num1 = scan.nextInt();
    num2 = scan.nextInt();
    System.out.printf("%d", num1 + num2);*/
  }
}
