package tictactoe;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Represents a view using swing of TicTacToe. Three in a row down/across/diagonally to win; X goes
 * first.
 */
public class TicTacToeSwingView extends JFrame implements TicTacToeView {
  private final JPanel boardPanel;

  /**
   * Primary constructor that creates a new instance of a TicTacToeView.
   *
   * @param m The TicTacToeModelReadOnly reference passed in that is visualized by this view.
   */
  public TicTacToeSwingView(ReadonlyTttModel m) {
    super("Tic-Tac-Toe");
    if (m == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }
    setSize(600, 700);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    boardPanel = new BoardPanel(m);
    add(boardPanel);
  }

  @Override
  public void addClickListener(TicTacToeController listener) {
    MouseAdapter clickAdapter = new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        int row = e.getY() / (600 / 3);
        //System.out.println(row);
        int col = e.getX() / (600 / 3);
        //System.out.println(col);
        listener.handleCellClick(row, col);
      }
    };
    boardPanel.addMouseListener(clickAdapter);
  }

  @Override
  public void refresh() {
    this.repaint();
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }
}
