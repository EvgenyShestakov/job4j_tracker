package ru.job4j.oop;

public class Cat {
    private  String food;
    private String name;
    public static void main(String[] args) {
        Cat gav = new Cat();
        Cat black = new Cat();
        gav.giveNick("Gav");
        gav.eat("cutlet");
        black.giveNick("Black");
        black.eat("fish");
        gav.show();
        black.show();
    }

    void giveNick(String nick) {
        this.name = nick;
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void show() {
        System.out.println(this.name + " eats a " + this.food);
    }

}
