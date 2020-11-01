package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;

public class MinMethod {
    public static String min(List<String> list) {
    return list.stream().min((o1, o2) -> Integer.compare(o1.length(), o2.length())).get();
    }
}
