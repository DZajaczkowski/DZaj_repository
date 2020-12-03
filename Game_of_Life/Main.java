package life;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        int size = 30;
        LifeBoard board = new LifeBoard(size);
        GameOfLife window = new GameOfLife();
        LifeController controller = new LifeController(board, window, size);
        controller.start();
    }
}