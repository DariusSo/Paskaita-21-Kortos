package org.example;

public enum KortosNr {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(11);

    public int verte;
    KortosNr(int i) {
        this.verte = i;
    }
    public int getVerte(){
        return verte;
    }
}
