package vehicle;

/**
 * A RegularManualTransmission class to define the methods
 * to change gears and speed of a vehicle.
 */

public class RegularManualTransmission implements ManualTransmission {

  /**
   * RegularManualTransmission class implements ManualTransmission interface.
   * It defines a minimum and maximum speed value for each of the 5 gears.
   * It defines variables for storing current speed,
   * current gear and the current status of the vehicle.
   */

  private int l1;
  private int l2;
  private int l3;
  private int l4;
  private int l5;

  private int h1;
  private int h2;
  private int h3;
  private int h4;
  private int h5;

  private int currSpeed;
  private int currGear;

  private String status;

  /**
   * Construct a RegularManualTransmission object
   * that takes minimum and maximum values of speed for each gear.
   * @param l1 minimum speed at gear 1
   * @param h1 maximum speed at gear 1
   * @param l2 minimum speed at gear 2
   * @param h2 maximum speed at gear 2
   * @param l3 minimum speed at gear 3
   * @param h3 maximum speed at gear 3
   * @param l4 minimum speed at gear 4
   * @param h4 maximum speed at gear 4
   * @param l5 minimum speed at gear 5
   * @param h5 maximum speed at gear 5
   */

  public RegularManualTransmission(int l1, int h1,
                                   int l2, int h2,
                                   int l3, int h3,
                                   int l4, int h4,
                                   int l5, int h5) {

    this.currSpeed = l1;
    this.currGear = 1;
    this.status = "OK: everything is OK.";

    this.l1 = Math.abs(l1);
    this.h1 = Math.abs(h1);
    this.l2 = Math.abs(l2);
    this.h2 = Math.abs(h2);
    this.l3 = Math.abs(l3);
    this.h3 = Math.abs(h3);
    this.l4 = Math.abs(l4);
    this.h4 = Math.abs(h4);
    this.l5 = Math.abs(l5);
    this.h5 = Math.abs(h5);


    if (this.l1 != 0) {
      throw new IllegalArgumentException("Low speed limit of gear 1 must be 0.");
    }

    if (this.l2 > this.l3) {
      throw new IllegalArgumentException("Gear 2 cannot have greater low speed limit than gear 3.");
    }

    if (this.l3 > this.l4) {
      throw new IllegalArgumentException("Gear 3 cannot have greater low speed limit than gear 4.");
    }

    if (this.l4 > this.l5) {
      throw new IllegalArgumentException("Gear 4 cannot have greater low speed limit than gear 5.");
    }

    if (this.l1 > this.h1
           || this.l2 > this.h2
           || this.l3 > this.h3
           || this.l4 > this.h4
           || this.l5 > this.h5) {
      throw new IllegalArgumentException("Lower speed limit cannot be " +
              "greater than higher speed limit.");
    }

    if ((!((this.l2 <= this.h1) && (this.l2 > this.l1)))
            || (!((this.l3 <= this.h2) && (this.l3 > this.l2)))
            || (!((this.l4 <= this.h3) && (this.l4 > this.l3)))
            || (!((this.l5 <= this.h4) && (this.l5 > this.l4)))) {
      throw new IllegalArgumentException("Speed ranges for gear are not overlapping.");
    }

  }

  @Override
  public String getStatus() {
    return this.status;
  }

  @Override
  public int getSpeed() {
    return this.currSpeed;
  }

  @Override
  public int getGear() {
    return this.currGear;
  }

  @Override
  public ManualTransmission increaseSpeed() {

    if (this.currSpeed == h5) {
      this.status = "Cannot increase speed. Reached maximum speed.";
      return this;
    }

    if ((this.currGear == 1 && this.currSpeed >= h1)
           || (this.currGear == 2 && this.currSpeed >= h2)
           || (this.currGear == 3 && this.currSpeed >= h3)
           || (this.currGear == 4 && this.currSpeed >= h4)) {
      this.status = "Cannot increase speed, increase gear first.";
      return this;
    }

    this.currSpeed += 1;

    if ((this.currGear == 1 && this.currSpeed >= l2 && this.currSpeed <= h1)
            || (this.currGear == 2 && this.currSpeed >= l3 && this.currSpeed <= h2)
            || (this.currGear == 3 && this.currSpeed >= l4 && this.currSpeed <= h3)
            || (this.currGear == 4 && this.currSpeed >= l5 && this.currSpeed <= h4)) {
      this.status = "OK: you may increase the gear.";
      return this;
    }

    this.status = "OK: everything is OK.";
    return this;
  }

  @Override
  public ManualTransmission decreaseSpeed() {

    if (this.currSpeed == 0) {
      this.status = "Cannot decrease speed. Reached minimum speed.";
      return this;
    }

    if ((this.currGear == 2 && this.currSpeed <= l2)
            || (this.currGear == 3 && this.currSpeed <= l3)
            || (this.currGear == 4 && this.currSpeed <= l4)
            || (this.currGear == 5 && this.currSpeed <= l5)) {
      this.status = "Cannot decrease speed, decrease gear first.";
      return this;
    }

    this.currSpeed -= 1;

    if ((this.currGear == 2 && this.currSpeed > l2 && this.currSpeed < h1)
            || (this.currGear == 3 && this.currSpeed > l3 && this.currSpeed < h2)
            || (this.currGear == 4 && this.currSpeed > l4 && this.currSpeed < h3)
            || (this.currGear == 5 && this.currSpeed > l5 && this.currSpeed < h4)) {
      this.status = "OK: you may decrease the gear.";
      return this;
    }

    this.status = "OK: everything is OK.";
    return this;
  }

  @Override
  public ManualTransmission increaseGear() {

    if (this.currGear == 5) {
      this.status = "Cannot increase gear. Reached maximum gear.";
      return this;
    }

    if ((this.currSpeed < l2 && this.currGear == 1)
            || (this.currSpeed < l3 && this.currGear == 2)
            || (this.currSpeed < l4 && this.currGear == 3)
            || (this.currSpeed < l5 && this.currGear == 4) ) {
      this.status = "Cannot increase gear, increase speed first.";
      return this;
    }

    this.currGear += 1;
    this.status = "OK: everything is OK.";
    return this;
  }

  @Override
  public ManualTransmission decreaseGear() {

    if (this.currGear == 1) {
      this.status = "Cannot decrease gear. Reached minimum gear.";
      return this;
    }

    if ((this.currSpeed > h1 && this.currGear == 2)
            || (this.currSpeed > h2 && this.currGear == 3)
            || (this.currSpeed > h3 && this.currGear == 4)
            || (this.currSpeed > h4 && this.currGear == 5) ) {
      this.status = "Cannot decrease gear, decrease speed first.";
      return this;
    }

    this.currGear -= 1;
    this.status = "OK: everything is OK.";
    return this;
  }

}
