package ru.job4j.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.lang.System.out;

public class Lambda {
    public static void consumer(String input) {
         Consumer<String> print = s -> out.print(input);
         Consumer<String> ln = x -> out.println(input);
        print.andThen(ln);
    }

    public static Supplier<String> supplier() {
        Supplier<String> supplier = String::new;
        return supplier;
    }

    public static Function<Double, Double> apply() {
        Function<Double, Double> function = Math::sqrt;
         return function;
    }

    public static Predicate<String> predicate() {
        Predicate<String> predicate = String::isEmpty;
         return predicate;
    }
}