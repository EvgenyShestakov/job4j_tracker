package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    private List<Profile> profiles = new ArrayList<>();

    @Before
    public void setUp() {
        profiles.add(new Profile(new Address("Москва", "Тверская", 14, 23)));
        profiles.add(new Profile(new Address("Санкт - Петербург", "Невский", 5, 3)));
        profiles.add(new Profile(new Address("Самара", "Ленина", 10, 2)));
        profiles.add(new Profile(new Address("Мурманск", "Чкалова", 7, 24)));
        profiles.add(new Profile(new Address("Петрозаводск", "Набережная", 8, 56)));
        profiles.add(new Profile(new Address("Псков", "Новая", 4, 16)));
        profiles.add(new Profile(new Address("Москва", "Тверская", 15, 19)));
        profiles.add(new Profile(new Address("Белгород", "8 Марта", 9, 7)));
        profiles.add(new Profile(new Address("Самара", "Первомайская", 1, 30)));
        profiles.add(new Profile(new Address("Санкт - Петербург", "Лиговский", 17, 43)));
    }

    @Test
    public void whenFiltrationAddress() {
        Profiles prof = new Profiles();
        List<Address> rsl = prof.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Москва", "Тверская", 14, 23));
        expected.add(new Address("Санкт - Петербург", "Невский", 5, 3));
        expected.add(new Address("Самара", "Ленина", 10, 2));
        expected.add(new Address("Мурманск", "Чкалова", 7, 24));
        expected.add(new Address("Петрозаводск", "Набережная", 8, 56));
        expected.add(new Address("Псков", "Новая", 4, 16));
        expected.add(new Address("Белгород", "8 Марта", 9, 7));
        expected.sort((o1, o2) -> o1.getCity().compareTo(o2.getCity()));
        assertThat(rsl, is(expected));
    }
}