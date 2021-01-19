package ru.job4j.map;

import java.util.*;

public class MostUsedCharacter {
    public static char getMaxCount(String str) {
      String s = str.toLowerCase().replaceAll(" ", "");
       char[] ch = s.toCharArray();
       Map<Character, Integer> map = new HashMap<>();
        Map<Integer, Character> map1 = new TreeMap<>(Collections.reverseOrder());
       for (Character character : ch) {
           if (map.containsKey(character)) {
               map.computeIfPresent(character, (key, value) -> value + 1);
           } else {
           map.putIfAbsent(character, 1);
           }
       }
       for (Map.Entry<Character, Integer> entry: map.entrySet()) {
       map1.putIfAbsent(entry.getValue(), entry.getKey());
       }
        Iterator<Map.Entry<Integer, Character>> it = map1.entrySet().iterator();
        Map.Entry<Integer, Character> pair = it.next();
        return pair.getValue();
    }
}
