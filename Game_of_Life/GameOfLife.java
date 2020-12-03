package life;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameOfLife extends JFrame {
    private JPanel statsPanel;
    private LifePanel lifeBoardPanel;
    private GameCell[][] cellsArray;
    private JLabel aliveLabel;
    private JLabel generationsLabel;
    private JToggleButton pauseButton;
    private JButton resetButton;
    private int gen;

    public GameOfLife() {
        super("Game of Life");
        this.setDefaultCloseOperation(3);
        this.setSize(400, 400);
        this.setLocationRelativeTo((Component) null);
        this.setLayout(new BorderLayout());

        this.statsPanel = new JPanel();
        this.statsPanel.setName("Stats Panel");
        this.statsPanel.setLayout(new FlowLayout());
        this.add(this.statsPanel, "First");

        this.generationsLabel = new JLabel();
        this.generationsLabel.setName("GenerationLabel");
        this.generationsLabel.setText("Generation #0");
        this.statsPanel.add(this.generationsLabel);

        this.aliveLabel = new JLabel();
        this.aliveLabel.setName("AliveLabel");
        this.aliveLabel.setText("Alive: 0");
        this.statsPanel.add(this.aliveLabel);

        this.pauseButton = new JToggleButton();
        this.pauseButton.setName("PlayToggleButton");
        this.pauseButton.setText("Pause");
        this.statsPanel.add(this.pauseButton);

        this.resetButton = new JButton();
        this.resetButton.setName("ResetButton");
        this.resetButton.setText("Reset");
        this.statsPanel.add(this.resetButton);

        this.lifeBoardPanel = new LifePanel();
        this.lifeBoardPanel.setName("Life Board Panel");
        this.add(this.lifeBoardPanel, "Center");

        this.setVisible(true);
    }

    public LifePanel getLifePanel() {
        return this.lifeBoardPanel;
    }

    public JLabel getGenerationsLabel() {
        return this.generationsLabel;
    }

    public JLabel getAliveLabel() {
        return this.aliveLabel;
    }

    public JToggleButton getPauseButton() {
        return this.pauseButton;
    }

    public JButton getResetButton() {
        return this.resetButton;
    }
}