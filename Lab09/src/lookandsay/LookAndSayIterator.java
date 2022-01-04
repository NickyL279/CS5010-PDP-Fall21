package lookandsay;

import java.math.BigInteger;
import java.util.NoSuchElementException;

/**
 * Represents a class that produces the look-and-say sequence which is a sequence of numbers. A
 * look-and-say sequence has previous and next element.
 */
public class LookAndSayIterator implements RIterator<BigInteger> {
  private static final BigInteger DEFAULT_SEED = new BigInteger("1");
  private static final BigInteger DEFAULT_END = new BigInteger("9".repeat(100));
  private final BigInteger end;
  private BigInteger cur;
  private BigInteger prev;

  /**
   * Construct a LookAndSayIterator using two parameters which sets the start and the end.
   *
   * @param seed the starting value.
   * @param end  the ending value.
   * @throws IllegalArgumentException if the seed is  a non-positive.
   * @throws IllegalArgumentException if the seed is greater than the end value.
   * @throws IllegalArgumentException if the seed has any zeroes in it.
   */
  public LookAndSayIterator(BigInteger seed, BigInteger end) {
    if (seed.compareTo(new BigInteger("0")) < 0) {
      throw new IllegalArgumentException("The seed is not positive.");
    }
    if (seed.compareTo(end) >= 0) {
      throw new IllegalArgumentException("The seed is not less than the end.");
    }
    if (seed.toString().contains("0")) {
      throw new IllegalArgumentException("The seed should not has any zeroes in it.");
    }
    this.end = end;
    this.cur = seed;
    this.prev = seed;
  }

  /**
   * Construct a LookAndSayIterator using one parameter which sets the start. And set the end as
   * default.
   *
   * @param seed the starting value.
   * @throws IllegalArgumentException if the seed is  a non-positive.
   * @throws IllegalArgumentException if the seed is greater than the end value.
   * @throws IllegalArgumentException if the seed has any zeroes in it.
   */
  public LookAndSayIterator(BigInteger seed) {
    //    if (seed.compareTo(new BigInteger("0")) < 0) {
    //      throw new IllegalArgumentException("The seed is not positive.");
    //    }
    //    if (seed.compareTo(new BigInteger("9".repeat(100))) >= 0) {
    //      throw new IllegalArgumentException("The seed is not less than the end.");
    //    }
    //    if (seed.toString().contains("0")) {
    //      throw new IllegalArgumentException("The seed should not has any zeroes in it.");
    //    }
    //    this.end = new BigInteger("9".repeat(100));
    //    this.cur = seed;
    //    this.prev = seed;
    this(seed, DEFAULT_END);
  }

  /**
   * Construct a LookAndSayIterator using no parameter which sets the start. And set the end as
   * default.
   */
  public LookAndSayIterator() {
    //    this.end = new BigInteger("9".repeat(100));
    //    this.cur = new BigInteger("1");
    //    this.prev = new BigInteger("1");
    this(DEFAULT_SEED, DEFAULT_END);
  }


  @Override
  public BigInteger prev() throws NoSuchElementException {
    if (!hasPrevious()) {
      throw new NoSuchElementException("No previous value in the sequence");
    }
    cur = prev;
    prev = getPrev(prev);
    return prev;
  }

  private BigInteger getPrev(BigInteger b) {
    StringBuilder sb = new StringBuilder();
    char[] num = b.toString().toCharArray();
    for (int i = 1; i < num.length; i += 2) {
      String tmp = String.valueOf(num[i]).
              repeat(Integer.parseInt(String.valueOf(num[i - 1])));
      sb.append(tmp);
    }
    return new BigInteger(sb.toString());
  }

  @Override
  public boolean hasPrevious() {
    if (prev.toString().length() % 2 == 0) {
      if (getPrev(prev).compareTo(end) >= 0) {
        return false;
      } else {
        return prev.compareTo(new BigInteger("1")) >= 0;
      }
    } else {
      return false;
    }
  }

  @Override
  public boolean hasNext() {
    return cur.compareTo(end) <= 0;
  }

  @Override
  public BigInteger next() {
    if (!hasNext()) {
      throw new NoSuchElementException("No next value in the sequence");
    }
    prev = cur;
    cur = getNext();
    return prev;
  }

  private BigInteger getNext() {
    StringBuilder sb = new StringBuilder();
    int cnt = 1;
    char say = this.cur.toString().charAt(0);
    for (int i = 1; i < cur.toString().length(); i++) {
      if (this.cur.toString().charAt(i) != say) {
        sb.append(cnt).append(say);
        cnt = 1;
        say = this.cur.toString().charAt(i);
      } else {
        cnt++;
      }
    }
    sb.append(cnt).append(say);
    return new BigInteger(sb.toString());
  }

  @Override
  public String toString() {
    return String.format("Current %s, Previous %s, End %s.", cur, prev, end);
  }
}
