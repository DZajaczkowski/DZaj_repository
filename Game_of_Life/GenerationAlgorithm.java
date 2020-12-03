package life;

public class GenerationAlgorithm {
    public GenerationAlgorithm() {
    }

    public static void updatePopulation(LifeBoard b) {
        boolean[][] current = b.getBoard();
        int size = current.length;
        boolean[][] next = new boolean[size][size];

        for(int i = 0; i < size; ++i) {
            for(int j = 0; j < size; ++j) {
                int counter = countNeighbours(current, i, j);
                if (!current[i][j] && counter == 3) {
                    next[i][j] = true;
                } else if ((!current[i][j] || counter != 2) && counter != 3) {
                    next[i][j] = false;
                } else {
                    next[i][j] = true;
                }
            }
        }

        b.setBoard(next);
    }

    private static int countNeighbours(boolean[][] board, int row, int col) {
        int counter = 0;
        int size = board.length;

        for(int i = row - 1; i <= row; ++i) {
            for(int j = col - 1; j <= col; ++j) {
                if ((i != row || i != col) && board[(i + size) % size][(j + size) % size]) {
                    ++counter;
                }
            }
        }

        return counter;
    }
}
