package org.example;

public class Card implements Comparable<Card>{
    String suite = "";
    String symbol = "";
    int value = 0;

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public  Card(int value, String suite, String symbol){
        this.suite = suite;
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[suite=" + this.suite + ", symbol='" + this.symbol + "', value=" + this.value + "]";
    }

    @Override
    public int compareTo(Card other) {
        // Order by value - Natural Ascending Order
        // -1 - Negative - (this) is smaller that the (other) -> (this)
        // object will be positioned before the (other) object
        // 0 - Equal -> Positions will not change
        // 1 - - Positive - (this) is greater than the (other) -> (this)
        // object will be moved to the position after the (other) object
        return this.value - other.value;
    }
}


