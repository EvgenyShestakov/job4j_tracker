package ru.job4j.collection;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String[] one = origin.split("[., :;!]");
        String[] two = line.split("[., :;!]");
        int count = 0;
        for (String a: two) {
            for (String b: one) {
                if (a.equals(b)) {
                    count++;
                    break;
                }
            }
        }
        return count == two.length;
    }
}
