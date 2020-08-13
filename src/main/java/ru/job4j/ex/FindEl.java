package ru.job4j.ex;

public class FindEl {
    public static void main(String[] args) {
        try {
            System.out.println(indexOf(new String[]{"Вася", "Толя", "Боря"}, "Саша"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
            }
        }
        if (rsl == -1) {
            throw  new ElementNotFoundException("Index not found");
        }
        return rsl;
    }
}
