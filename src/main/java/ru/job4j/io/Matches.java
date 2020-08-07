package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean player = true;
        int matches = 11;
        System.out.println("Количество спичек : " + matches);
        while (true) {
            String name = player ? "игрок1" : "игрок2";
                System.out.println("Очередь " + name);
                int count = Integer.valueOf(input.nextLine());
                while (count > 3  || count < 1) {
                    System.out.println("Введите корректое значение");
                    count = Integer.valueOf(input.nextLine());
                }
                matches = matches - count;
                System.out.println(name + " забрал " + count + " спичек. Осталось " + matches);
                if (matches <= 0) {
                    System.out.println(name + " победил!");
                    break;
                }
               player = !player;
        }
    }
}
