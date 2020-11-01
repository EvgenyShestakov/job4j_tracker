package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class ReduceTest {
    @Test
    public void test1() {
        assertEquals(Integer.valueOf(5), Reduction.collect(List.of()));
        assertEquals(Integer.valueOf(5), Reduction.collect(List.of(1)));
        assertEquals(Integer.valueOf(10), Reduction.collect(List.of(1, 2)));
        assertEquals(Integer.valueOf(30), Reduction.collect(List.of(1, 2, 3)));
    }

    @Test
    public void test2() {
        assertEquals(Integer.valueOf(1), Reduction.reduce(List.of(1)));
        assertEquals(Integer.valueOf(6), Reduction.reduce(List.of(1, 2, 3)));
        assertEquals(Integer.valueOf(24), Reduction.reduce(List.of(1, 2, 3, 4)));
    }
}
