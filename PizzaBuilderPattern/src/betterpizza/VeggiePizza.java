package betterpizza;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;
import java.util.Map;

/**
 * This class represents a better vegetarian pizza.
 */
public class VeggiePizza extends AlaCartePizza {

  /**
   * Create a veggie pizza.
   * @param size the size of this pizza
   * @param crust the crust of this pizza
   * @param toppings the toppings over this pizza
   */
  public VeggiePizza(Size size, Crust crust, Map<ToppingName,ToppingPortion> toppings) {
    super(size,crust,toppings);
  }

  /**
   * A builder class for VeggiePizza.
   */
  public static class VeggiePizzaBuilder extends PizzaBuilder<VeggiePizzaBuilder> {

    /**
     * Construct an instance of VeggiePizzaBuilder with all vegetarian toppings,
     * of the specified size with the specified crust.
     */
    public VeggiePizzaBuilder() {
      this.addTopping(ToppingName.Cheese, ToppingPortion.Full);
      this.addTopping(ToppingName.Sauce,ToppingPortion.Full);
      this.addTopping(ToppingName.BlackOlive,ToppingPortion.Full);
      this.addTopping(ToppingName.GreenPepper,ToppingPortion.Full);
      this.addTopping(ToppingName.Onion,ToppingPortion.Full);
      this.addTopping(ToppingName.Jalapeno,ToppingPortion.Full);
      this.addTopping(ToppingName.Tomato,ToppingPortion.Full);
    }

    @Override
    protected PizzaBuilder<VeggiePizzaBuilder> returnBuilder() {
      return this;
    }

    /**
     * A build class that builds an immutable version of veggie pizza.
     * @return a new instance of VeggiePizza
     * @throws IllegalStateException if size is empty
     */
    public VeggiePizza build() throws IllegalStateException {
      if (tempSize == null) {
        throw new IllegalStateException("Size not mentioned");
      }
      return new VeggiePizza(tempSize, tempCrust, tempToppings);
    }
  }
}
