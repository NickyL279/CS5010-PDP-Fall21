import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the Book class.
 */
public class BookTest {
  private Book book1;
  private Person john;

  @Before
  public void setUp() {
    book1 = new Book("alg", john, 50);
  }

  @Test
  public void testName() {
    assertEquals("alg", book1.getTitle());

  }

  @Test
  public void testAuthor() {
    assertEquals(john, book1.getAuthor());
  }

  @Test
  public void testPrice() {
    assertEquals(50, book1.getPrice(), 0.0001);
  }

}