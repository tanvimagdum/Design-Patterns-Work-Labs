import betterpizza.ObservablePizza;
import betterpizza.VeggiePizza;
import org.junit.Before;
import org.junit.Test;
import pizza.Crust;
import pizza.Size;
import static org.junit.Assert.assertEquals;

/**
 * A JUnit test for better VeggiePizza class.
 */
public class VeggiePizzaTest {
  private ObservablePizza veggie;

  @Before
  public void setup() {
    veggie = new VeggiePizza.VeggiePizzaBuilder()
            .crust(Crust.Thin)
            .size(Size.Large)
            .build();
  }

  @Test
  public void testCost() {
    assertEquals(11.5,veggie.cost(),0.01);
  }
}