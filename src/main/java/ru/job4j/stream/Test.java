package ru.job4j.stream;

import java.util.List;

public class Test {
    public static long sum(List<Character> characters) {
      long x =  characters.stream().mapToInt(Character::charValue).sum();
        return x;
    }
}
