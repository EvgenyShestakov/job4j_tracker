package ru.job4j.lambda;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.Assert.*;

public class LambdaTest {
    @Test
    public void testConsumer() {
            PrintStream out = System.out;
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(buffer);
            System.setOut(printStream);
            String input = "job4j";
            String expect = String.format("%s%s", input, System.lineSeparator());
            Lambda.consumer(input);
            assertEquals(expect, buffer.toString());
            System.setOut(out);
        }

    @Test
    public void testSupplier() {
        Supplier<String> supplier = Lambda.supplier();
        assertEquals("", supplier.get());
    }

    @Test
    public void testFunction() {
        Function<Double, Double> f = Lambda.apply();
        assertEquals(2.0, f.apply(4.0), 0.01);
        assertEquals(3.0, f.apply(9.0), 0.01);
    }

    @Test
    public void testPredicate() {
        Predicate<String> predicate = Lambda.predicate();
        assertTrue(predicate.test(""));
        assertFalse(predicate.test("a"));
    }
}
