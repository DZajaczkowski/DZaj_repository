package life;

import java.util.Random;

public class LifeBoard {
    private boolean[][] board;
    private Random random;

    public LifeBoard(int size, long seed) {
        this.board = new boolean[size][size];
        this.random = new Random(seed);
        this.initializeBoard();
    }

    public LifeBoard(int size) {
        this.board = new boolean[size][size];
        this.random = new Random();
        this.initializeBoard();
    }

    public void initializeBoard() {
        for(int i = 0; i < this.board.length; ++i) {
            for(int j = 0; j < this.board.length; ++j) {
                this.board[i][j] = this.random.nextBoolean();
            }
        }
    }

    public boolean[][] getBoard() {
        return this.board;
    }

    public void setBoard(boolean[][] b) {
        this.board = b;
    }

    public int countLiving() {
        int counter = 0;
        boolean[][] var2 = this.board;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            boolean[] b = var2[var4];
            boolean[] var6 = b;
            int var7 = b.length;

            for(int var8 = 0; var8 < var7; ++var8) {
                boolean c = var6[var8];
                if (c) {
                    ++counter;
                }
            }
        }

        return counter;
    }

    public void reset(int size) {
        board = new boolean[0][];
    }
}
