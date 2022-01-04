package test;

import org.junit.Before;
import org.junit.Test;

import transmission.AutomaticTransmission;
import transmission.Transmission;

import static org.junit.Assert.assertEquals;

/**
 * Class for testing the AutomaticTransmission class.
 */
public class AutomaticTransmissionTest {
  private Transmission jeepCherokee;
  private Transmission mercedesGlc260;
  private Transmission audiA7;

  /**
   * Initiate value for test.
   * @throws Exception if there are invalid values.
   */
  @Before
  public void setUp() {
    jeepCherokee = new AutomaticTransmission(10, 15, 20, 25, 30);
    mercedesGlc260 = new AutomaticTransmission(30, 50, 80, 90, 100);
    audiA7 = new AutomaticTransmission(20, 40, 50, 70, 90);
  }

  /**
   * Test negative value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfNegative() {
    jeepCherokee = new AutomaticTransmission(-10, 15, 20, 25, 30);
    mercedesGlc260 = new AutomaticTransmission(30, 50, -80, 90, 100);
    audiA7 = new AutomaticTransmission(20, 40, 50, 70, -90);
  }

  /**
   * Test invalid order.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIfWrongOrder() {
    jeepCherokee = new AutomaticTransmission(25, 15, 20, 10, 30);
    mercedesGlc260 = new AutomaticTransmission(30, 50, 99, 90, 100);
    audiA7 = new AutomaticTransmission(20, 40, 55, 70, 90);
  }

  /**
   * Test toString method.
   */
  @Test
  public void testToString() {
    for (int i = 0; i < 2; i = i + 1) {
      jeepCherokee.increaseSpeed();
    }
    for (int j = 0; j < 50; j = j + 1) {
      mercedesGlc260.increaseSpeed();
    }
    for (int k = 0; k < 70; k = k + 1) {
      audiA7.increaseSpeed();
    }
    assertEquals("toString method success", "Transmission (speed = 2, gear = 1)",
            jeepCherokee.toString());
    assertEquals("toString method success", "Transmission (speed = 50, gear = 3)",
            mercedesGlc260.toString());
    assertEquals("toString method success", "Transmission (speed = 70, gear = 5)",
            audiA7.toString());
  }

  /**
   * Test increaseSpeed method.
   */
  @Test
  public void testIncreaseSpeed() {
    for (int i = 0; i < 20; i = i + 1) {
      jeepCherokee.increaseSpeed();
    }
    for (int i = 0; i < 50; i = i + 1) {
      mercedesGlc260.increaseSpeed();
    }
    for (int i = 0; i < 99; i = i + 1) {
      audiA7.increaseSpeed();
    }
    assertEquals("Increase speed success", 20, jeepCherokee.getSpeed());
    assertEquals("Increase speed success", 50, mercedesGlc260.getSpeed());
    assertEquals("Increase speed success", 99, audiA7.getSpeed());
  }

  /**
   * Test decreaseSpeed method.
   */
  @Test
  public void testDecreaseSpeed() {
    for (int i = 0; i < 99; i = i + 1) {
      jeepCherokee.increaseSpeed();
      mercedesGlc260.increaseSpeed();
      audiA7.increaseSpeed();
    }
    for (int i = 99; i > 50; i = i - 1) {
      jeepCherokee.decreaseSpeed();
    }
    for (int j = 99; j > 20; j = j - 1) {
      mercedesGlc260.decreaseSpeed();
    }
    for (int k = 99; k > 1; k = k - 1) {
      audiA7.decreaseSpeed();
    }
    assertEquals("Decrease speed success", 50, jeepCherokee.getSpeed());
    assertEquals("Decrease speed success", 20, mercedesGlc260.getSpeed());
    assertEquals("Decrease speed success", 1, audiA7.getSpeed());
  }

  /**
   * Test whether gear is correct when it is idle.
   */
  @Test
  public void testIdleGear() {
    assertEquals("Idle gear correct", 0, jeepCherokee.getGear());
    assertEquals("Idle gear correct", 0, mercedesGlc260.getGear());
    assertEquals("Idle gear correct", 0, audiA7.getGear());
  }

  /**
   * Test whether the speed can get to 0.
   */
  @Test
  public void decreaseSpeedToZero() {
    jeepCherokee.increaseSpeed();
    jeepCherokee.decreaseSpeed();
    mercedesGlc260.increaseSpeed();
    mercedesGlc260.decreaseSpeed();
    audiA7.increaseSpeed();
    audiA7.decreaseSpeed();
    assertEquals("Speed down to 0 success", 0, jeepCherokee.getSpeed());
    assertEquals("Speed down to 0 success", 0, mercedesGlc260.getSpeed());
    assertEquals("Speed down to 0 success", 0, audiA7.getSpeed());
  }


  /**
   * Test if speed is lower than 0.
   */
  @Test(expected = IllegalStateException.class)
  public void decreaseSpeedUnderZero() {
    jeepCherokee.decreaseSpeed();
    mercedesGlc260.decreaseSpeed();
    audiA7.decreaseSpeed();
  }

  /**
   * Test getSpeed method.
   */
  @Test
  public void testGetSpeed() {
    for (int i = 0; i < 20; i = i + 1) {
      jeepCherokee.increaseSpeed();
    }
    for (int j = 0; j < 50; j = j + 1) {
      mercedesGlc260.increaseSpeed();
    }
    for (int k = 0; k < 990; k = k + 1) {
      audiA7.increaseSpeed();
    }
    assertEquals("Speed correct", 20, jeepCherokee.getSpeed());
    assertEquals("Speed correct", 50, mercedesGlc260.getSpeed());
    assertEquals("Speed correct", 990, audiA7.getSpeed());
  }

  /**
   * Test getGear method.
   */
  @Test
  public void testGetGear() {
    for (int i = 0; i < 20; i = i + 1) {
      jeepCherokee.increaseSpeed();
    }
    for (int j = 0; j < 50; j = j + 1) {
      mercedesGlc260.increaseSpeed();
    }
    for (int k = 0; k < 990; k = k + 1) {
      audiA7.increaseSpeed();
    }
    assertEquals("Gear correct", 4, jeepCherokee.getGear());
    assertEquals("Gear correct", 3, mercedesGlc260.getGear());
    assertEquals("Gear correct", 6, audiA7.getGear());
  }
}
