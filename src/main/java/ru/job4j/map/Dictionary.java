package ru.job4j.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    public static Map<String, List<String>> collectData(String[] strings) {
        Map<String, List<String>> rsl = new HashMap<>();
        for (String word : strings) {
            String s1 = word.substring(0, 1);
            List<String> list = new ArrayList<>();
            if (!rsl.containsKey(s1)) {
                for (String word1 : strings) {
                    if (word1.startsWith(s1)) {
                        list.add(word1);
                    }
                }
                rsl.put(s1, list);
            }
        }
        return rsl;
    }
}
