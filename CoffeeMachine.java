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


class Mechanics {

    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    private State state;

    public Mechanics() {
        water = 400;
        milk = 540;
        beans = 120;
        cups = 9;
        money = 550;
        state = State.CHOOSING_AN_ACTION;
    }

    public void processInputCommands(String input) {
            switch (state) {
                case CHOOSING_AN_ACTION:
                    choosingAnAction(input);
                    break;

                case CHOOSING_A_COFFEE:
                    choosingACoffee(input);
                    break;

                case FILL_WATER:
                    fillWater(input);
                    break;

                case FILL_MILK:
                    fillMilk(input);
                    break;

                case FILL_BEANS:
                    fillBeans(input);
                    break;

                case FILL_CUPS:
                    fillCups(input);
                    break;
            }
    }

    private void choosingAnAction(String input) {
        switch (input) {
            case "buy":
                state = State.CHOOSING_A_COFFEE;
                System.out.println();
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                break;
            case "fill":
                state = State.FILL_WATER;
                System.out.println();
                System.out.println("Write how many ml of water do you want to add:");
                break;
            case "take":
                System.out.println();
                take();
                break;
            case "remaining":
                System.out.println();
                remaining();
                break;
            case "exit":
                System.exit(0);
            default:
                System.out.println();
                System.out.println("Wrong input!");
                System.out.println();

                break;
        }
    }

    private void buyCheck(int cupWater, int cupMilk, int cupBeans) {
        if (water - cupWater > 0 && milk - cupMilk > 0 && beans - cupBeans > 0 && cups > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= cupWater;
            milk -= cupMilk;
            beans -= cupBeans;
            cups--;
        } else if (water - cupWater < 0) {
            System.out.println("Sorry, not enough water!");
        } else if (milk - cupMilk < 0) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans - cupBeans <0) {
            System.out.println("Sorry, not enough coffee beans!");
        }
        state = State.CHOOSING_AN_ACTION;
        System.out.println();
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    public void choosingACoffee(String input) {
        switch (input) {
            case "1":
                money += 4;
                buyCheck(250, 0, 16);
                break;
            case "2":
                money += 7;
                buyCheck(350, 75, 20);
                break;
            case "3":
                money += 6;
                buyCheck(200, 100, 12);
                break;
            case "back":
                state = State.CHOOSING_AN_ACTION;
                System.out.println();
                System.out.println("Write action (buy, fill, take, remaining, exit):");
                break;
            default:
                System.out.println("Wrong input!");
                break;
        }
    }

    public void fillWater(String input) {
        state = State.FILL_MILK;
        water += Integer.parseInt(input);
        System.out.println("Write how many ml of milk do you want to add:");
    }

    public void fillMilk(String input) {
        state = State.FILL_BEANS;
        milk += Integer.parseInt(input);
        System.out.println("Write how many grams of coffee beans do you want to add:");
    }

    public void fillBeans(String input) {
        state = State.FILL_CUPS;
        beans += Integer.parseInt(input);
        System.out.println("Write how many disposable cups of coffee do you want to add:");
    }

    public void fillCups(String input) {
        state = State.CHOOSING_AN_ACTION;
        cups += Integer.parseInt(input);
        System.out.println();
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    public int take() {
        System.out.println("I gave you $" + money);
        money = 0;
        System.out.println();
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        return money;
    }

    private void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println();
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }
}

enum State {
    CHOOSING_AN_ACTION, CHOOSING_A_COFFEE, FILL_WATER, FILL_MILK, FILL_BEANS, FILL_CUPS
}