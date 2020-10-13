package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> combine = person -> {
            Predicate<Person> name1 = (value) -> value.getName().equals(key);
            Predicate<Person> name2 = (value) -> value.getSurname().equals(key);
            Predicate<Person> name3 = (value) -> value.getPhone().equals(key);
            Predicate<Person> name4 = (value) -> value.getAddress().equals(key);
            return name1.or(name2).or(name3).or(name4).test(person);
        };
        var result = new ArrayList<Person>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
