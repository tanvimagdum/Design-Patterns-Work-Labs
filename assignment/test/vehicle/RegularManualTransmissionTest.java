package vehicle;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


/**
 * A JUnit test class to test methods in RegularManualTransmission class.
 */

public class RegularManualTransmissionTest {

  private ManualTransmission mt5;

  @Test
  public void testObjectCreation() {

    ManualTransmission mt1 = new RegularManualTransmission(0,4,2,6,
            4,8,6,10,8,12);

    assertEquals(1, mt1.getGear());
    assertEquals(0, mt1.getSpeed());
    assertEquals("OK: everything is OK.", mt1.getStatus());

  }


  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testLowestSpeed() {
    ManualTransmission mt0;
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Low speed limit of gear 1 must be 0.");
    mt0 = new RegularManualTransmission(1,4,2,6,
            4,8,6,10,8,12);
  }

  @Test
  public void testCompareTwoLowerSpeeds() {
    ManualTransmission mt2;
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Gear 2 cannot have greater low speed limit than gear 3.");
    mt2 = new RegularManualTransmission(0,4,5,6,
            4,8,6,10,8,12);
  }

  @Test
  public void testCompareLowerHigherSpeed() {
    ManualTransmission mt3;
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Lower speed limit cannot be greater than higher speed limit.");
    mt3 = new RegularManualTransmission(0,4,3,2,
            4,8,6,10,8,12);
  }

  @Test
  public void testOverlappingRange() {
    ManualTransmission mt4;
    thrown.expect(IllegalArgumentException.class);
    thrown.expectMessage("Speed ranges for gear are not overlapping.");
    mt4 = new RegularManualTransmission(0,4,5,6,
            7,8,8,10,8,12);
  }

  @Test
  public void testIncreaseSpeedOK() {

    ManualTransmission mt0 = new RegularManualTransmission(0,4,2,6,
            4,8,6,10,8,12);
    mt0.increaseSpeed();

    assertEquals("OK: everything is OK.", mt0.getStatus());

  }

  @Test
  public void testIncreaseSpeedGearChangeable() {
    ManualTransmission mt0 = new RegularManualTransmission(0,4,2,6,
            4,8,6,10,8,12);
    mt0.increaseSpeed();
    mt0.increaseSpeed();

    assertEquals("OK: you may increase the gear.", mt0.getStatus());

  }

  @Test
  public void testIncreaseSpeedNotChangeable() {
    ManualTransmission mt0 = new RegularManualTransmission(0,4,2,6,
            4,8,6,10,8,12);
    mt0.increaseSpeed();
    mt0.increaseSpeed();
    mt0.increaseSpeed();
    mt0.increaseSpeed();
    mt0.increaseSpeed();

    assertEquals("Cannot increase speed, increase gear first.", mt0.getStatus());

  }

  @Test
  public void testIncreaseSpeedMax() {
    ManualTransmission mt0 = new RegularManualTransmission(0,1,1,2,
            2,3,3,4,4,5);
    mt0.increaseSpeed();
    mt0.increaseGear();
    mt0.increaseSpeed();
    mt0.increaseGear();
    mt0.increaseSpeed();
    mt0.increaseGear();
    mt0.increaseSpeed();
    mt0.increaseGear();
    mt0.increaseSpeed();
    mt0.increaseSpeed();

    assertEquals("Cannot increase speed. Reached maximum speed.", mt0.getStatus());

  }

  @Test
  public void testDecreaseSpeedOK() {
    ManualTransmission mt0 = new RegularManualTransmission(0,1,1,2,
            2,3,3,4,4,5);
    mt0.increaseSpeed();
    mt0.decreaseSpeed();

    assertEquals("OK: everything is OK.", mt0.getStatus());
  }

  @Test
  public void testDecreaseSpeedGearChangeable() {
    ManualTransmission mt0 = new RegularManualTransmission(0,4,2,6,
            4,8,6,10,8,12);
    mt0.increaseSpeed();
    mt0.increaseSpeed();
    mt0.increaseSpeed();
    mt0.increaseSpeed();
    mt0.increaseGear();
    mt0.decreaseSpeed();

    assertEquals("OK: you may decrease the gear.", mt0.getStatus());
  }

  @Test
  public void testDecreaseSpeedNotChangeable() {
    ManualTransmission mt0 = new RegularManualTransmission(0,4,2,6,
            4,8,6,10,8,12);
    mt0.increaseSpeed();
    mt0.increaseSpeed();
    mt0.increaseSpeed();
    mt0.increaseSpeed();
    mt0.increaseGear();
    mt0.decreaseSpeed();
    mt0.decreaseSpeed();
    mt0.decreaseSpeed();

    assertEquals("Cannot decrease speed, decrease gear first.", mt0.getStatus());

  }

  @Test
  public void testDecreaseSpeedMin() {
    ManualTransmission mt0 = new RegularManualTransmission(0,4,2,6,
            4,8,6,10,8,12);
    mt0.decreaseSpeed();

    assertEquals("Cannot decrease speed. Reached minimum speed.", mt0.getStatus());

  }

  @Test
  public void testIncreaseGearOK() {
    ManualTransmission mt0 = new RegularManualTransmission(0,1,1,2,
            2,3,3,4,4,5);
    mt0.increaseSpeed();
    mt0.increaseGear();

    assertEquals("OK: everything is OK.", mt0.getStatus());

  }

  @Test
  public void testIncreaseGearIncreaseSpeed() {
    ManualTransmission mt0 = new RegularManualTransmission(0,1,1,2,
            2,3,3,4,4,5);
    mt0.increaseGear();

    assertEquals("Cannot increase gear, increase speed first.", mt0.getStatus());

  }

  @Test
  public void testIncreaseGearMax() {
    ManualTransmission mt0 = new RegularManualTransmission(0,1,1,2,
            2,3,3,4,4,5);
    mt0.increaseSpeed();
    mt0.increaseGear();
    mt0.increaseSpeed();
    mt0.increaseGear();
    mt0.increaseSpeed();
    mt0.increaseGear();
    mt0.increaseSpeed();
    mt0.increaseGear();
    mt0.increaseGear();

    assertEquals("Cannot increase gear. Reached maximum gear.", mt0.getStatus());

  }

  @Test
  public void testDecreaseGearOK() {
    ManualTransmission mt0 = new RegularManualTransmission(0,1,1,2,
            2,3,3,4,4,5);
    mt0.increaseSpeed();
    mt0.increaseGear();
    mt0.decreaseGear();

    assertEquals("OK: everything is OK.", mt0.getStatus());

  }

  @Test
  public void testDecreaseGearDecreaseSpeed() {
    ManualTransmission mt0 = new RegularManualTransmission(0,1,1,2,
            2,3,3,4,4,5);
    mt0.increaseSpeed();
    mt0.increaseGear();
    mt0.increaseSpeed();
    mt0.decreaseGear();

    assertEquals("Cannot decrease gear, decrease speed first.", mt0.getStatus());

  }

  @Test
  public void testDecreaseGearMin() {
    ManualTransmission mt0 = new RegularManualTransmission(0,1,1,2,
            2,3,3,4,4,5);
    mt0.decreaseGear();

    assertEquals("Cannot decrease gear. Reached minimum gear.", mt0.getStatus());

  }


}