package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Snap snap = new Snap("snap");
        snap.getDeck();

        Card card = snap.dealCard();
        snap.getDeck();
        snap.sortDeckInNumberOrder();
        snap.getDeck();
        snap.sortDeckIntoSuits();
        snap.getDeck();
        snap.shuffleDeck();
        snap.getDeck();
        snap.playGame();
    }
}
