package life;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class UpdateThread extends Thread {
    private LifeBoard board;
    private GameOfLife window;
    private int gen;

    public UpdateThread(LifeBoard board, GameOfLife window, int gen) {
        this.board = board;
        this.window = window;
        this.gen = gen;
    }

    public void run() {
        this.window.getGenerationsLabel().setText("Generation #" + this.gen);
        this.window.getGenerationsLabel().repaint();
        this.window.getAliveLabel().setText("Alive: " + this.board.countLiving());
        this.window.getAliveLabel().repaint();
        this.window.getLifePanel().updateCellArray(this.board.getBoard());
    }
}