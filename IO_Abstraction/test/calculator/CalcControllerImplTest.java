package calculator;

import org.junit.Test;

import java.io.*;
import java.util.Random;

import static org.junit.Assert.*;

public class CalcControllerImplTest {

    class MockModel implements CalculatorModel {

        private StringBuilder log;

        public  MockModel(StringBuilder log) {
            this.log = log;
        }
        @Override
        public int add(int a, int b) {
            log.append("Add called with inputs: " +a+ " " +b);
            return 0;
        }
    }


    @Test
    public void testController() {

        InputStream in = null;

        Random r = new Random(200);
        for (int i = 0 ; i <10000 ; i++) {
            int a = 32;
            int b = 24;
            int expectedResult = a + b;

            String inputString =  a+ " " +b;
            String expectedLog = "Add called with inputs: " +a+ " " +b;
            StringBuilder mockLog = new StringBuilder();

            in = new ByteArrayInputStream((a + " " + b).getBytes());
            OutputStream out = new ByteArrayOutputStream();

            CalculatorModel model = new MockModel(mockLog);
            CalcController controller = new CalcControllerImpl(model, in, new PrintStream(out));
            controller.go();

            //assertEquals(String.format("%d", expectedResult), out.toString());
            assertEquals(expectedLog, mockLog.toString());
        }

    }
}