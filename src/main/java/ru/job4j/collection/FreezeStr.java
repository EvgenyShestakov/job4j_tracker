package ru.job4j.collection;

import java.util.Arrays;
import static java.util.Arrays.sort;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] one = left.toCharArray();
        char[] two = right.toCharArray();
        sort(one);
        sort(two);
        return Arrays.equals(one, two);
    }
}
