package kursach;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int spread;
        System.out.println("Duel Game");
        System.out.println("Select the difficulty level");
        System.out.println("Easy - 1, Normal - 2, Hard - 3");
        int check = scanner.nextInt();
        scanner.nextLine();

        switch (check) {
            case 2 -> {
                spread = 200;
                System.out.println("Normal\n");
            }
            case 3 -> {
                spread = 100;
                System.out.println("Hard\n");
            }
            default -> {
                spread = 300;
                System.out.println("Easy\n");
            }
        }

        System.out.println("Player One name:");
        Player fPlayer = new Player(scanner.nextLine());

        System.out.println("Player Two name:");
        Player sPlayer = new Player(scanner.nextLine());

        Game game = new Game(fPlayer, sPlayer, spread);
        game.startGame();
        game.printScore();

        scanner.close();
    }
}
