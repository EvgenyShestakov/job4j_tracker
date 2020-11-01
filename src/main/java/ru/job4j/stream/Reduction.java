package ru.job4j.stream;

import java.util.List;

public class Reduction {
    public static Integer collect(List<Integer> list) {
        return  list.stream().reduce(5, ((integer, integer2) -> integer * integer2));
    }

    public static Integer reduce(List<Integer> list) {
        return list.stream().reduce((integer, integer2) -> integer * integer2).get();
    }
}
