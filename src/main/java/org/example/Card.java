package org.example;

public class Card implements Comparable<Card>{
    String suite = "";
    String symbol = "";
    int value = 0;

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
        // Order by ID - Natural Ascending Order
        // -1 - Negative - (this) is smaller that the (other) -> (this)
        // object will be positioned before the (other) object
        // 0 - Equal -> Positions will not change
        // 1 - - Positive - (this) is greater than the (other) -> (this)
        // object will be moved to the position after the (other) object
        return this.value - other.value;
    }
}

// Java Program to Sort an ArrayList


// Class 2: Child class
// creates the comparator for comparing stock value
//class CardComparator implements Comparator<Card> {
//
//    // Function to compare
//    public int compare(Card c1, Card c2)
//    {
//        if (c1.value > c2.value)
//            return c1.value;
//        else
//            return c2.value;
//    }
//}

