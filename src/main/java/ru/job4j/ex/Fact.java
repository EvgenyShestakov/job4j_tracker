package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
Fact fact = new Fact();
fact.calc(-1);
    }

    public int calc(int n) {
        if (n < 0) {
            throw  new IllegalArgumentException("n must not be less than 0");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
