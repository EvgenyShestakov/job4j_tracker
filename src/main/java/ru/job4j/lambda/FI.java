package ru.job4j.lambda;

import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Comparator<String> comparator = (left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
            return right.length() - left.length();
        };
    }
}


