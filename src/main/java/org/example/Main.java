package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        String[] symbolArr = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

        for (int i = 2; i <= 14; i++) {
            Card card = new Card("♥", symbolArr[i-2], i);
            System.out.println(card);
        }

    }
}
