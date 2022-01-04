package weather;

/**
 * A WeatherReading represents the data that is collected at a variety of
 * weather stations. Classes that implement this interface will vary depending
 * upon the type of weather station that does the reading.
 */
public interface WeatherReading {

  /**
   * Get the temperature of this reading rounded to the nearest integer.
   * 
   * @return the temperature
   */
  public int getTemperature();

  /**
   * Get the dew point for this reading rounded to the nearest integer.
   * 
   * @return the dew point
   */
  public int getDewPoint();

  /**
   * Get the wind speed for this reading rounded to the nearest integer.
   * 
   * @return the wind speed
   */
  public int getWindSpeed();

  /**
   * Get the total rain of this reading (in mm).
   * 
   * @return the total rain
   */
  public int getTotalRain();

  /**
   * Get the relative humidity of this weather reading rounded to the nearest
   * integer.
   * 
   * @return the relative humidity
   */
  public int getRelativeHumidity();

  /**
   * Get the heat index for this weather reading rounded to the nearest integer.
   * 
   * @return the heat index
   */
  public int getHeatIndex();

  /**
   * Get the wind chill rounded to the nearest integer.
   * 
   * @return the wind chill
   */
  public int getWindChill();

}
