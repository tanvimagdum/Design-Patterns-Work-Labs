package betterpizza;

import pizza.Crust;
import pizza.Size;
import pizza.ToppingName;
import pizza.ToppingPortion;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the abstract builder method to
 * make the pizza immutable once it is complete.
 */
public abstract class PizzaBuilder<T extends PizzaBuilder<T>>  {

  protected Crust tempCrust;
  protected Size tempSize;
  protected Map<ToppingName, ToppingPortion> tempToppings = new HashMap<>();

  public PizzaBuilder crust(Crust crust) {
    this.tempCrust = crust;
    return returnBuilder();
  }

  public PizzaBuilder size(Size size) {
    this.tempSize = size;
    return returnBuilder();
  }

  public PizzaBuilder addTopping(ToppingName name, ToppingPortion portion) {
    this.tempToppings.put(name, portion);
    return returnBuilder();
  }

  protected abstract <T extends PizzaBuilder<T>> PizzaBuilder<T> returnBuilder();

  public ObservablePizza build() {
    return null;
  }

  public <T extends PizzaBuilder<T>> PizzaBuilder<T> leftHalfCheese() {
    return null;
  }
}
