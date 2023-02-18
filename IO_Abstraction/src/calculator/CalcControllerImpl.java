package calculator;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CalcControllerImpl implements CalcController{

    private CalculatorModel model;
    private InputStream input;
    private PrintStream output;

    public CalcControllerImpl(CalculatorModel model, InputStream in, PrintStream out) {
        this.model = model;
        this.input = in;
        this.output = out;
    }

    @Override
    public void go() {
        int num1, num2;
        Scanner scan = new Scanner(input);
        num1 = scan.nextInt() ;
        num2 = scan.nextInt() ;
        this.output.printf("%d", model.add(num1, num2));
    }

}
