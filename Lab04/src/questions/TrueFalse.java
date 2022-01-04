package questions;

/**
 * This class represents a True Or False question. It offers all the operations mandated by the
 * Question interface.
 */
public class TrueFalse extends AbstractQuestion {
  private final String answer;

  /**
   * Construct a TrueOrFalse object using the given center and radius.
   *
   * @param questionText the question's content
   * @param answer       the answer of this question
   */
  public TrueFalse(String questionText, String answer) throws IllegalArgumentException {
    super(questionText);
    answer = answer.trim().toLowerCase();
    if (answer.isEmpty()) {
      throw new IllegalArgumentException("Answer input is empty");
    }
    if (!(answer.equals("true") || answer.equals("false"))) {
      throw new IllegalArgumentException("Answer input is not valid");
    }
    this.answer = answer;
  }

  @Override
  public String answer(String answerInput) {
    if (answerInput.isEmpty()) {
      throw new IllegalArgumentException("Answer input is empty");
    }
    if (answerInput.trim().toLowerCase().equals(answer.trim().toLowerCase())) {
      return CORRECT;
    }
    return INCORRECT;
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof AbstractQuestion) {
      AbstractQuestion question = (AbstractQuestion) o;
      return question.compareToTrueFalse(this);
    }
    throw new IllegalArgumentException("This instance is not an AbstractQuestion");
  }

  @Override
  public int compareToTrueFalse(Question object) {
    return object.getText().compareTo(this.getText());
  }

  @Override
  public int compareToMultipleChoice(Question object) {
    return 1;
  }

  @Override
  public int compareToMultipleSelect(Question object) {
    return 1;
  }

  @Override
  public String toString() {
    return String.format("Question is: %s. True or False.", questionText);
  }
}
