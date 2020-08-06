package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matches = 11;
        System.out.println("Количество спичек : " + matches);
        while (true) {
            System.out.println("Очередь User1");
            int user1 = Integer.valueOf(input.nextLine());
            while (user1 > 3  || user1 < 1 || user1 > matches) {
                System.out.println("Введите корректое значение");
                 user1 = Integer.valueOf(input.nextLine());
            }
            matches = matches - user1;
            System.out.println("User1 забрал " + user1 + " спичек. Осталось " + matches);
            if (matches == 0) {
                System.out.println("User1 победил!");
                break;
            }
            System.out.println("Очередь User2");
            int user2 = Integer.valueOf(input.nextLine());
            while (user2 > 3  || user2 < 1 || user2 > matches) {
                System.out.println("Введите корректое значение");
                user2 = Integer.valueOf(input.nextLine());
            }
            matches = matches - user2;
            System.out.println("User2 забрал " + user2 + " спичек. Осталось " + matches);
            if (matches == 0) {
                System.out.println("User2 победил!");
                break;
            }
        }
    }
}
