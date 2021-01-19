package ru.job4j.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Concordance {
    public static Map<Character, List<Integer>> collectCharacters(String s) {
        Map<Character, List<Integer>> rsl = new HashMap<>();
        char[] chars = s.replaceAll(" ", "").toCharArray();
        for (char ch : chars) {
            List<Integer> list = new ArrayList<>();
            if (!rsl.containsKey(ch)) {
                for (int index = 0; index < chars.length; index++) {
                    if (ch == chars[index]) {
                        list.add(index);
                    }
                }
                rsl.put(ch, list);
            }
        }
        return rsl;
    }
}
