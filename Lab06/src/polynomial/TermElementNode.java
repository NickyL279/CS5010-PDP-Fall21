package polynomial;

/**
 * This represents a polynomial's element's node.
 */
public class TermElementNode implements ListOfTerm {
  private Term term;
  private ListOfTerm rest;

  /**
   * Construct a element node of polynomial that has terms.
   *
   * @param term the term of polynomial.
   * @param rest the rest terms of polynomial.
   */
  public TermElementNode(Term term, ListOfTerm rest) {
    this.term = term;
    this.rest = rest;
  }

  @Override
  public int count() {
    return 1 + this.rest.count();
  }

  @Override
  public ListOfTerm addTerm(Term p) {
    if (this.term.getPower() == p.getPower()) {
      this.term.setCoefficient(p.getCoefficient());
      if (this.term.getCoefficient() == 0) {
        return this.rest;
      }
      return this;
    } else if (this.term.getPower() > p.getPower()) {
      return new TermElementNode(this.term, this.rest.addTerm(p));
    } else {
      return new TermElementNode(p, this);
    }
  }

  @Override
  public int getDegree() {
    return this.term.getPower();
  }

  @Override
  public int getCoefficient(int power) {
    if (this.term.getPower() == power) {
      return this.term.getCoefficient();
    } else {
      return this.rest.getCoefficient(power);
    }
  }

  @Override
  public double evaluate(double x) {
    return this.term.evaluate(x) + this.rest.evaluate(x);
  }

  @Override
  public Term getTerm() {
    return this.term;
  }

  @Override
  public String toString() {
    return term.toString() + this.rest.toString();
  }
}
