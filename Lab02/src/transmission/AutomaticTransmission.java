package transmission;

/**
 * AutomaticTransmission represented as speedT1, speedT2, speedT3, speedT4 and speedT5.
 */
public class AutomaticTransmission implements Transmission {
  private final int speedT1;
  private final int speedT2;
  private final int speedT3;
  private final int speedT4;
  private final int speedT5;
  private int speed;
  private int gear;

  /**
   * Constructs a automatic transmission in terms of its 5 threshold speeds.
   *
   * @param speedT1 the first speed threshold
   * @param speedT2 the second speed threshold
   * @param speedT3 the third speed threshold
   * @param speedT4 the fourth speed threshold
   * @param speedT5 the fifth speed threshold
   * @throws IllegalArgumentException if any argument is negative
   */
  public AutomaticTransmission(int speedT1, int speedT2, int speedT3, int speedT4, int speedT5)
          throws IllegalArgumentException {
    if (speedT1 <= 0 | speedT2 <= 0 | speedT3 <= 0 | speedT4 <= 0 | speedT5 <= 0) {
      throw new IllegalArgumentException("Threshold has to be positive");
    }
    if (speedT2 < speedT1 | speedT3 < speedT2 | speedT4 < speedT3 | speedT5 < speedT4) {
      throw new IllegalArgumentException("Threshold is in-ordered");
    }
    this.speedT1 = speedT1;
    this.speedT2 = speedT2;
    this.speedT3 = speedT3;
    this.speedT4 = speedT4;
    this.speedT5 = speedT5;
    speed = 0;
    gear = 0;
  }

  @Override
  public String toString() {
    return String.format("Transmission (speed = %d, gear = %d)", speed, this.getGear());
  }

  @Override
  public void increaseSpeed() {
    speed += 1;
  }

  @Override
  public void decreaseSpeed() throws IllegalStateException {
    if (speed < 1) {
      throw new IllegalStateException("Speed has to be larger than 0 to decrease");
    }
    speed -= 1;
  }

  @Override
  public int getSpeed() {
    return this.speed;
  }

  @Override
  public int getGear() {
    if (speed == 0) {
      gear = 0;
    } else if (speed < speedT1) {
      gear = 1;
    } else if (speed < speedT2) {
      gear = 2;
    } else if (speed < speedT3) {
      gear = 3;
    } else if (speed < speedT4) {
      gear = 4;
    } else if (speed < speedT5) {
      gear = 5;
    } else {
      gear = 6;
    }
    return gear;
  }
}
