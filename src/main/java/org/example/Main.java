package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static List<Korta> cardDeck = new ArrayList<>();
    public static List<Korta> pasalintosKortos = new ArrayList<>();

    public static void main(String[] args) {
        generateCardDeck();
        shuffleDeck();
        printDeck();
        Zaidejas zaidejas = new Zaidejas("Marius");
        Zaidejas zaidejas1 = new Zaidejas("Mantas");
        dealCards(zaidejas, zaidejas1);
        declareWinner(game(zaidejas, zaidejas1));
        returnCards();
    }
    public static Korta generateCard(Enum zenklas, Enum nr, int points){
        Korta card = new Korta(zenklas, nr, points);
        return card;
    }
    public static List<Korta> generateCardDeck(){
        for(KortosRusis kr : KortosRusis.values()){
            for(KortosNr kn : KortosNr.values()){
                cardDeck.add(generateCard(kr, kn, kn.getVerte()));
            }
        }
        return cardDeck;
    }
    public static void printDeck(){
        int i = 0;
        for(Korta k : cardDeck){
            System.out.println(k);
            i++;
        }
        System.out.println(i);
    }
    public static void shuffleDeck(){
        //Collections.shuffle(cardDeck);
        Random random = new Random();
        for(int i = 0; i < 1000; i++){
            int rand = random.nextInt(0, 52);
            Korta temp = cardDeck.get(rand);
            cardDeck.remove(rand);
            cardDeck.add(0, temp);
        }
    }
    public static void dealCards(Zaidejas z, Zaidejas z1){
        for(int i = 0; i < 2; i++) {
            z.hand[i] = cardDeck.get(0);
            pasalintosKortos.add(cardDeck.get(0));
            cardDeck.remove(0);
            z1.hand[i] = cardDeck.get(0);
            pasalintosKortos.add(cardDeck.get(0));
            cardDeck.remove(0);
        }
    }
    public static Zaidejas game(Zaidejas z, Zaidejas z1){
        int pirmoTaskai = z.hand[0].getPoints() + z.hand[1].getPoints();
        int antroTaskai = z1.hand[0].getPoints() + z1.hand[1].getPoints();

        System.out.println(z.getName() + ": " + z.hand[0] + " and " + z.hand[1] + " | TASKAI: " + pirmoTaskai);
        System.out.println(z1.getName() + ": " + z1.hand[0] + " and " + z1.hand[1] + " | TASKAI: " + antroTaskai);

        if(pirmoTaskai > antroTaskai) {
            return z;
        } else if (pirmoTaskai < antroTaskai) {
            return z1;
        }else{
            return null;
        }
    }
    public static void returnCards(){
        for(Korta k : pasalintosKortos){
            cardDeck.add(k);
        }
    }
    public static void declareWinner(Zaidejas z){
        if(z != null){
            System.out.println("Laimetojas yra " + z.getName() + "!");
        }else{
            System.out.println("Lygiosios!");
        }
    }
}