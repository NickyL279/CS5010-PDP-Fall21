package test;


import org.junit.Before;
import org.junit.Test;

import polynomial.Polynomial;
import polynomial.PolynomialImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Class that tests the polynomial.
 */
public class PolynomialTest {
  Polynomial polynomial;
  Polynomial polynomial1;
  Polynomial polynomial2;

  @Before
  public void setup() {
    polynomial = new PolynomialImpl("4x^3 +3x^1 -5");
    polynomial2 = new PolynomialImpl("+3x^4 -2x^5 -5 -2x^4 +11x^1");
    polynomial1 = new PolynomialImpl();

  }

  @Test
  public void testToString() {
    assertEquals("4x^3 +3x^1 -5", polynomial.toString());
    assertEquals("0", polynomial1.toString());
  }

  @Test
  public void testToString1() {
    Polynomial poly = new PolynomialImpl("");
    assertEquals("0", poly.toString());

  }

  @Test(expected = IllegalArgumentException.class)
  public void testToString2() {
    Polynomial poly = new PolynomialImpl(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testToString3() {
    Polynomial poly = new PolynomialImpl("4x^-3 +3x^1 -5");
  }

  @Test
  public void testToString4() {
    Polynomial poly = new PolynomialImpl("1x^3");
    assertEquals("1x^3", poly.toString());
  }

  @Test
  public void testToString5() {
    Polynomial poly = new PolynomialImpl("2x^6 +3x^6 -2x^5 -7 -2x^5 +11x^1 +5x^9");
    assertEquals("5x^9 +5x^6 -4x^5 +11x^1 -7", poly.toString());
  }

  @Test
  public void testAddTerm() {
    polynomial.addTerm(4, 3);
    polynomial.addTerm(4, 1);
    polynomial.addTerm(-4, 6);
    polynomial.addTerm(4, 2);
    polynomial.addTerm(4, 0);
    assertEquals("-4x^6 +8x^3 +4x^2 +7x^1 -1", polynomial.toString());
  }

  @Test
  public void testAddTerm1() {
    polynomial1.addTerm(1, 0);
    assertEquals("1", polynomial1.toString());
    polynomial1.addTerm(0, 6);
    assertEquals("1", polynomial1.toString());
  }

  @Test
  public void testAddTerm2() {
    polynomial1.addTerm(-7, 2);
    assertEquals("-7x^2", polynomial1.toString());
  }

  @Test
  public void testAddTerm3() {
    polynomial1.addTerm(5, 0);
    assertEquals("5", polynomial1.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddTermInvalid() {
    polynomial1.addTerm(-1, -1);
  }

  @Test
  public void testGetDegree() {
    assertEquals(5, polynomial2.getDegree());
  }

  @Test
  public void testGetDegree1() {
    assertEquals(0, polynomial1.getDegree());
  }

  @Test
  public void testGetCoefficient() {
    assertEquals(0, polynomial.getCoefficient(5));
    assertEquals(4, polynomial.getCoefficient(3));
    assertEquals(3, polynomial.getCoefficient(1));
    assertEquals(-5, polynomial.getCoefficient(0));
  }

  @Test
  public void testEvaluate() {
    assertEquals(2.0, polynomial.evaluate(1.0), 0.001);
    assertEquals(112.0, polynomial.evaluate(3.0), 0.001);
    assertEquals(13.0, polynomial.evaluate(1.5), 0.001);
    assertEquals(-5.0, polynomial.evaluate(0), 0.001);
    assertEquals(-1753.0, polynomial2.evaluate(4), 0.001);
    assertEquals(0.0, polynomial1.evaluate(4), 0.001);
    assertEquals(-4615.371700326401, polynomial2.evaluate(4.82), 0.001);
  }

  @Test
  public void testAdd() {
    Polynomial p = new PolynomialImpl("2x^6 +3x^4 -2x^5 -7 -2x^4 +11x^1 +5x^9");
    Polynomial po1 = polynomial.add(p);
    assertEquals("5x^9 +2x^6 -2x^5 +1x^4 +4x^3 +14x^1 -12", po1.toString());
  }

  @Test
  public void testAdd1() {
    Polynomial py = new PolynomialImpl("2x^6 +3x^4 -2x^5 -7 -2x^4 +11x^1 +5x^9");
    Polynomial py1 = new PolynomialImpl("-2x^6 -3x^4 +2x^5 +7 +2x^4 -11x^1 -5x^9");
    Polynomial po1 = py.add(py1);
    assertEquals("0", po1.toString());
  }

  @Test
  public void testAdd2() {
    Polynomial py = new PolynomialImpl("2x^6 +3x^4 -2x^5");
    Polynomial py1 = new PolynomialImpl("2x^7 +3x^8 -2x^9");
    Polynomial po1 = py.add(py1);
    assertEquals("-2x^9 +3x^8 +2x^7 +2x^6 -2x^5 +3x^4", po1.toString());
  }

  @Test
  public void testAdd3() {
    Polynomial py = new PolynomialImpl("2x^6 +3x^4 -2x^5");
    Polynomial py1 = new PolynomialImpl();
    Polynomial po1 = py.add(py1);
    assertEquals("2x^6 -2x^5 +3x^4", po1.toString());
  }



  @Test
  public void testDegree() {
    Polynomial p = new PolynomialImpl("2x^134 +3x^4 -2x^5 -7 -2x^4 +11x^1 +5x^9");
    assertEquals(134, p.getDegree());
  }

  @Test
  public void testDegree1() {
    Polynomial p = new PolynomialImpl();
    assertEquals(0, p.getDegree());
  }

  @Test
  public void testIsSame() {
    Polynomial polynomial3 = new PolynomialImpl("4x^3 +3x^1 -5 -2x^3 +4x^1");
    Polynomial polynomial4 = new PolynomialImpl("2x^3 +7x^1 -5");
    assertTrue(polynomial3.isSame(polynomial4));
    assertTrue(polynomial4.isSame(polynomial3));
  }

  @Test
  public void testIsSame1() {
    Polynomial polynomial3 = new PolynomialImpl("5 -5");
    Polynomial polynomial4 = new PolynomialImpl("1 -1");
    assertTrue(polynomial3.isSame(polynomial4));
    assertTrue(polynomial4.isSame(polynomial3));
  }

  @Test
  public void testIsSame2() {
    Polynomial polynomial3 = new PolynomialImpl();
    Polynomial polynomial4 = new PolynomialImpl();
    assertTrue(polynomial3.isSame(polynomial4));
  }

  @Test
  public void testIsSame3() {
    Polynomial polynomial3 = new PolynomialImpl("3x^4 +4x^3");
    Polynomial polynomial4 = new PolynomialImpl("5x^5 +6x^6");
    assertFalse(polynomial3.isSame(polynomial4));
  }

  @Test
  public void testPolynomial() {
    Polynomial p9 = new PolynomialImpl();
    assertEquals(p9.toString(), "0");
    p9.addTerm(5,0);
    p9.addTerm(4,2);
    p9.addTerm(7,1);
    p9.addTerm(123,345);
    p9.addTerm(567,678);
    assertEquals(p9.toString(), "567x^678 +123x^345 +4x^2 +7x^1 +5");
    assertEquals(5, p9.getCoefficient(0));
    assertEquals(7, p9.getCoefficient(1));
    assertEquals(4, p9.getCoefficient(2));
    assertEquals(123, p9.getCoefficient(345));
    assertEquals(567, p9.getCoefficient(678));
    assertEquals(678, p9.getDegree());
    assertEquals(5.0, p9.evaluate(0), 0.001);
    assertEquals(446.0, p9.evaluate(-1), 0.001);
    Polynomial p8 = new PolynomialImpl("4x^45 +0 +5x^43 +6x^67 +6x^48 +3x^43");
    Polynomial p6 = new PolynomialImpl();
    Polynomial p11 = p9.add(p8);
    Polynomial p12 = p11.add(p6);
    assertEquals("567x^678 +123x^345 +6x^67 +6x^48 +4x^45 +8x^43 +4x^2 +7x^1 +5", p12.toString());
  }
}
