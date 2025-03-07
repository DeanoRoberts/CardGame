// Card game by Deano Roberts

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Deck {
    // Array list to hold deck of cards
    private ArrayList<Card> cards;
    // Keeps track of how many cards are left in the deck
    private int cardsLeft;

    // Constructor for Deck class
    public Deck(String[] rank, String[] suit, int[] value, GameViewer window) {
        cards = new ArrayList<Card>();
        // fills deck with rank and suit and value
        int counter = 1;
        for (int i = 0; i < rank.length; i++) {
            for (String s : suit) {
                String f = "Resources/Cards/" + counter + ".png";
                counter++;
                // Adds the card to the deck
                cards.add(new Card(rank[i], s, value[i], new ImageIcon(f).getImage(), window));
            }

        }
        // Makes the number of cards left equal to total size
        cardsLeft = cards.size();
    }

    // Sees if deck is empty
    public boolean isEmpty() {
        return cardsLeft == 0;
    }

    // Gets num cards left
    public int getCardsLeft() {
        return cardsLeft;
    }

    // Deals a card
    public Card deal() {
        if (cardsLeft == 0) {
            return null;
        } else {
            cardsLeft--;
            return cards.get(cardsLeft);
        }
    }

    // Shuffles the deck
    public void shuffle() {
        Card b;
        for (int i = cards.size() - 1; i > 0; i--) {
            int r = (int) (Math.random() * i);
            b = cards.get(i);
            cards.set(i, cards.get(r));
            cards.set(r, b);
        }
    }
}
