package ru.job4j.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Merge {
    public static Map<Integer, String> collectData(Map<Integer, String> names, List<User> users) {
        Map<Integer, String> map = new HashMap<>(names);
        for (User user : users) {
        if (map.containsKey(user.id)) {
        map.merge(user.id, user.surname, (s, s2) -> s + " " + s2);
        } else {
        map.putIfAbsent(user.id, user.name + " " + user.surname);
        }
        }
        return map;
    }

    public static class User {
        private int id;
        private String name;
        private String surname;

        public User(int id, String name, String surname) {
            this.id = id;
            this.name = name;
            this.surname = surname;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}
