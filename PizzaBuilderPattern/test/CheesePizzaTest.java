import betterpizza.CheesePizza;
import betterpizza.ObservablePizza;
import org.junit.Before;
import org.junit.Test;
import pizza.Crust;
import pizza.Size;
import static org.junit.Assert.assertEquals;

/**
 * A JUnit test for better CheesePizza class.
 */

public class CheesePizzaTest {
  private ObservablePizza cheese;
  private ObservablePizza halfcheese;

  @Before
  public void setup() {
    cheese = new CheesePizza.CheesePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Large)
            .build();
    halfcheese = new CheesePizza.CheesePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Large)
            .leftHalfCheese()
            .build();
  }

  @Test
  public void testCost() {
    assertEquals(9,cheese.cost(),0.01);
    assertEquals(8.5,halfcheese.cost(),0.01);

  }
}