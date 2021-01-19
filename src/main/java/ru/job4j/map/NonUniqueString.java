package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class NonUniqueString {
    public static Map<String, Boolean> checkData(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();
        for (String string : strings) {
            if (!map.containsKey(string)) {
                map.put(string, false);
            } else {
                map.put(string, true);
            }
        }
        return map;
    }
}
