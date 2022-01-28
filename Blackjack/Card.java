package Blackjack;
public class Card {
    private String name;
    private String suit;
    private int value;

    public Card(String name, String suit, int value) {
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    public String GetName() {
        return this.name;
    }

    public String GetSuit() {
        return this.suit;
    }

    public int GetValue() {
        return this.value;
    }

    public String getCardName() {
        return this.name + " of " + this.suit;
    }
}
