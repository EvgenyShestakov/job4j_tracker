package ru.job4j.lambda;

import java.util.List;
import java.util.Optional;

public class OptionalOfAndEmpty {
    public static Optional<String> findValue(List<String> strings, String value) {
        Optional<String> optional = Optional.empty();
    for (int index = 0; index < strings.size(); index++) {
        if (strings.get(index).equals(value)) {
        optional = Optional.of(value);
        }
    }
    return optional;
    }
}
