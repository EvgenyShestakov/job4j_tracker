package ru.job4j.lambda;

import java.util.Optional;

public class OptionalIfPresent {
    public static void ifPresent(int[] data) {
    max(data).ifPresent(integer -> System.out.println("Max: " + integer));
    }

    private static Optional<Integer> max(int[] data) {
        Optional<Integer> optional = Optional.empty();
        int max = Integer.MIN_VALUE;
        for (int index = 0; index < data.length; index++) {
            if (data[index] > max) {
                max = data[index];
            }
        }
        if (max > Integer.MIN_VALUE) {
            optional = Optional.of(max);
        }
        return  optional;
    }
}
