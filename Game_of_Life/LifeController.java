package life;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LifeController extends Thread {
    private LifeBoard board;
    private GameOfLife window;
    private int size;
    private int gen;

    public LifeController(LifeBoard board, GameOfLife window, int size) {
        this.board = board;
        this.window = window;
        this.size = size;
    }

    public void run() {
        gen = 0;
        this.window.getLifePanel().initialize(this.size);

        while (true) {
            UpdateThread t = new UpdateThread(this.board, this.window, gen);
            t.start();

            try {
                t.join();
            } catch (InterruptedException var5) {
                System.out.println("error");
            }

            GenerationAlgorithm.updatePopulation(this.board);
            ++gen;

            try {
                sleep(500L);
                while (this.window.getPauseButton().isSelected()) {
                    sleep(100L);
                }
            } catch (InterruptedException var4) {
                System.out.println("error");
            }

            this.window.getResetButton().addActionListener(e -> {
                board = new LifeBoard(size);
                gen = 0;
                this.window.getPauseButton().setSelected(false);
            });
        }
    }
}
