package ru.job4j.lambda;

import java.util.function.Consumer;

import static java.lang.System.out;

public class MethodReference {
    public void applyByInstance() {
        Consumer<String> consumer = this::consumerByInstance;
        consumer.accept("Hello");
    }

    public static void applyByClass() {
        Consumer<String> consumer = MethodReference::consumerByClass;
        consumer.accept("Hello");
    }

    private void consumerByInstance(String input) {
        out.print("From instance: " + input);
    }

    private static void consumerByClass(String input) {
        out.print("From class: " + input);
    }
}
