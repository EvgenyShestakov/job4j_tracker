package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Bear bear = new Bear();
        Fox fox = new Fox();
        hare.tryEat(ball);
        ball.runAway(ball);
        wolf.tryEat(ball);
        ball.runAway(ball);
        bear.tryEat(ball);
        ball.runAway(ball);
        fox.eat(ball);
    }
}
