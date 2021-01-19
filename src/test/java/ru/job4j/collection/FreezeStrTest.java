package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class FreezeStrTest {
    @Test
    public void whenEq() {
        assertThat(FreezeStr.eqArray("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq() {
        assertThat(FreezeStr.eqArray("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq() {
        assertThat(FreezeStr.eqArray("heloo", "hello"), is(false));
    }

    @Test
    public void whenEq2() {
        assertThat(FreezeStr.eqHashMap("Hello", "Hlloe"), is(true));
    }

    @Test
    public void whenNotEq2() {
        assertThat(FreezeStr.eqHashMap("Hello", "Halle"), is(false));
    }

    @Test
    public void whenNotMultiEq2() {
        assertThat(FreezeStr.eqHashMap("heloo", "hello"), is(false));
    }
}
