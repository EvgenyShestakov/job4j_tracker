package ru.job4j.oop;

public class Jukebox {
    public static void main(String[] args) {
    Jukebox singer = new Jukebox();
    singer.music(1);
    singer.music(2);
    singer.music(3);
    }

    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println( "Песня не найдена");
        }

    }
}
