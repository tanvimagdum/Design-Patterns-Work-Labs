package betterpizza;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;
import java.util.Map;

/**
 * This class represents a better cheese pizza.
 */
public class CheesePizza extends AlaCartePizza {


  /**
   * Create a cheese pizza.
   * @param size the size of this pizza
   * @param crust the crust of this pizza
   * @param toppings the toppings over this pizza
   */
  public CheesePizza(Size size, Crust crust, Map<ToppingName,ToppingPortion> toppings) {
    super(size, crust,toppings);
  }

  /**
   * A builder class for CheesePizza.
   */
  public static class CheesePizzaBuilder extends PizzaBuilder<CheesePizzaBuilder> {

    /**
     * Construct an instance of CheesePizzaBuilder of the
     * specified size with the specified crust.
     */
    public CheesePizzaBuilder() {
      this.addTopping(ToppingName.Cheese, ToppingPortion.Full);
      this.addTopping(ToppingName.Sauce, ToppingPortion.Full);
    }

    @Override
    protected PizzaBuilder<CheesePizzaBuilder> returnBuilder() {
      return this;
    }

    /**
     * A build class that builds an immutable version of cheese pizza.
     * @return a new instance of CheesePizza
     * @throws IllegalStateException if size is empty
     */
    public CheesePizza build() throws IllegalStateException {
      if (tempSize == null) {
        throw new IllegalStateException("Size not mentioned");
      }
      return new CheesePizza(tempSize, tempCrust, tempToppings);
    }

    /**
     * A method that prevents adding cheese.
     * @return the current CheesePizzaBuilder instance
     */
    public PizzaBuilder<CheesePizzaBuilder> noCheese() {
      this.addTopping(ToppingName.Cheese, ToppingPortion.Full);
      return returnBuilder();
    }

    /**
     * A method that adds cheese only to the left half.
     * @return the current CheesePizzaBuilder instance
     */
    public PizzaBuilder<CheesePizzaBuilder> leftHalfCheese() {
      this.addTopping(ToppingName.Cheese, ToppingPortion.LeftHalf);
      return returnBuilder();
    }

    /**
     * A method that adds cheese only to the right half.
     * @return the current CheesePizzaBuilder instance
     */
    public PizzaBuilder<CheesePizzaBuilder> rightHalfCheese() {
      this.addTopping(ToppingName.Cheese, ToppingPortion.RightHalf);
      return returnBuilder();
    }

  }
}
