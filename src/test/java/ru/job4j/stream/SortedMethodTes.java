package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;


public class SortedMethodTes {
    @Test
    public void test() {
        assertEquals(
                List.of("a", "b", "c"),
                SortedMethod.sorted(List.of("c", "b", "a"))
        );
    }
}
