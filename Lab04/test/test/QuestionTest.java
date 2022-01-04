package test;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import questions.Likert;
import questions.MultipleChoice;
import questions.MultipleSelect;
import questions.Question;
import questions.TrueFalse;

import static org.junit.Assert.assertEquals;

/**
 * This class contains all the unit tests for various kinds of questions.
 */
public class QuestionTest {
  Question question1;
  Question question2;
  Question question3;
  Question question4;


  @Before
  public void setup() {
    question1 = new TrueFalse("Did you enrolled the CS 5010?", "true");
    question2 = new MultipleChoice("How many courses did you take this semester?",
            "2", "1", "2", "4", "7");
    question3 = new MultipleSelect("What food do you want today?", "3 4", "1", "2", "3", "4", "7");
    question4 = new Likert("Do you think this course is useful?");
  }

  @Test
  public void testLikert() {
    assertEquals("Do you think this course is useful?", question4.getText());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLikertInvalid1() {
    Question question19 = new Likert("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testLikertInvalid2() {
    question4.answer("");
  }

  @Test
  public void testLikertCorrect() {
    assertEquals("Correct", question4.answer("1"));
  }

  @Test
  public void testLikertIncorrect() {
    assertEquals("Incorrect", question4.answer("6"));
  }

  @Test
  public void testLikertToString() {
    assertEquals("Question is: Do you think this course is useful?. Options are: 1.Strongly" +
                    " Agree, 2.Agree, 3.Neither Agree nor Disagree, 4.Disagree," +
                    " 5.Strongly Disagree.",
            question4.toString());
  }

  @Test
  public void testMultiSelect() {
    assertEquals("What food do you want today?", question3.getText());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMultiSelectInvalid1() {
    Question question13 = new MultipleSelect("", "3 4", "1", "2", "3", "4", "7");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMultiSelectInvalid2() {
    Question question14 = new MultipleSelect("What food do you want today?",
            "", "1", "2", "3", "4", "7");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMultiSelectInvalid3() {
    Question question15 = new MultipleSelect("What food do you want today?",
            "3 4", "1", "2", "", "4", "7");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMultiSelectInvalid4() {
    Question question16 = new MultipleSelect("What food do you want today?",
            "3 4", "4", "7", "1", "2", "3", "5", "6", "8", "9");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMultiSelectInvalid5() {
    Question question17 = new MultipleSelect("What food do you want today?",
            "3 4", "4", "7");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMultiSelectInvalid6() {
    Question question18 = new MultipleSelect("What food do you want today?",
            "10 11", "4", "7", "1", "2", "3", "5", "6");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMultiSelectInvalid7() {
    question3.answer("");
  }

  @Test
  public void testMultiSelectCorrect() {
    assertEquals("Correct", question3.answer("3 4"));
  }

  @Test
  public void testMultiSelectIncorrect() {
    assertEquals("Incorrect", question3.answer("2 4"));
  }

  @Test
  public void testMultiSelectToString() {
    assertEquals("Question is: What food do you want today?. Options are: [1, 2, 3, 4, 7].",
            question3.toString());
  }

  @Test
  public void testMultiChoice() {
    assertEquals("How many courses did you take this semester?", question2.getText());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMultiChoiceInvalid1() {
    Question question8 = new MultipleChoice("", "2", "1", "2", "4", "7");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMultiChoiceInvalid2() {
    Question question9 = new MultipleChoice("How many courses did you take this semester?",
            "", "1", "2", "4", "7");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMultiChoiceInvalid3() {
    Question question10 = new MultipleChoice("How many courses did you take this semester?",
            "1", "4", "7");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMultiChoiceInvalid4() {
    Question question11 = new MultipleChoice("How many courses did you take this semester?",
            "1", "4", "7", "1", "2", "3", "5", "6", "8", "9");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMultiChoiceInvalid5() {
    Question question12 = new MultipleChoice("How many courses did you take this semester?",
            "8", "4", "7", "1", "2", "3", "5", "6");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMultiChoiceInvalid6() {
    Question question12 = new MultipleChoice("How many courses did you take this semester?",
            "5", "4", "7", "1", "2", "", "5", "6");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMultiChoiceInvalid7() {
    question2.answer("");
  }

  @Test
  public void testMultiChoiceCorrect() {
    assertEquals("Correct", question2.answer("2"));
  }

  @Test
  public void testMultiChoiceIncorrect() {
    assertEquals("Incorrect", question2.answer("1"));
  }

  @Test
  public void testMultiChoiceToString() {
    assertEquals("Question is: How many courses did you take this semester?. Options are:" +
            " [1, 2, 4, 7].", question2.toString());
  }


  @Test
  public void testTrueFalse() {
    assertEquals("Did you enrolled the CS 5010?", question1.getText());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTrueFalseInvalid1() {
    Question question5 = new TrueFalse("", "true");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTrueFalseInvalid2() {
    Question question6 = new TrueFalse("Did you enrolled the CS 5010?", "");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTrueFalseInvalid3() {
    Question question7 = new TrueFalse("Did you enrolled the CS 5010?", "not true");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testTrueFalseInvalid4() {
    question1.answer("");
  }

  @Test
  public void testTrueFalseCorrect() {
    assertEquals("Correct", question1.answer("true"));
  }

  @Test
  public void testTrueFalseIncorrect() {
    assertEquals("Incorrect", question1.answer("false"));
  }

  @Test
  public void testTrueFalseToString() {
    assertEquals("Question is: Did you enrolled the CS 5010?. True or False.",
            question1.toString());
  }

  @Test
  public void testOrder() {
    Question question20 = new TrueFalse("5Did you enrolled the CS 5010?", "true");
    Question question21 = new MultipleChoice("6How many courses did you take this semester?",
            "2", "1", "2", "4", "7");
    Question question22 = new MultipleSelect("7What food do you want today?", "3 4", "1", "2",
            "3", "4", "7");
    Question question23 = new Likert("8Do you think this course is useful?");
    List<Question> questionnaire = new ArrayList<>();
    questionnaire.add(question3);
    questionnaire.add(question2);
    questionnaire.add(question1);
    questionnaire.add(question4);
    questionnaire.add(question22);
    questionnaire.add(question23);
    questionnaire.add(question21);
    questionnaire.add(question20);
    Collections.sort(questionnaire);
    assertEquals("[Question is: 5Did you enrolled the CS 5010?. True or False., Question is" +
                    ": Did you enrolled the CS 5010?. True or False., Question is: 6How many" +
                    " courses did you take this semester?. Options are: [1, 2, 4, 7]., Question" +
                    " is: How many courses did you take this semester?. Options are:" +
                    " [1, 2, 4, 7]., Question is: 7What food do you want today?. Options are:" +
                    " [1, 2, 3, 4, 7]., Question is: What food do you want today?. Options are:" +
                    " [1, 2, 3, 4, 7]., Question is: 8Do you think this course is useful?." +
                    " Options are: 1.Strongly Agree, 2.Agree, 3.Neither Agree nor Disagree," +
                    " 4.Disagree, 5.Strongly Disagree., Question is: Do you think this course" +
                    " is useful?. Options are: 1.Strongly Agree, 2.Agree, 3.Neither Agree nor" +
                    " Disagree, 4.Disagree, 5.Strongly Disagree.]"
            , questionnaire.toString());
  }
}
