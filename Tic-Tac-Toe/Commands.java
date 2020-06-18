package tictactoe;

public class Commands {
    static char[] move(char[] board, int coordinateX, int coordinateY) {
        int xCounter = 0;
        int oCounter = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i] == 'X') {
                xCounter++;
            } else if (board[i] == 'O') {
                oCounter++;
            }
        }
        int coordinate = refactorCoordinates(coordinateX, coordinateY);
        if (coordinate < 0 || coordinate > 8) {
            System.out.println("Coordinates should be from 1 to 3!");
            return board;
        }
        if (board[coordinate] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return board;
        } else if (xCounter == oCounter) {
            board[coordinate] = 'X';
            printBoard(board);
            return board;
        } else {
            board[coordinate] = 'O';
            printBoard(board);
            return board;
        }
    }

    static int refactorCoordinates(int coordinateX, int coordinateY) {
        if (coordinateY == 1) {
            return coordinateX - coordinateY;
        } else if (coordinateY == 2) {
            return coordinateX + coordinateY;
        } else {
            return coordinateX + coordinateY + 2;
        }
    }

    static void printBoard(char[] board) {
        System.out.println("---------");
        System.out.println("| " + board[6] + " " + board[7] + " " + board[8] + " |");
        System.out.println("| " + board[3] + " " + board[4] + " " + board[5] + " |");
        System.out.println("| " + board[0] + " " + board[1] + " " + board[2] + " |");
        System.out.println("---------");
    }

    static String status(char[] board) {
        int emptyCounter = 0;
        for (char c : board) {
            if (c == ' ') {
                emptyCounter++;
            }
        }
        if (ifWon(board, 'X')) {
            return "X wins";
        } else if (ifWon(board, 'O')) {
            return "O wins";
        } else if (emptyCounter == 0) {
            return "Draw";
        } else
            return "Game not finished";
    }

    static boolean ifWon(char[] board, char player) {
        return board[0] == player && board[1] == player && board[2] == player ||
                board[3] == player && board[4] == player && board[5] == player ||
                board[6] == player && board[7] == player && board[8] == player ||
                board[0] == player && board[3] == player && board[6] == player ||
                board[1] == player && board[4] == player && board[7] == player ||
                board[2] == player && board[5] == player && board[8] == player ||
                board[0] == player && board[4] == player && board[8] == player ||
                board[2] == player && board[4] == player && board[6] == player;
    }
}