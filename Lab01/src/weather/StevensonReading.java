package weather;

/**
 * StevensonReading represented as temperature, dew point, wind speed and total rain.
 * StevensonReading calculated to get relative humidity, heat index and wind chill.
 */
public final class StevensonReading implements WeatherReading {
  private final double temperature;
  private final double dewPoint;
  private final double windSpeed;
  private final int totalRain;

  /**
   * Constructs a stevensonReading in terms of its temperature, dew point, wind speed and total
   * rain.
   *
   * @param temperature the degree of temperature
   * @param dewPoint    the degree of dew point
   * @param windSpeed   the speed of wind
   * @param totalRain   the amount of total rain
   * @throws IllegalArgumentException if any argument is illegal
   */
  public StevensonReading(double temperature, double dewPoint, double windSpeed, int totalRain)
          throws IllegalArgumentException {
    if (temperature < -273) {
      throw new IllegalArgumentException("Temperature should not less than -273 F");
    }
    if (dewPoint > temperature) {
      throw new IllegalArgumentException("Dew point should not be greater than air temperature");
    }
    if (windSpeed < 0) {
      throw new IllegalArgumentException("Negative wind speed is not supported");
    }
    if (totalRain < 0) {
      throw new IllegalArgumentException("Negative total rain is not supported");
    }
    if ((100 - 5 * (temperature - dewPoint)) < 0) {
      throw new IllegalArgumentException("Relative humidity should be 0 - 100");
    }

    this.temperature = temperature;
    this.dewPoint = dewPoint;
    this.windSpeed = windSpeed;
    this.totalRain = totalRain;
  }

  @Override
  public int getTemperature() {
    return (int) Math.round(this.temperature);
  }

  @Override
  public int getDewPoint() {
    return (int) Math.round(this.dewPoint);
  }

  @Override
  public int getWindSpeed() {
    return (int) Math.round(this.windSpeed);
  }

  @Override
  public int getTotalRain() {
    return this.totalRain;
  }

  @Override
  public int getRelativeHumidity() {
    return (int) Math.round(100 - 5 * (temperature - dewPoint));
  }

  @Override
  public int getHeatIndex() {
    final double c1 = -8.78469475556;
    final double c2 = 1.61139411;
    final double c3 = 2.33854883889;
    final double c4 = -0.14611605;
    final double c5 = -0.012308094;
    final double c6 = -0.0164248277778;
    final double c7 = 0.002211732;
    final double c8 = 0.00072546;
    final double c9 = -0.000003582;
    double t = temperature;
    double r = 100 - 5 * (temperature - dewPoint);
    double heat = c1 + c2 * t + c3 * r + c4 * t * r + c5 * t * t
            + c6 * r * r + c7 * t * t * r + c8 * t * r * r + c9 * t * t * r * r;
    return (int) Math.round(heat);
  }

  @Override
  public int getWindChill() {
    double fah = 1.8d * temperature + 32d;
    double v = windSpeed;
    double windChill = 35.74d + 0.6215d * fah - 35.75d * Math.pow(v, 0.16d)
            + 0.4275d * fah * Math.pow(v, 0.16d);
    return (int) Math.round(windChill);
  }

  @Override
  public String toString() {
    return String.format("Reading: T = %d, D = %d, v = %d, rain = %d",
            this.getTemperature(), this.getDewPoint(), this.getWindSpeed(), totalRain);
  }

  @Override
  public boolean equals(Object o) {
    // Fast path for pointer equality:
    if (this == o) { // backward compatibility with default equals
      return true;
    }

    // If o isn't the right class then it can't be equal:
    if (!(o instanceof WeatherReading)) {
      return false;
    }

    // The successful instanceof check means our cast will succeed:
    WeatherReading that = (WeatherReading) o;

    return this.toString().equals(that.toString());
  }

  @Override
  public int hashCode() {
    return Long.hashCode((long) (temperature + dewPoint + windSpeed + totalRain));
  }
}
