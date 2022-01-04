package tictactoe;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * Represents a board panel of TicTacToe. Three in a row down/across/diagonally to win; X goes
 * first.
 */
public class BoardPanel extends JPanel {
  private final ReadonlyTttModel model;

  /**
   * Primary constructor that creates a new instance of a panel.
   *
   * @param model the read-only version of the given model.
   */
  public BoardPanel(ReadonlyTttModel model) {
    super();
    this.model = model;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    int width = 600;
    int height = 700;
    int blank = 100;
    int tmp = height - blank;
    g2d.drawLine(width / 3, 0, width / 3, tmp);
    g2d.drawLine(width * 2 / 3, 0, width * 2 / 3, tmp);
    g2d.drawLine(0, tmp / 3, width, tmp / 3);
    g2d.drawLine(0, tmp * 2 / 3, width, tmp * 2 / 3);

    g2d.setFont(new Font("", Font.ITALIC, 100));
    for (int i = 1; i <= 3; i++) {
      for (int j = 1; j <= 3; j++) {
        int x = (width * j / 3) - (width / (3 * 2));
        int y = (tmp * i / 3) - (tmp / (3 * 2));
        if (model.getMarkAt(i - 1, j - 1) != null) {
          if (model.getMarkAt(i - 1, j - 1) == Player.X) {
            g2d.drawString("X", x - (100 / 2), y + (100 / 2));
          } else {
            g2d.drawString("O", x - (100 / 2), y + (100 / 2));
          }
          //System.out.println(x - (100 / 2));
          //System.out.println(y + (100 / 2));
        }
      }
    }
    if (model.getWinner() != null) {
      g2d.setFont(new Font("", Font.ITALIC, 40));
      g2d.drawString("Player " + model.getWinner().toString() + " has won!", width / 3,
              height - (blank / 2));
    } else if (model.isGameOver()) {
      g2d.setFont(new Font("", Font.ITALIC, 40));
      g2d.drawString("Tie game.", width / 3, height - (blank / 2));
    } else {
      g2d.setFont(new Font("", Font.ITALIC, 40));
      g2d.drawString("Player " + model.getTurn().toString() + "'s turn!", width / 6,
              height - (blank / 2));
    }
  }
}
