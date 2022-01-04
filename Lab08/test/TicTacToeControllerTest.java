import static org.junit.Assert.assertEquals;

import tictactoe.TicTacToe;
import tictactoe.TicTacToeConsoleController;
import tictactoe.TicTacToeController;
import tictactoe.TicTacToeModel;
import java.io.StringReader;
import org.junit.Test;

/**
 * Test cases for the tic tac toe controller, using mocks for readable and
 * appendable.
 */
public class TicTacToeControllerTest {

  // Providing this shell for you to write your
  // own test cases for the TicTacToe controller
  // You DO NOT NEED to implement tests for the provided model
  
  // TODO: Implement your own tests cases for the controller


  @Test(expected = IllegalArgumentException.class)
  public void testInvalidModel() {
    StringReader input = new StringReader("0 1 q");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(null);
  }

  @Test
  public void testInvalidMoveOutBoundary() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("0 1 q");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            "Not a valid move: 0, 1\n" +
            "Game quit! Ending game state:\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n", gameLog.toString());
  }

  @Test
  public void testInvalidMoveOccupiedCell() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 1 q");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Not a valid move: 1, 1\n" +
            "Game quit! Ending game state:\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n", gameLog.toString());
  }

  @Test
  public void testInvalidInputRow() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("f 1 q");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            "Not a valid number: f\n" +
            "Game quit! Ending game state:\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n", gameLog.toString());
  }

  @Test
  public void testInvalidInputCol() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 g q");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            "Not a valid number: g\n" +
            "Game quit! Ending game state:\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n", gameLog.toString());
  }

  @Test
  public void testInvalidOutBoundary1() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 4 1 q");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Not a valid move: 4, 1\n" +
            "Game quit! Ending game state:\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n", gameLog.toString());
  }

  @Test
  public void testInvalidMoveCombine() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 4 1 f f f 1 1 q");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Not a valid move: 4, 1\n" +
            "Not a valid number: f\n" +
            "Not a valid number: f\n" +
            "Not a valid number: f\n" +
            "Not a valid move: 1, 1\n" +
            "Game quit! Ending game state:\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n", gameLog.toString());
  }

  @Test
  public void testInvalidMoveMulti() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 4 1 4 4 4 1 5 1 q");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Not a valid move: 4, 1\n" +
            "Not a valid move: 4, 4\n" +
            "Not a valid move: 4, 1\n" +
            "Not a valid move: 5, 1\n" +
            "Game quit! Ending game state:\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n", gameLog.toString());
  }

  @Test
  public void testInvalidMoveCombine2() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 4 1 F 1 f 3 5 3 1 2 q");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Not a valid move: 4, 1\n" +
            "Not a valid number: F\n" +
            "Not a valid number: f\n" +
            " X |   | O\n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            "Not a valid move: 5, 3\n" +
            " X | X | O\n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Game quit! Ending game state:\n" +
            " X | X | O\n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n", gameLog.toString());
  }

  @Test
  public void testValidMove() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 2 2 q");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   | O |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            "Game quit! Ending game state:\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   | O |  \n" +
            "-----------\n" +
            "   |   |  \n", gameLog.toString());
  }

  @Test
  public void testTieGame() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 2 1 1 2 1 1 3 2 2 2 3 3 1 3 2 3 3");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            " O | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X |  \n" +
            "-----------\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X | O\n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X | O\n" +
            "-----------\n" +
            " X |   |  \n" +
            "Enter a move for O:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X | O\n" +
            "-----------\n" +
            " X | O |  \n" +
            "Enter a move for X:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X | O\n" +
            "-----------\n" +
            " X | O | X\n" +
            "Game is over! Tie game.\n", gameLog.toString());
  }

  @Test
  public void testTieGameWithInvalid() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 2 5 2 1 1 2 1 1 3 2 2 2 3 3 1 3 2 3 3");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Not a valid move: 5, 2\n" +
            " O | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X |  \n" +
            "-----------\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X | O\n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X | O\n" +
            "-----------\n" +
            " X |   |  \n" +
            "Enter a move for O:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X | O\n" +
            "-----------\n" +
            " X | O |  \n" +
            "Enter a move for X:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X | O\n" +
            "-----------\n" +
            " X | O | X\n" +
            "Game is over! Tie game.\n", gameLog.toString());
  }

  @Test
  public void testTieWithInvalid1() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 2 f f f 1 1 2 1 1 3 2 2 2 3 3 1 3 2 3 3");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Not a valid number: f\n" +
            "Not a valid number: f\n" +
            "Not a valid number: f\n" +
            " O | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X |  \n" +
            "-----------\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X | O\n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X | O\n" +
            "-----------\n" +
            " X |   |  \n" +
            "Enter a move for O:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X | O\n" +
            "-----------\n" +
            " X | O |  \n" +
            "Enter a move for X:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X | O\n" +
            "-----------\n" +
            " X | O | X\n" +
            "Game is over! Tie game.\n", gameLog.toString());
  }

  @Test
  public void testTieWithOccupied() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 2 1 2 1 1 2 1 1 3 2 2 2 3 3 1 3 2 3 3");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Not a valid move: 1, 2\n" +
            " O | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X |  \n" +
            "-----------\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X | O\n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X | O\n" +
            "-----------\n" +
            " X |   |  \n" +
            "Enter a move for O:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X | O\n" +
            "-----------\n" +
            " X | O |  \n" +
            "Enter a move for X:\n" +
            " O | X | O\n" +
            "-----------\n" +
            " X | X | O\n" +
            "-----------\n" +
            " X | O | X\n" +
            "Game is over! Tie game.\n", gameLog.toString());
  }

  @Test
  public void testXWinsGame() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 2 2 2 1 3 3 3");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            " X | O |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X | O |  \n" +
            "-----------\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            " X | O | O\n" +
            "-----------\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X | O | O\n" +
            "-----------\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   | X\n" +
            "Game is over! X wins.\n", gameLog.toString());
  }

  @Test
  public void testXWinsWithInvalid() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 4 1 1 2 2 2 1 3 3 3");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Not a valid move: 4, 1\n" +
            " X | O |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X | O |  \n" +
            "-----------\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            " X | O | O\n" +
            "-----------\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X | O | O\n" +
            "-----------\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   | X\n" +
            "Game is over! X wins.\n", gameLog.toString());
  }

  @Test
  public void testXWinsWithOccupied() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 1 1 1 2 2 2 2 2 1 3 3 3");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Not a valid move: 1, 1\n" +
            " X | O |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X | O |  \n" +
            "-----------\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Not a valid move: 2, 2\n" +
            " X | O | O\n" +
            "-----------\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X | O | O\n" +
            "-----------\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   | X\n" +
            "Game is over! X wins.\n", gameLog.toString());
  }

  @Test
  public void testXWinsWithMultipleInvalid() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 f f f 1 1 4 2 5 6 1 1 1 2 2 2 2 2 1 3 3 3");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Not a valid number: f\n" +
            "Not a valid number: f\n" +
            "Not a valid number: f\n" +
            "Not a valid move: 1, 1\n" +
            "Not a valid move: 4, 2\n" +
            "Not a valid move: 5, 6\n" +
            "Not a valid move: 1, 1\n" +
            " X | O |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X | O |  \n" +
            "-----------\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Not a valid move: 2, 2\n" +
            " X | O | O\n" +
            "-----------\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X | O | O\n" +
            "-----------\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   | X\n" +
            "Game is over! X wins.\n", gameLog.toString());
  }

  @Test
  public void testXWinsWithRowColInvalid() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 1 4 1 5 1 1 6 1 2 2 2 2 2 1 3 3 3");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Not a valid move: 4, 1\n" +
            "Not a valid move: 5, 1\n" +
            "Not a valid move: 1, 6\n" +
            " X | O |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X | O |  \n" +
            "-----------\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Not a valid move: 2, 2\n" +
            " X | O | O\n" +
            "-----------\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " X | O | O\n" +
            "-----------\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   | X\n" +
            "Game is over! X wins.\n", gameLog.toString());
  }


  @Test
  public void testOWinsGame() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 2 1 1 1 3 2 2 3 1 3 3");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            " O | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X | X\n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            " O | X | X\n" +
            "-----------\n" +
            "   | O |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X | X\n" +
            "-----------\n" +
            "   | O |  \n" +
            "-----------\n" +
            " X |   |  \n" +
            "Enter a move for O:\n" +
            " O | X | X\n" +
            "-----------\n" +
            "   | O |  \n" +
            "-----------\n" +
            " X |   | O\n" +
            "Game is over! O wins.\n", gameLog.toString());
  }

  @Test
  public void testOWinsWithInvalids() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 2 4 2 1 1 1 3 5 6 2 2 3 1 3 3");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Not a valid move: 4, 2\n" +
            " O | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X | X\n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Not a valid move: 5, 6\n" +
            " O | X | X\n" +
            "-----------\n" +
            "   | O |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X | X\n" +
            "-----------\n" +
            "   | O |  \n" +
            "-----------\n" +
            " X |   |  \n" +
            "Enter a move for O:\n" +
            " O | X | X\n" +
            "-----------\n" +
            "   | O |  \n" +
            "-----------\n" +
            " X |   | O\n" +
            "Game is over! O wins.\n", gameLog.toString());
  }

  @Test
  public void testOWinsWithOccupied() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 2 1 2 1 1 1 3 2 2 3 1 3 3");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Not a valid move: 1, 2\n" +
            " O | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X | X\n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            " O | X | X\n" +
            "-----------\n" +
            "   | O |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X | X\n" +
            "-----------\n" +
            "   | O |  \n" +
            "-----------\n" +
            " X |   |  \n" +
            "Enter a move for O:\n" +
            " O | X | X\n" +
            "-----------\n" +
            "   | O |  \n" +
            "-----------\n" +
            " X |   | O\n" +
            "Game is over! O wins.\n", gameLog.toString());
  }

  @Test
  public void testQuitGame() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("1 2 1 1 1 3 2 2 3 1 Q 3");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            " O | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X | X\n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            " O | X | X\n" +
            "-----------\n" +
            "   | O |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            " O | X | X\n" +
            "-----------\n" +
            "   | O |  \n" +
            "-----------\n" +
            " X |   |  \n" +
            "Enter a move for O:\n" +
            "Game quit! Ending game state:\n" +
            " O | X | X\n" +
            "-----------\n" +
            "   | O |  \n" +
            "-----------\n" +
            " X |   |  \n", gameLog.toString());
  }

  @Test
  public void testMultiInvalidQuit() {
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("4 5 6 7 1 2 4 9 5 8 f f f 4 2 q");
    StringBuffer gameLog = new StringBuffer();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
    assertEquals("   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for X:\n" +
            "Not a valid move: 4, 5\n" +
            "Not a valid move: 6, 7\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "Enter a move for O:\n" +
            "Not a valid move: 4, 9\n" +
            "Not a valid move: 5, 8\n" +
            "Not a valid number: f\n" +
            "Not a valid number: f\n" +
            "Not a valid number: f\n" +
            "Not a valid move: 4, 2\n" +
            "Game quit! Ending game state:\n" +
            "   | X |  \n" +
            "-----------\n" +
            "   |   |  \n" +
            "-----------\n" +
            "   |   |  \n", gameLog.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testFailingAppendable() {
    // Testing when something goes wrong with the Appendable
    // Here we are passing it a mock of an Appendable that always fails
    TicTacToe m = new TicTacToeModel();
    StringReader input = new StringReader("2 2 1 1 3 3 1 2 1 3 2 3 2 1 3 1 3 2");
    Appendable gameLog = new FailingAppendable();
    TicTacToeController c = new TicTacToeConsoleController(input, gameLog);
    c.playGame(m);
  }
}
