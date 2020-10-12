package ru.job4j.stream;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StudentLevelTest {
    @Test
    public void whenSorted() {
        List<Student> input = new ArrayList<>();
        input.add(new Student(28, "Masha"));
        input.add(new Student(128,"Petya"));
        List<Student> expected = List.of(
                new Student(128, "Petya"),
                new Student(28, "Masha")
        );
        assertThat(StudentLevel.levelOf(input, 20), is(expected));
    }

    @Test
    public void whenOnlyNull() {
        List<Student> input = new ArrayList<>();
        input.add( null);
        List<Student> expected = List.of();
        assertThat(StudentLevel.levelOf(input, 100), is(expected));
    }

    @Test
    public void whenHasNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        input.add(new Student(28,"Petya"));
        List<Student> expected = List.of(new Student(28,"Petya"));
        assertThat(StudentLevel.levelOf(input, 10), is(expected));
    }

    @Test
    public void whenSelection() {
        List<Student> input = new ArrayList<>();
        input.add(new Student(33, "Dasha"));
        input.add(new Student(72,"Mitya"));
        input.add(null);
        input.add(new Student(83,"Tolya"));
        input.add(new Student(42,"Vanya"));
        input.add(null);
        input.add(new Student(99,"Jenya"));
        input.add(new Student(59,"Seryoja"));
        input.add(new Student(37,"Jora"));
        input.add(new Student(75,"Nastia"));
        input.add(new Student(48,"Olya"));
        input.add(null);
        input.add(new Student(61,"Toma"));
        List<Student> expected = List.of(
                new Student(99,"Jenya"),
                new Student(83,"Tolya"),
                new Student(75,"Nastia"),
                new Student(72,"Mitya"),
                new Student(61,"Toma"),
                new Student(59,"Seryoja")
        );
        assertThat(StudentLevel.levelOf(input, 50), is(expected));
    }
}
