package kursach;

public class Player {
    private String name;
    private int points;

    Player(String name) {
        this.name = name;
        points = 0;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
