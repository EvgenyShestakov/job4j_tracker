package ru.job4j.lambda;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OptionalOfNullable {
    public static Optional<String> findValue(List<String> strings, String value) {
        Optional<String> optional = Optional.empty();
        for (String s : strings) {
            if (Objects.equals(s, value)) {
                optional = Optional.ofNullable(s);
            }
        }
        return  optional;
    }
}
