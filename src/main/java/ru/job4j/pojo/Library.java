package ru.job4j.pojo;

import org.w3c.dom.ls.LSOutput;

public class Library {
    public static void main(String[] args) {
        Book schildt = new Book("Schildt", 1500);
        Book horstmann = new Book("Horstmann", 1700);
        Book eckel = new Book("Eckel", 1200);
        Book cleancode = new Book("Clean code", 750);
        Book[] books = new Book[4];
        books[0] = schildt;
        books[1] = horstmann;
        books[2] = eckel;
        books[3] = cleancode;
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " - " + books[index].getCount());
        }
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        System.out.println("Replace schildt to cleancode.");
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " - " + books[index].getCount());
        }
        System.out.println("Shown only book.name \"Clean code\"");
        for (int index = 0; index < books.length; index++) {
            if (books[index].getName().equals("Clean code")) {
                System.out.println(books[index].getName() + " - " + books[index].getCount());
            }
        }
    }
}