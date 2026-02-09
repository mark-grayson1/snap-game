package org.example;

import java.util.Comparator;

public class SortCardsBySuiteAndValue implements Comparator<Card> {
    public int compare(Card left, Card right) {
        if (left.getSuite().equals(right.getSuite())) {
            return left.getValue() - right.getValue();
        }
        else {
            return left.getSuite().compareTo(right.getSuite());
        }
    }
}
