package tictactoe;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] board = new char[9];
        Arrays.fill(board, ' ');
        Commands.printBoard(board);
        while (Objects.equals(Commands.status(board), "Game not finished")) {
            try {
                System.out.print("Enter the coordinates: ");
                Commands.move(board, sc.nextInt(), sc.nextInt());
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("You should enter numbers!");
            }
        }
        System.out.println(Commands.status(board));
    }
}