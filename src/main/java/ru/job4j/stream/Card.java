package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }

    public static void main(String[] args) {
      List<Card> deck = Stream.of(Suit.values()).
              flatMap(suit1 -> Stream.
                      of(Value.values()).
              map(value1 -> new Card(suit1, value1))).
              collect(Collectors.toList());
        deck.forEach(System.out::println);
    }

}
