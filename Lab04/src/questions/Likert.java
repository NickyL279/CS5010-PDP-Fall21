package questions;

/**
 * This class represents a Likert question. It offers all the operations mandated by the Question
 * interface.
 */
public class Likert extends AbstractQuestion {
  /**
   * Construct a TrueOrFalse object using the given center and radius.
   *
   * @param questionText the question's content
   */
  public Likert(String questionText) throws IllegalArgumentException {
    super(questionText);
  }

  @Override
  public String answer(String answerInput) {
    if (answerInput.trim().toLowerCase().isEmpty()) {
      throw new IllegalArgumentException("Answer input is empty");
    }
    if (answerInput.trim().equals("1") || answerInput.trim().equals("2") || answerInput.trim()
            .equals("3") || answerInput.trim().equals("4") || answerInput.trim().equals("5")) {
      return CORRECT;
    }
    return INCORRECT;
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof AbstractQuestion) {
      AbstractQuestion question = (AbstractQuestion) o;
      return question.compareToLikert(this);
    }
    throw new IllegalArgumentException("This instance is not an AbstractQuestion");
  }

  @Override
  public int compareToLikert(Question object) {
    return object.getText().compareTo(this.getText());
  }

  @Override
  public String toString() {
    return String.format("Question is: %s. Options are: 1.Strongly Agree, 2.Agree, 3.Neither "
            + "Agree nor Disagree, 4.Disagree, 5.Strongly Disagree.", questionText);
  }

}
