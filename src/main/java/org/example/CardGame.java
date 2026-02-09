package org.example;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
//import java.util.Collections;

public class CardGame {

    static final byte NUMBER_OF_SUITES = 4;
    static final byte CARDS_IN_SUITE = 13;
    static final byte CARDS_IN_PACK = 52;

    //define suits
    String diamond = "\u2666";
    String heart = "\u2665"; //The standard symbol for the hearts suit
    String club = "\u2663";
    String spade = "\u2660'";
    String[] suiteArr = {heart, diamond, club,  spade};

    //define card symbols - aces high
    String[] symbolArr = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};


    ArrayList<Card> deckOfCards = new ArrayList<>(52);
    String name = "";

    public CardGame(String name){
        this.name = name;

        for (int suite = 0; suite < NUMBER_OF_SUITES; suite++){
            for (int card = 2; card <= CARDS_IN_SUITE + 1; card++) {
                deckOfCards.add(new Card(card, suiteArr[suite], symbolArr[card-2]));
            }
        }
    }

    public void getDeck() {
        deckOfCards.forEach(card -> System.out.println(card));
    }


    public Card dealCard() {
        return deckOfCards.removeFirst();
    }

    public ArrayList<Card> sortDeckInNumberOrder() {
        Collections.sort(deckOfCards);
        return deckOfCards;
    }
}
