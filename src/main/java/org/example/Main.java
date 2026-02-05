package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        CardGame snap = new CardGame("snap");
        snap.getDeck();

        Card card = snap.dealCard();
        snap.getDeck();
    }
}
