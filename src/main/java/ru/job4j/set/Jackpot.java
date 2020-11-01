package ru.job4j.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Jackpot {
    public static boolean checkYourWin(String[] combination) {
        boolean flag = false;
        Set<String> set = new HashSet<>(Arrays.asList(combination));
        if (set.size() == 1) {
            flag = true;
        }
        return flag;
    }
}
