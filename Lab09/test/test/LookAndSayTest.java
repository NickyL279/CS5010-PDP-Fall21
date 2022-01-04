package test;

import org.junit.Before;
import org.junit.Test;
import java.math.BigInteger;
import java.util.NoSuchElementException;
import lookandsay.LookAndSayIterator;
import lookandsay.RIterator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Represents a class that tests all the post situations of the Look and Say class.
 */
public class LookAndSayTest {
  RIterator<BigInteger> consOne;
  RIterator<BigInteger> consTwo;
  RIterator<BigInteger> consThree;

  @Before
  public void setup() {
    consOne = new LookAndSayIterator();
    consTwo = new LookAndSayIterator(new BigInteger("112321"));
    consThree = new LookAndSayIterator(new BigInteger("112321"), new BigInteger("9".repeat(100)));
  }

  @Test
  public void testConstructor1() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("112321"), new BigInteger("9"
            .repeat(100)));
    assertEquals("Current 112321, Previous 112321, End 99999999999999999999999999999999999999" +
            "99999999999999999999999999999999999999999999999999999999999999.", r.toString());
  }

  @Test
  public void testConstructor2() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("112321"));
    assertEquals("Current 112321, Previous 112321, End 99999999999999999999999999999999999999" +
            "99999999999999999999999999999999999999999999999999999999999999.", r.toString());
  }

  @Test
  public void testConstructor3() {
    RIterator<BigInteger> r = new LookAndSayIterator();
    assertEquals("Current 1, Previous 1, End 99999999999999999999999999999999999999" +
            "99999999999999999999999999999999999999999999999999999999999999.", r.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor1Invalid1() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("112021"), new BigInteger("9".
            repeat(100)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor1Invalid2() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("112021"), new BigInteger("9".
            repeat(5)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor1Invalid3() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("-111"), new BigInteger("9".
            repeat(5)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2Invalid1() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("112021"));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2Invalid2() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("9".repeat(101)));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2Invalid3() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("-111"));
  }

  @Test
  public void testConstructor1HasPre() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("112321"), new BigInteger("9".
            repeat(100)));
    assertTrue(r.hasPrevious());
  }

  @Test
  public void testConstructor1HasPre1() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("1"), new BigInteger("9".
            repeat(100)));
    assertFalse(r.hasPrevious());
  }

  @Test
  public void testConstructor2HasPre() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("112321"));
    assertTrue(r.hasPrevious());
  }

  @Test
  public void testConstructor2HasPre1() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("1"));
    assertFalse(r.hasPrevious());
  }

  @Test
  public void testConstructor3HasPre() {
    RIterator<BigInteger> r = new LookAndSayIterator();
    assertFalse(r.hasPrevious());
  }

  @Test
  public void testConstructor1Pre() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("112321"), new BigInteger("9".
            repeat(100)));
    assertEquals(new BigInteger("13311"), r.prev());
  }

  @Test
  public void testConstructor1Pre1() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("9".repeat(100)),
            new BigInteger("9".repeat(101)));
    assertFalse(r.hasPrevious());
  }

  @Test
  public void testConstructor1Pre2() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("94124214315351513341513513" +
            "516136161613613613513513516135161613613616"), new BigInteger("9".repeat(100)));
    assertFalse(r.hasPrevious());
  }

  @Test
  public void testConstructor2Pre() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("112321"));
    assertEquals(new BigInteger("13311"), r.prev());
  }

  @Test(expected = NoSuchElementException.class)
  public void testConstructor2PreInvalid() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("121"));
    r.prev();
  }

  @Test(expected = NoSuchElementException.class)
  public void testConstructor3Pre() {
    RIterator<BigInteger> r = new LookAndSayIterator();
    r.prev();
  }

  @Test
  public void testConstructor1HasNext() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("112321"), new BigInteger("9".
            repeat(100)));
    assertTrue(r.hasNext());
  }

  @Test
  public void testConstructor1HasNext2() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("998"), new BigInteger("999"));
    r.next();
    assertFalse(r.hasNext());
  }

  @Test
  public void testConstructor2HasNext() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("112321"));
    assertTrue(r.hasNext());
  }


  @Test
  public void testConstructor3HasNext() {
    RIterator<BigInteger> r = new LookAndSayIterator();
    assertTrue(r.hasNext());
  }

  @Test
  public void testConstructor1Next() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("112321"), new BigInteger("9".
            repeat(100)));
    assertEquals(new BigInteger("112321"), r.next());
  }

  @Test(expected = NoSuchElementException.class)
  public void testConstructor1NextInvalid1() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("998"), new BigInteger("999"));
    r.next();
    r.next();
  }

  @Test
  public void testConstructor2Next() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("112321"));
    assertEquals(new BigInteger("112321"), r.next());
  }

  @Test
  public void testConstructor3Next() {
    RIterator<BigInteger> r = new LookAndSayIterator();
    assertEquals(new BigInteger("1"), r.next());
  }

  @Test
  public void testNextValid() {
    RIterator<BigInteger> r = new LookAndSayIterator(new BigInteger("112321"), new BigInteger("9".
            repeat(100)));
    assertEquals(new BigInteger("112321"), r.next());
    assertEquals(new BigInteger("2112131211"), r.next());
    assertEquals(new BigInteger("1221121113111221"), r.next());
    assertEquals(new BigInteger("112221123113312211"), r.next());
  }

}
