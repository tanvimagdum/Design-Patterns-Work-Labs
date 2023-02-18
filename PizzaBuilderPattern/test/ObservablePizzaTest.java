import betterpizza.AlaCartePizza;
import betterpizza.ObservablePizza;
import org.junit.Before;
import org.junit.Test;
import pizza.Crust;
import pizza.Size;
import pizza.ToppingPortion;
import pizza.ToppingName;
import static org.junit.Assert.assertEquals;

/**
 * A JUnit test for better AlaCartePizza class.
 */
public class ObservablePizzaTest {

  private ObservablePizza alacarte;
  private ObservablePizza alacarte2;

  @Before
  public void setup() {
    alacarte = new AlaCartePizza.AlaCartePizzaBuilder()
            .crust(Crust.Classic)
            .size(Size.Medium)
            .addTopping(ToppingName.Cheese, ToppingPortion.Full)
            .addTopping(ToppingName.Sauce,ToppingPortion.Full)
            .addTopping(ToppingName.GreenPepper,ToppingPortion.Full)
            .addTopping(ToppingName.Onion,ToppingPortion.Full)
            .addTopping(ToppingName.Jalapeno,ToppingPortion.LeftHalf)
            .build();

    alacarte2 = new AlaCartePizza.AlaCartePizzaBuilder()
            .crust(Crust.Stuffed)
            .size(Size.Medium)
            .build();
  }

  @Test
  public void testCost() {
    assertEquals(8.25,alacarte.cost(),0.01);
    assertEquals(5.0,alacarte2.cost(),0.01);
  }


}