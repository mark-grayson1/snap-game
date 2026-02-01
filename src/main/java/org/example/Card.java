package org.example;

public class Card {
    String suite = "";
    String symbol = "";
    int value = 0;

    public  Card(String suite, String symbol, int value){
        this.suite = suite;
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[suite=" + this.suite + ", symbol='" + this.symbol + "', value=" + this.value + "]";
    }
}
