package ru.job4j.stream;

import java.util.stream.Stream;

public class StreamIterate {
    public static void showArray(Integer[] data) {
        Stream.iterate(0, integer -> integer < data.length, integer -> integer + 2).
                forEach(i -> System.out.println("" + data[i]));
    }
}
