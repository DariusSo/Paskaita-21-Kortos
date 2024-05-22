package org.example;

public class Korta {
    private Enum KortosZenklas;
    private Enum KortosNr;
    private int points;

    public Korta(Enum kortosZenklas, Enum kortosNr, int points) {
        KortosZenklas = kortosZenklas;
        KortosNr = kortosNr;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return KortosZenklas + " " + KortosNr;
    }
}
