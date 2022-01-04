package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import weather.StevensonReading;
import weather.WeatherReading;

/**
 * Class for testing the StevensonReading class.
 */
public class StevensonReadingTest {
  private WeatherReading testReadingFirst;

  @Before
  public void setUp() {
    testReadingFirst = tdvr(23, 12, 3, 12);
  }

  /**
   * This method is providing short-hand way of creating instances of a new StevensonReading
   * object.
   *
   * @param temperature the initial temperature.
   * @param dewPoint    the initial dewPoint
   * @param windSpeed   the initial windSpeed
   * @param totalRain   the initial totalRain
   * @return a new instance of a stevensonReading object
   */
  private WeatherReading tdvr(float temperature, float dewPoint, float windSpeed, int totalRain) {
    return new StevensonReading(temperature, dewPoint, windSpeed, totalRain);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidTemp() {
    assertEquals("Illegal Temperature",
            "Reading: T = -300, D = 12, v = 3, rain = 12", tdvr(-300, 12, 3, 12));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidDew() {
    tdvr(23, 24, 3, 12);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidWind() {
    tdvr(23, 12, -10, 12);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidRain() {
    tdvr(23, 12, 3, -12);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidHum() {
    tdvr(23, 2, 3, -12);
  }

  @Test
  public void testGetTemp() {
    assertEquals(23, testReadingFirst.getTemperature());
  }

  @Test
  public void testGetDew() {
    assertEquals(12, testReadingFirst.getDewPoint());
  }

  @Test
  public void testGetWind() {
    assertEquals(3, testReadingFirst.getWindSpeed());
  }

  @Test
  public void testGetRain() {
    assertEquals(12, testReadingFirst.getTotalRain());
  }

  @Test
  public void testGetHumidity() {
    assertEquals(45, testReadingFirst.getRelativeHumidity());
  }

  @Test
  public void testGetHeat() {
    assertEquals(25, testReadingFirst.getHeatIndex());
  }

  @Test
  public void testGetWindChill() {
    assertEquals(76, testReadingFirst.getWindChill());
  }

  @Test
  public void testAsTdvr() {
    String expectedValue = "Reading: T = 23, D = 12, v = 3, rain = 12";
    assertEquals(expectedValue, testReadingFirst.toString());
    assertEquals(expectedValue, tdvr(23.1f, 12, 3, 12).toString());
    assertEquals(expectedValue, tdvr(23, 12.1f, 3, 12).toString());
    assertEquals(expectedValue, tdvr(23, 12, 3.4f, 12).toString());
    assertEquals("Lowest temperature", "Reading: T = -273, D = -273, v = 3, rain = 12",
            tdvr(-273, -273, 3, 12).toString());
    assertEquals("Relative Humidity == 0", "Reading: T = 32, D = 12, v = 3, rain = 12",
            tdvr(32, 12, 3, 12).toString());
    assertEquals("Large Temperature with 0 wind speed", "Reading: T = 65536, D = 65516, " +
            "v = 0, rain = 12", tdvr(65536, 65516, 0, 12).toString());
    assertEquals("Large Temperature with 0 total rain", "Reading: T = 65536, D = 65516, v = 3, " +
            "rain = 0", tdvr(65536, 65516, 3, 0).toString());
    assertEquals("Large wind speed", "Reading: T = 23, D = 12, v = 60000, rain = 12",
            tdvr(23, 12, 60000, 12).toString());
    assertEquals("Large total rain", "Reading: T = 23, D = 12, v = 3, rain = 60000",
            tdvr(23, 12, 3, 60000).toString());
  }

  @Test
  public void testEqual() {
    assertTrue(testReadingFirst.equals(testReadingFirst));
    assertTrue(testReadingFirst.equals(new StevensonReading(23, 12, 3, 12)));
    assertFalse(tdvr(23, 12, 3, 12).equals((tdvr(24, 12, 3, 12))));
  }

  @Test
  public void testHashCode() {
    assertEquals(Long.hashCode(testReadingFirst.getTemperature() + testReadingFirst.getDewPoint()
                    + testReadingFirst.getWindSpeed() + testReadingFirst.getTotalRain()),
            tdvr(23, 12, 3, 12).hashCode());
  }
}
