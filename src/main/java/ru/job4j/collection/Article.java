package ru.job4j.collection;

import ru.job4j.tracker.StubOutput;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean flag = true;
        String originMod = origin.replaceAll("\\p{Punct}", "");
        String lineMod = line.replaceAll("\\p{Punct}", "");
        String[] one = originMod.split("\\s");
        String[] two = lineMod.split("\\s");
        Set<String> set = new HashSet<>();
        Collections.addAll(set, one);
        for (String elem: two) {
            if (!set.contains(elem)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
