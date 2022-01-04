package questions;

/**
 * An abstract class that contains all of the code that is shared by all types of Questions.
 */
public abstract class AbstractQuestion implements Question {
  protected final String questionText;

  /**
   * Protected constructor for use by subclasses.
   *
   * @param questionText the question's content
   */
  protected AbstractQuestion(String questionText) throws IllegalArgumentException {
    if (questionText.isEmpty()) {
      throw new IllegalArgumentException("Question is empty!");
    }
    this.questionText = questionText;
  }

  @Override
  public String getText() {
    return questionText;
  }

  public int compareToTrueFalse(Question object) {
    return -1;
  }

  public int compareToMultipleChoice(Question object) {
    return -1;
  }

  public int compareToMultipleSelect(Question object) {
    return -1;
  }

  public int compareToLikert(Question object) {
    return 1;
  }
}
