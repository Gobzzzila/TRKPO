package kursach;

public enum Organs {
    HEART{
        public int getPoints() { return 15000;}
    },
    HEAD{
        public int getPoints() { return 8000;}
    },
    STOMACH{
        public int getPoints() { return 5000;}
    };

    public abstract int getPoints();
}