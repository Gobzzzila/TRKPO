package kursach;

import java.util.Scanner;

public class Game {
    private Player firstPlayer;
    private Player secondPlayer;
    private Player activePlayer;
    ScoreSaver saver;
    private int spread;
    private boolean gameFinisher;

    Game(Player firstPlayer, Player secondPlayer, int spread) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.spread = spread;
        activePlayer = firstPlayer;
        gameFinisher = false;
        saver = new ScoreSaver("D:\\ТРКПО\\kursach\\saves.dat");
        saver.getScore();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("To barrier");
        while (true) {
            long timer = System.currentTimeMillis();
            scanner.nextLine();
            activePlayer.setPoints((int) (System.currentTimeMillis() - timer));
            hitScanner();

            if (gameFinisher) {
                saver.addScore(activePlayer);
                saver.saveScore();
                break;
            }
            System.out.println(activePlayer.getName() + ": " + (double)(activePlayer.getPoints()) / 1000);
            changePlayer();
        }
    }

    private void changePlayer() {
        if (activePlayer.equals(firstPlayer))
            activePlayer = secondPlayer;
        else
            activePlayer = firstPlayer;
    }

    private void hitScanner() {
        if (activePlayer.getPoints() >= Organs.STOMACH.getPoints() - spread && activePlayer.getPoints() <= Organs.STOMACH.getPoints() + spread) {
            activePlayer.setPoints(Organs.STOMACH.getPoints() / 1000);
            System.out.println(activePlayer.getName() + ": " + activePlayer.getPoints());
            gameFinisher = true;
        } else if (activePlayer.getPoints() >= Organs.HEAD.getPoints() - spread && activePlayer.getPoints() <= Organs.HEAD.getPoints() + spread) {
            activePlayer.setPoints(Organs.HEAD.getPoints() / 1000);
            System.out.println(activePlayer.getName() + ": " + activePlayer.getPoints());
            gameFinisher = true;
        } else if (activePlayer.getPoints() >= Organs.HEART.getPoints() - spread && activePlayer.getPoints() <= Organs.HEART.getPoints() + spread) {
            activePlayer.setPoints(Organs.HEART.getPoints() / 1000);
            System.out.println(activePlayer.getName() + ": " + activePlayer.getPoints());
            gameFinisher = true;
        }
    }

    public void printScore() {
        saver.printScore();
    }
}
