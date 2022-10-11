package vehicle;

/**
 * A ManualTransmission interface that offers methods
 * to change the gears and speed of a vehicle
 * and to get current speed, current gear and current status of the vehicle.
 */

public interface ManualTransmission {

  public String getStatus();

  public int getSpeed();

  public int getGear();

  public ManualTransmission increaseSpeed();

  public ManualTransmission decreaseSpeed();

  public ManualTransmission increaseGear();

  public ManualTransmission decreaseGear();

}
