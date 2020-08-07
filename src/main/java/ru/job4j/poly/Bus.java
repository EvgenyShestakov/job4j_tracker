package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int quantity) {
        System.out.println("В автобус село " + quantity + "людей");
    }

    @Override
    public int fill(int liters) {
        return liters * 48;
    }
}
