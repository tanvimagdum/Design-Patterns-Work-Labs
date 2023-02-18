package betterpizza;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingPortion;
import pizza.ToppingName;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a better ala carte pizza (i.e. a pizza that can
 * have an arbitrary number of ingredients.)
 */
public class AlaCartePizza implements ObservablePizza {
  protected Crust crust;
  protected Size size;
  protected Map<ToppingName, ToppingPortion> toppings;

  protected AlaCartePizza(Size size, Crust crust, Map<ToppingName, ToppingPortion> toppings)
          throws IllegalArgumentException {

    if (size == null || crust == null || toppings == null) {
      throw new IllegalArgumentException("Invalid values.");
    }
    this.crust = crust;
    this.size = size;
    this.toppings = toppings;
  }

  /**
   * A builder class for AlaCartePizza.
   */
  public static class AlaCartePizzaBuilder extends PizzaBuilder<AlaCartePizzaBuilder> {

    @Override
    protected PizzaBuilder<AlaCartePizzaBuilder> returnBuilder() {
      return this;
    }

    /**
     * A build class that builds an immutable version of pizza.
     * @return a new instance of AlaCartePizza
     * @throws IllegalStateException if size is empty
     */
    public AlaCartePizza build() throws IllegalStateException {
      if (tempSize == null) {
        throw new IllegalStateException("Size not mentioned");
      }
      return new AlaCartePizza(tempSize, tempCrust, tempToppings);
    }
  }

  /**
   * Create a pizza given its crust type, size and toppings.
   */
  public AlaCartePizza(Size size, Crust crust) {
    this.crust = crust;
    this.size = size;
    this.toppings = new HashMap<ToppingName, ToppingPortion>();
  }


  @Override
  public ToppingPortion hasTopping(ToppingName name) {
    return this.toppings.getOrDefault(name, null);
  }

  @Override
  public double cost() {
    double cost = 0.0;
    for (Map.Entry<ToppingName, ToppingPortion> item : this.toppings.entrySet()) {
      cost += item.getKey().getCost() * item.getValue().getCostMultiplier();
    }
    return cost + this.size.getBaseCost();
  }

}
