package tictactoe;

/**
 * Represents a GUI controller of TicTacToe. Three in a row down/across/diagonally to win; X goes
 * first.
 */
public class TicTacToeControllerImpl implements TicTacToeController {
  private final TicTacToeView view;
  private final TicTacToe model;

  /**
   * Primary constructor that creates a new instance of a panel.
   *
   * @param ticTacToeView the view of the given model.
   * @param ticTacToe the model.
   */
  public TicTacToeControllerImpl(TicTacToeView ticTacToeView, TicTacToe ticTacToe) {
    if (ticTacToeView == null) {
      throw new IllegalArgumentException("View cannot be null!");
    }
    if (ticTacToe == null) {
      throw new IllegalArgumentException("Model cannot be null!");
    }
    this.view = ticTacToeView;
    this.model = ticTacToe;
  }

  @Override
  public void playGame() {
    view.addClickListener(this);
    view.makeVisible();
  }

  @Override
  public void handleCellClick(int row, int col) {
    if (row < 0 || col < 0) {
      throw new IllegalArgumentException("Invalid row or column!");
    }
    try {
      model.move(row, col);
      view.refresh();
    } catch (IllegalArgumentException | IllegalStateException e) {
      //System.out.println(e.getMessage());
    }
  }
}
