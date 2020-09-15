package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorDecreaseByNameAndPriority() {
        Comparator<Job> comboDecrNameAndDecrPriority = new JobDecrByName().thenComparing(new JobDecrByPriority());
        int rsl = comboDecrNameAndDecrPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorIncreaseByNameAndPriority() {
        Comparator<Job> comboIncrNameAndIncrPriority = new JobIncrByName().thenComparing(new JobIncrByPriority());
        int rsl = comboIncrNameAndIncrPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorIncreaseByNameAndDecreasePriority() {
        Comparator<Job> comboIncrNameAndDecrPriority = new JobIncrByName().thenComparing(new JobDecrByPriority());
        int rsl = comboIncrNameAndDecrPriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorDecreaseByNameAndIncreasePriority() {
        Comparator<Job> comboDecrNameAndIncrPriority = new JobDecrByName().thenComparing(new JobIncrByPriority());
        int rsl = comboDecrNameAndIncrPriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorDecreaseByName() {
        Comparator<Job> compDecrName = new JobDecrByName();
        int rsl = compDecrName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorIncreaseByName() {
        Comparator<Job> compIncrName = new JobIncrByName();
        int rsl = compIncrName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorDecreaseByPriority() {
        Comparator<Job> compDecrPriority = new JobDecrByPriority();
        int rsl = compDecrPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorIncreaseByPriority() {
        Comparator<Job> compIncrPriority = new JobIncrByPriority();
        int rsl = compIncrPriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}
