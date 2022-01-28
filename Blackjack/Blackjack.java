package Blackjack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Blackjack {

    String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
    String[] cardNames = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
            "Queen", "King" };
    ArrayList<Card> deck = new ArrayList<Card>();
    ArrayList<Card> playerHand = new ArrayList<Card>();
    ArrayList<Card> dealerHand = new ArrayList<Card>();
    int currentPlayer = 0;
    int player = 0;
    int dealer = 1;
    int currentCard = 0;
    Scanner scanner = new Scanner(System.in);
    int playerScore = 0;
    int dealerScore = 0;

    public static void main(String[] args) {
        new Blackjack();
    }

    Blackjack() {
        CreateDeck();
        ShuffleDeck();
        NewDeal();
        Turn();
        TogglePlayer();
        Turn();
        Compare();
        scanner.close();
    }

    public void CreateDeck() {
        for (String suit : suits) {
            int i = 1;
            for (String card : cardNames) {
                if (i > 10) {
                    deck.add(new Card(card, suit, 10));
                } else {
                    deck.add(new Card(card, suit, i));
                }
                i++;
            }
        }
    }

    public void ShuffleDeck() {
        Collections.shuffle(deck);
    }

    public void PrintDeck() {
        for (Card card : deck) {
            System.out.println(card.getCardName());
        }
    }

    public void NewDeal() {
        playerHand.add(TakeCard());
        dealerHand.add(TakeCard());
        playerHand.add(TakeCard());
        dealerHand.add(TakeCard());
    }

    public void Turn() {
        String who;
        int currentScore;
        ArrayList<Card> currentHand = new ArrayList<Card>();
        if (currentPlayer == 0) {
            who = "Player";
            currentHand = playerHand;
            currentScore = playerScore;
        } else {
            who = "Dealer";
            currentHand = dealerHand;
            currentScore = dealerScore;
        }
        System.out.printf("%s's turn. Current hand:\n", who);
        for (Card card : currentHand) {
            System.out.println(card.getCardName());
            currentScore += card.GetValue();
        }
        System.out.println("Would you like to hit(1) or stay(2)?");
        int choice = scanner.nextInt();
        if (choice == 2) {
            currentScore = Stay(currentHand);
            System.out.printf("%s's final score: %d\n", who, currentScore);
            return;
        } else {
            currentHand.add(TakeCard());
            int score = 0;
            for (Card card : currentHand) {
                score += card.GetValue();
                if (score > 21) {
                    currentScore = 0;
                    System.out.println("You've bust!");
                    return;
                }
            }
            Turn();

        }
    }

    

    public int Stay(ArrayList<Card> currentHand) {
        int score = 0;
        for (Card card : currentHand) {
            score += card.GetValue();
        }
        for (Card card : currentHand) {
            if (card.GetValue() == 1) {
                if (score + 10 < 22) {
                    score += 10;
                }
            }
        }
        return score;
    }

    public void Compare() {
        if (playerScore > dealerScore) {
            System.out.println("You Win!");
        } else {
            System.out.println("The House Wins!");
        }
    }

    public Card TakeCard() {
        return deck.remove(0);

    }

    public void TogglePlayer() {
        if (currentPlayer == 0) {
            currentPlayer = 1;
        } else {
            currentPlayer = 0;
        }
    }
}
