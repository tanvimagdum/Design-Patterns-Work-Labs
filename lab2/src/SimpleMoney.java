import org.jetbrains.annotations.NotNull;

/**
 * A class to define simple money additions.
 */


public class SimpleMoney implements Money {

  /**
   * SimpleMoney class implements Money interface.
   * It contains following variables.
   * @param dollar stores the entered dollar value
   * @param cent stores the entered cent value
   */

  private int dollar;
  private int cent;

  /**
   * Construct a SimpleMoney object that takes dollar and cent values.
   * @param dollar entered dollar value
   * @param cent entered cent value
   */

  public SimpleMoney(int dollar, int cent) {

    if (dollar < 0 || cent < 0) {
      throw new IllegalArgumentException("Dollar and cent value cannot be negative");
    }
    this.dollar = dollar;
    this.cent = cent;
  }

  /**
   * Return the dollar value.
   * @return dollar
   */

  @Override
  public int getDollar() {
    return this.dollar;
  }

  /**
   * Return the cent value.
   * @return cent
   */

  @Override
  public int getCent() {
    return this.cent;
  }

  @Override
  public Money add(@NotNull Money other) {

    if (other.getDollar() < 0 || other.getCent() < 0) {
      throw new IllegalArgumentException("Dollar and cent value cannot be negative");
    }

    this.dollar = this.dollar + other.getDollar();
    this.cent = this.cent + other.getCent();

    if (this.cent > 99) {
      this.dollar = this.dollar + (this.cent / 100);
      this.cent = this.cent % 100;
    }

    return this;

  }

  @Override
  public Money add(int dollars, int cents) {

    if (dollars < 0 || cents < 0) {
      throw new IllegalArgumentException("Dollar and cent value cannot be negative");
    }

    this.dollar = this.dollar + dollars;
    this.cent = this.cent + cents;

    if (this.cent > 99) {
      this.dollar = this.dollar + (this.cent / 100);
      this.cent = this.cent % 100;
    }

    return this;
  }

  @Override
  public double getDecimalValue() {

    double temp;

    double dollarD = this.dollar;
    double centD = this.cent;
    temp = dollarD + (centD / 100);

    return temp;
  }

  @Override
  public String toString() {

    double d = getDecimalValue();

    return "$" + String.format("%.2f",d);
  }


}