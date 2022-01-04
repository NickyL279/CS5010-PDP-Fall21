package polynomial;

/**
 * This represents a polynomial's empty node.
 */
public class TermEmptyNode implements ListOfTerm {
  @Override
  public int count() {
    return 0;
  }

  @Override
  public ListOfTerm addTerm(Term p) {
    return new TermElementNode(p, this);
  }

  @Override
  public int getDegree() {
    return 0;
  }

  @Override
  public int getCoefficient(int power) {
    return 0;
  }

  @Override
  public double evaluate(double valueOfX) {
    return 0;
  }

  @Override
  public Term getTerm() {
    return null;
  }

  @Override
  public String toString() {
    return "";
  }

}
