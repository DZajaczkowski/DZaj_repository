package life;

import java.awt.Color;
import javax.swing.JPanel;

public class GameCell extends JPanel {
    private boolean alive;

    public GameCell() {
        this.setVisible(false);
        this.setBackground(Color.BLACK);
    }

    public GameCell(boolean alive) {
        this.setAlive(alive);
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
        this.setVisible(this.alive);
    }

    public boolean isAlive() {
        return this.alive;
    }
}
