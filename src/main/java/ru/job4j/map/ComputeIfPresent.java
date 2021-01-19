package ru.job4j.map;

import java.util.Map;

public class ComputeIfPresent {
    public static Map<Integer, String> collectData(
            Map<Integer, String> name, Map<Integer, String> surname) {
        for (Integer elem: name.keySet()) {
            name.computeIfPresent(elem, (integer, s) -> s + " " + surname.get(elem));
        }
        return name;
    }
}
