package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        Mechanics mechanics = new Mechanics();
        Scanner sc = new Scanner(System.in);
        while (true) {
            mechanics.processInputCommands(sc.next());
        }
    }
}