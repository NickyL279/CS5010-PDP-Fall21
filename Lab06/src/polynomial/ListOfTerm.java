package polynomial;

/**
 * This interface represents all the operations to be supported by a list of terms.
 */
public interface ListOfTerm {
  /**
   * Return the number of terms in this list.
   *
   * @return the size of this list
   */
  int count();

  /**
   * Return a polynomial after adding a term to it.
   *
   * @param term term to be added to current polynomial.
   * @return the polynomial added a term in.
   */
  ListOfTerm addTerm(Term term);

  /**
   * Return the degree of the polynomial.
   *
   * @return the degree of the Polynomial.
   */
  int getDegree();

  /**
   * Return the coefficient of a term chosen by a given power.
   *
   * @param power the power of the term.
   * @return the coefficient of a term.
   */
  int getCoefficient(int power);

  /**
   * Evaluate the value of this polynomial at the given value of the variable.
   *
   * @param x the value at which the polynomial is to be evaluated.
   * @return the value of the polynomial at x
   */
  double evaluate(double x);

  /**
   * Returns the term of the current node.
   *
   * @return the term of the current node.
   */
  Term getTerm();

  //  /**
  //   * Adds the current and p1 PolynomialListNodes to p.
  //   * @param p The Polynomial that will have the result.
  //   * @param p1 The PolynomialListNode to be added to the current node.
  //   * @return p , The result of the addition.
  //   */
  //  ListofTerm addPolynomial(Polynomial p, ListofTerm p1);
}
