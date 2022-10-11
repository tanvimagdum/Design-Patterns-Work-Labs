import org.jetbrains.annotations.NotNull;

/**
 * An interface for adding Money.
 */

public interface Money {

  /**
   * int getDollar() returns the dollar value.
   * int getCent() returns the cent value.
   * Money add(Money) adds another Money to existing Money.
   * Money add(int,int) takes dollar and cent values from user and
   * add them to existing Money.
   * double getDecimalValue() returns the dollar and cent values in decimal format.
   */

  public int getDollar();

  public int getCent();

  public Money add(@NotNull Money other);

  public Money add(int dollars, int cents);

  public double getDecimalValue();

}
