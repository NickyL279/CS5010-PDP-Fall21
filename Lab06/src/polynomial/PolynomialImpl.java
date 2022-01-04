package polynomial;

import java.util.Scanner;

/**
 * This represents a polynomial which consists of terms.
 */
public class PolynomialImpl implements Polynomial {
  private ListOfTerm head;

  /**
   * Construct a polynomial object.
   */
  public PolynomialImpl() {
    head = new TermEmptyNode();
  }

  /**
   * Construct a polynomial object that has terms.
   *
   * @param input the polynomial input.
   * @throws IllegalArgumentException if power of a term is negetive.
   */
  public PolynomialImpl(String input) {
    if (input == null) {
      throw new IllegalArgumentException("Input cannot be null");
    }
    head = new TermEmptyNode();
    Scanner scanInput = new Scanner(input);
    while (scanInput.hasNext()) {
      int coe;
      int pow;
      String termString = scanInput.next();
      if (termString.contains("x")) {
        coe = Integer.parseInt(termString.substring(0, termString.indexOf("x")));
        pow = Integer.parseInt(termString.substring(termString.indexOf("x") + 2));
      } else {
        coe = Integer.parseInt(termString);
        pow = 0;
      }
      if (pow < 0) {
        throw new IllegalArgumentException("Power cannot be lower than 0");
      }
      if (coe != 0) {
        addTerm(coe, pow);
      }
    }
  }

  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    if (!(other instanceof PolynomialImpl)) {
      throw new IllegalArgumentException("other is not a polynomial");
    }
    Polynomial mergedPoly = new PolynomialImpl();
    for (int i = 0; i <= this.getDegree(); i++) {
      if (this.getCoefficient(i) != 0) {
        mergedPoly.addTerm(this.getCoefficient(i), i);
      }
    }
    for (int j = 0; j <= other.getDegree(); j++) {
      if (other.getCoefficient(j) != 0) {
        mergedPoly.addTerm(other.getCoefficient(j), j);
      }
    }
    return mergedPoly;
  }

  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Power cannot be negative");
    }
    if (coefficient != 0) {
      Term term = new Term(coefficient, power);
      head = head.addTerm(term);
    }
  }

  @Override
  public boolean isSame(Polynomial poly) {
    if (this == poly) {
      return true;
    }
    if (!(poly instanceof PolynomialImpl)) {
      return false;
    }
    if (this.head.count() == ((PolynomialImpl) poly).head.count()) {
      for (int i = 0; i <= this.getDegree(); i++) {
        if (this.getCoefficient(i) != ((PolynomialImpl) poly).getCoefficient(i)) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public double evaluate(double x) {
    return head.evaluate(x);
  }

  @Override
  public int getCoefficient(int power) {
    return head.getCoefficient(power);
  }

  @Override
  public int getDegree() {
    return head.getDegree();
  }

  @Override
  public String toString() {
    String finalFunction = head.toString();
    if (!(finalFunction.equals(""))) {
      char a = finalFunction.charAt(0);
      if (a == ' ') {
        finalFunction = finalFunction.substring(1);
        if (finalFunction.equals("")) {
          return "0";
        } else {
          char c = finalFunction.charAt(0);
          if (c == '+') {
            return finalFunction.substring(1);
          }
          return finalFunction;
        }
      }
    } else {
      return "0";
    }
    return finalFunction;
  }
}
