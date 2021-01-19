package ru.job4j.collection;

import ru.job4j.tracker.StubOutput;

import java.util.*;

public class Article {
    public static boolean generateByHashSet(String origin, String line) {
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

    public static boolean generateByHashMap(String origin, String line) {
        Map<String, String> map = new HashMap<>();
        boolean rsl = true;
        for (String string : origin.replaceAll("\\p{Punct}", "").split("\\s")) {
            map.putIfAbsent(string, null);
        }
        for (String string : line.replaceAll("\\p{Punct}", "").split("\\s")) {
            if (!map.containsKey(string)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
