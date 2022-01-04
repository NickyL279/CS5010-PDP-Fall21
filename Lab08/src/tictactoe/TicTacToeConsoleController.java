package tictactoe;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This starter files is for students to implement a console controller for the TicTacToe MVC
 * assignment.
 */
public class TicTacToeConsoleController implements TicTacToeController {

  private final Appendable out;
  private final Scanner scan;

  /**
   * Constructor for the controller.
   *
   * @param in  the source to read from
   * @param out the target to print to
   */
  public TicTacToeConsoleController(Readable in, Appendable out) {
    if (in == null || out == null) {
      throw new IllegalArgumentException("Readable and Appendable can't be null");
    }
    this.out = out;
    scan = new Scanner(in);
  }

  @Override
  public void playGame(TicTacToe m) {
    if (m == null) {
      throw new IllegalArgumentException("TicTacToe model cannot be null!");
    }
    try {
      out.append(m.toString()).append("\n");
      out.append("Enter a move for ").append(m.getTurn().toString()).append(":\n");
      Integer inputRow = null;
      Integer inputCol = null;
      String input;
      while (!m.isGameOver()) {
        input = scan.next();
        if (input.equals("q") || input.equals("Q")) {
          try {
            out.append("Game quit! Ending game state:\n").append(m.toString()).append("\n");
          } catch (IOException ioe) {
            throw new IllegalStateException("Append failed", ioe);
          }
          break;
        }
        try {
          int tmpInput = Integer.parseInt(input);
          if (inputRow == null) {
            inputRow = tmpInput;
          } else {
            inputCol = tmpInput;
            m.move(inputRow - 1, inputCol - 1);
            if (m.isGameOver()) {
              if (m.getWinner() != null) {
                if (m.getWinner().equals(Player.X)) {
                  out.append(m.toString()).append("\n").append("Game is over! X wins.\n");
                } else if (m.getWinner().equals(Player.O)) {
                  out.append(m.toString()).append("\n").append("Game is over! O wins.\n");
                }
              } else {
                out.append(m.toString()).append("\n").append("Game is over! Tie game.\n");
              }
              break;
            }
            out.append(m.toString()).append("\n");
            out.append("Enter a move for ").append(m.getTurn().toString()).append(":\n");
            inputRow = null;
            inputCol = null;
          }
        } catch (NumberFormatException e) {
          out.append("Not a valid number: ").append(input).append("\n");
        } catch (IllegalArgumentException e) {
          assert inputRow != null;
          assert inputCol != null;
          out.append("Not a valid move: ").append(String.valueOf(inputRow.intValue()))
                  .append(", ").append(String.valueOf(inputCol.intValue())).append("\n");
          inputRow = null;
          inputCol = null;
        }
      }
    } catch (IOException ioe) {
      throw new IllegalStateException("Append failed", ioe);
    } catch (NoSuchElementException e) {
      try {
        out.append("Nothing from readable").append("\n");
      } catch (IOException ioe) {
        throw new IllegalStateException("Append failed", ioe);
      }
    }
  }
}