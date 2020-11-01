package ru.job4j.lambda;

import java.util.Optional;

public class OptionalGetAndIsPresent {
    public static int get(int[] data, int el) {
        Optional<Integer> optional = indexOf(data, el);
        int index = optional.orElse(-1);
        return index;
    }

    private static Optional<Integer> indexOf(int[] data, int el) {
        Optional<Integer> optional = Optional.empty();
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                optional = Optional.of(index);
            }
        }
        return  optional;
    }
}
