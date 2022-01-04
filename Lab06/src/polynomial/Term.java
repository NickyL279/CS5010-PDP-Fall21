package polynomial;

/**
 * This represents a term of the polynomial.
 */
public class Term {
  private int coefficient;
  private int power;

  /**
   * Constructor.
   *
   * @param coefficient the coefficient of the term.
   * @param power       the power of the term.
   */
  public Term(int coefficient, int power) {
    this.coefficient = coefficient;
    this.power = power;
  }

  /**
   * Return the coefficient of the term.
   *
   * @return the coefficient of the term.
   */
  public int getCoefficient() {
    return this.coefficient;
  }

  /**
   * Set the coefficient of the polynomial to the value after adding the new term.
   *
   * @param coefficient The coefficient added to the polynomial.
   */
  public void setCoefficient(int coefficient) {
    this.coefficient = this.coefficient + coefficient;
  }

  /**
   * Return the power of the term.
   *
   * @return the power of the term.
   */
  public int getPower() {
    return this.power;
  }

  /**
   * Return the calculation value of the term.
   *
   * @return the calculation value of the term.
   */
  public double evaluate(double x) {
    if (this.power == 0) {
      return this.coefficient;
    }
    return this.coefficient * Math.pow(x, this.power);
  }

  @Override
  public String toString() {
    if (this.power == 0 && this.coefficient > 0) {
      return (" +" + this.coefficient);
    } else if (this.power == 0) {
      return " " + this.coefficient;
    }
    if (this.coefficient > 0) {
      return (" +" + this.coefficient + "x^" + this.power);
    }
    return (" " + this.coefficient + "x^" + this.power);
  }
}
