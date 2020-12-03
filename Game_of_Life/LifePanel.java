package life;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class LifePanel extends JPanel {
    private GameCell[][] cellArray;

    public LifePanel() {
    }

    public void initialize(int dimension) {
        this.setLayout(new GridLayout(dimension, dimension, 1, 1));
        this.cellArray = new GameCell[dimension][dimension];

        for(int i = 0; i < dimension; ++i) {
            for(int j = 0; j < dimension; ++j) {
                this.cellArray[i][j] = new GameCell();
                this.add(this.cellArray[i][j]);
            }
        }

    }

    public void updateCellArray(boolean[][] board) {
        if (this.cellArray != null) {
            for(int i = 0; i < board.length; ++i) {
                for(int j = 0; j < board[0].length; ++j) {
                    if (this.cellArray[i][j].isAlive() != board[i][j]) {
                        this.cellArray[i][j].setAlive(board[i][j]);
                    }
                }
            }

            this.repaint();
        } else {
            this.initialize(board.length);
            this.updateCellArray(board);
        }

    }
}
