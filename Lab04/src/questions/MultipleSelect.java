package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Multiple Select question. It offers all the operations mandated by the
 * Question interface.
 */
public class MultipleSelect extends AbstractQuestion {
  private final String answer;
  private List<String> options;

  /**
   * Construct a TrueOrFalse object using the given center and radius.
   *
   * @param questionText the question's content
   * @param answerInput  the answer of this question
   * @param optionsInput the options of this question
   */
  public MultipleSelect(String questionText, String answerInput, String... optionsInput)
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
    String[] answers = answerInput.split(" ");
    for (String ops : optionsInput) {
      if (ops.trim().isEmpty()) {
        throw new IllegalArgumentException("Options contain empty content");
      }
      options.add(ops.trim().toLowerCase());
    }
    try {
      for (String ans : answers) {
        options.contains(optionsInput[Integer.parseInt(ans) - 1]);
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("The answer is not a option");
    }

    this.answer = answerInput;
  }

  @Override
  public String answer(String answerInput) {
    if (answerInput.isEmpty()) {
      throw new IllegalArgumentException("Answer input is empty");
    }
    if (answerInput.replaceAll("\\s+", "").equals(answer.replaceAll("\\s+", ""))) {
      return CORRECT;
    }
    return INCORRECT;
  }

  @Override
  public int compareTo(Question o) {
    if (o instanceof AbstractQuestion) {
      AbstractQuestion question = (AbstractQuestion) o;
      return question.compareToMultipleSelect(this);
    }
    throw new IllegalArgumentException("This instance is not an AbstractQuestion");
  }

  @Override
  public int compareToMultipleSelect(Question o) {
    return o.getText().compareTo(this.getText());
  }

  @Override
  public String toString() {
    return String.format("Question is: %s. Options are: %s.", questionText, options);
  }

}
