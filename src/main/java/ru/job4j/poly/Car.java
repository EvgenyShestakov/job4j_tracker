package ru.job4j.poly;

public class Car implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автомобиль едет по трассе");
    }

    @Override
    public void stop() {
        System.out.println("Автомобиль останавливается");
    }
}
