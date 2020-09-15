package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
     String[] one = left.split("\\.");
     String[] two = right.split("\\.");
     return Integer.compare(Integer.parseInt(one[0]), Integer.parseInt(two[0]));
    }
}
