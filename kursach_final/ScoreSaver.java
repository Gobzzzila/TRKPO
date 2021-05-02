package kursach;


import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ScoreSaver implements Serializable {
    private ScoreSaver mainSaver;
    private String filePath;
    private HashMap<String, Integer> allScores;

    ScoreSaver(String filePath) {
        this.filePath = filePath;
        allScores = new HashMap<>();
    }

    public void addScore(Player player) {
        if (mainSaver.allScores.containsKey(player.getName())) {
            if (player.getPoints() > mainSaver.allScores.get(player.getName())) {
                mainSaver.allScores.replace(player.getName(), player.getPoints());
            }
        } else {
            mainSaver.allScores.put(player.getName(),player.getPoints());
        }
    }

    public void printScore() {
        System.out.println("Winners");
        LinkedList<Map.Entry<String, Integer>> sortScores = new LinkedList<>(mainSaver.allScores.entrySet());
        sortScores.sort(Map.Entry.comparingByValue());
        sortScores.descendingIterator().forEachRemaining(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    public void getScore() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            mainSaver = (ScoreSaver) objectInputStream.readObject();
        } catch (FileNotFoundException exception) {
            mainSaver = new ScoreSaver(filePath);
        } catch (IOException | ClassNotFoundException exception) {
            throw new RuntimeException("Cannot load", exception);
        }
    }

    public void saveScore() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(mainSaver);
        } catch (IOException exception) {
            throw new RuntimeException("Cannot save", exception);
        }
    }
}
