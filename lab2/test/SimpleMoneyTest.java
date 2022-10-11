import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertEquals;


/**
 * A JUnit test class for SimpleMoney.
 */


public class SimpleMoneyTest {

  private Money sm0;
  private Money sm1;
  private Money sm2;
  private Money sm3;
  private Money sm4;
  private Money sm5;
  private Money sm6;
  private Money sm7;


  @Before
  public void setup() {

    sm0 = new SimpleMoney(10,1);
    sm1 = new SimpleMoney(10,10);
    sm2 = new SimpleMoney(10,20);
    sm3 = new SimpleMoney(0,0);
    sm6 = new SimpleMoney(10, 100);
    sm7 = new SimpleMoney(10, 1000);

  }


  @Test
  public void test1() {
    float delta = 0.0001f;
    sm0.add(1,2);

    assertEquals(11, sm0.getDollar());
    assertEquals(3, sm0.getCent());
    assertEquals(11.03, sm0.getDecimalValue(),delta);
    assertEquals("$11.03", sm0.toString());

  }

  @Test
  public void test2() {
    float delta = 0.0001f;
    sm1.add(sm2);

    assertEquals(20, sm1.getDollar());
    assertEquals(10, sm2.getDollar());

    assertEquals(30, sm1.getCent());
    assertEquals(20, sm2.getCent());

    assertEquals(20.30, sm1.getDecimalValue(), delta);
    assertEquals("$20.30", sm1.toString());

  }

  @Test
  public void test3() {
    float delta = 0.0001f;
    sm3.add(sm3);

    assertEquals(0,sm3.getDollar());
    assertEquals(0, sm3.getCent());
    assertEquals(0.00, sm3.getDecimalValue(),delta);
    assertEquals("$0.00", sm3.toString());

  }

  @Test
  public void test4() {
    float delta = 0.0001f;
    sm3.add(sm6);
    assertEquals(11, sm3.getDollar());
    assertEquals(0, sm3.getCent());
    assertEquals(11.00,sm3.getDecimalValue(),delta);
    assertEquals("$11.00", sm3.toString());
  }

  @Test
  public void test5() {

    float delta = 0.0001f;
    sm7.add(sm7);

    assertEquals(40,sm7.getDollar());
    assertEquals(0, sm7.getCent());
    assertEquals(40.00, sm7.getDecimalValue(),delta);
    assertEquals("$40.00", sm7.toString());
  }

  @Test
  public void test6() {

    Throwable exception = assertThrows(
        IllegalArgumentException.class, () -> sm4 = new SimpleMoney(-12, 3)
    );

    assertEquals("Dollar and cent value cannot be negative", exception.getMessage());
  }

  @Test
  public void test7() {

    Throwable exception = assertThrows(
        IllegalArgumentException.class, () -> sm5 = new SimpleMoney(12,-3)
    );

    assertEquals("Dollar and cent value cannot be negative", exception.getMessage());
  }

  @Test
  public void testFuzz1() {

    float delta = 0.0001f;
    Random r = new Random();
    Money m1;
    Money m2;

    for (int i = 0; i < 10000; i++) {
      int dollar = r.nextInt();
      int cent = r.nextInt();
      int dollarA = r.nextInt();
      int centA = r.nextInt();

      if (dollar < 0 || cent < 0 || dollarA < 0 || centA < 0) {
        continue;
      }

      m1 = new SimpleMoney(dollar, cent);
      m2 = new SimpleMoney(dollarA, centA);

      m1.add(m2);

      double d = m1.getDecimalValue();
      String expected = String.format("$%.2f",d);

      assertEquals(expected, m1.toString());
    }
  }

  @Test
  public void testFuzz2() {

    Random r = new Random();
    final Money[] m = new Money[1];

    for (int i = 0; i < 10000; i++) {
      int dollar = r.nextInt();
      int cent = r.nextInt();

      if (dollar < 0 || cent < 0) {
        Throwable exception = assertThrows(
            IllegalArgumentException.class, () -> m[0] = new SimpleMoney(dollar, cent)
        );

        assertEquals("Dollar and cent value cannot be negative", exception.getMessage());
      }
    }
  }

}
