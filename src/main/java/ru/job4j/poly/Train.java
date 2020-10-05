package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поезд едет");
    }

    @Override
    public void stop() {
        System.out.println("Поезд включает торможение");
    }
}
