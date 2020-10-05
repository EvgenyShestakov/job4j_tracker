package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(-3, 3, 7, -89, 0, -6, -23, 8);
        List<Integer> positive = numbers.stream().filter(integer -> integer > 0).
                collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
