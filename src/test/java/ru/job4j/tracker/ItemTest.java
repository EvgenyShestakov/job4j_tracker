package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void whenSort() {
        List<Item> list = Arrays.asList(new Item(3), new Item(1), new Item(4), new Item(2));
        List<Item> expected = Arrays.asList(new Item(1), new Item(2), new Item(3), new Item(4));
        Collections.sort(list, new SortItem());
        assertThat(list, is(expected));

    }

    @Test
    public void whenReverseSort() {
        List<Item> list = Arrays.asList(new Item(3), new Item(1), new Item(4), new Item(2));
        List<Item> expected = Arrays.asList(new Item(4), new Item(3), new Item(2), new Item(1));
        Collections.sort(list, new ReverseSortItem());
        assertThat(list, is(expected));
    }
}
