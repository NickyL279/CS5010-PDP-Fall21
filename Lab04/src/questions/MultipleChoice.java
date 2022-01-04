package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Multiple Choice question. It offers all the operations mandated by the
 * Question interface.
 */
public class MultipleChoice extends AbstractQuestion {
  private final String answer;
  private List<String> options;

  /**
   * Construct a TrueOrFalse object using the given center and radius.
   *
   * @param questionText the question's content
   * @param answerInput  the answer of this question
   * @param optionsInput the options of this question
   */
  public MultipleChoice(String questionText, String answerInput, String... optionsInput)
          throws IllegalArgumentException {
    super(questionText);
    answerInput = answerInput.trim().toLowerCase();
    if (optionsInput.length < 3 || optionsInput.length > 8) {
      throw new IllegalArgumentException("Options cannot be less than 3 or greater than 8.");
    }
    if (answerInput.isEmpty()) {
      throw new IllegalArgumentException("Answer input is empty");
    }
    options = new ArrayList<>();
    for (String ops : optionsInput) {
      if (ops.trim().isEmpty()) {
        throw new IllegalArgumentException("Options contain empty content");
      }
      options.add(ops.trim().toLowerCase());
    }
    this.answer = answerInput;
    try {
      options.contains(optionsInput[Integer.parseInt(answerInput) - 1]);
    } catch (Exception e) {
      throw new IllegalArgumentException("The answer is not a option");
    }
  }

  @Override
  public String answer(String answerInput) {
    if (answerInput.isEmpty()) {
      throw new IllegalArgumentException("Answer input is empty");
    }
    if (answerInput.trim().toLowerCase().equals(answer)) {
      return CORRECT;
    }
    return INCORRECT;
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof AbstractQuestion) {
      AbstractQuestion question = (AbstractQuestion) o;
      return question.compareToMultipleChoice(this);
    }
    throw new IllegalArgumentException("This instance is not an AbstractQuestion");
  }

  @Override
  public int compareToMultipleChoice(Question object) {
    return object.getText().compareTo(this.getText());
  }

  @Override
  public int compareToMultipleSelect(Question object) {
    return 1;
  }

  @Override
  public String toString() {
    return String.format("Question is: %s. Options are: %s.", questionText, options);
  }
}


