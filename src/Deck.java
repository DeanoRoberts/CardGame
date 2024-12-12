import java.util.ArrayList;

public class Deck {
    // array list to hold deck of cards
    private ArrayList<Card> cards;
    private int cardsLeft;

    // Constructor for deck
    public Deck(String[] rank, String[] suit, int[] value) {
        cards = new ArrayList<Card>();
        // fills deck with rank and suit and value
        for (int i = 0; i < rank.length; i++) {
            for (String s : suit) {
                cards.add(new Card(rank[i], s, value[i]));
            }

        }
        // makes the number of cards left equal to total size
        cardsLeft = cards.size();
    }

    // sees if deck is empty
    public boolean isEmpty() {
        if (cardsLeft == 0) {
            return true;
        } else {
            return false;

        }
    }

    // gets num cards left
    public int getCardsLeft() {
        return cardsLeft;
    }

    // deals a card
    public Card deal() {
        if (cardsLeft == 0) {
            return null;
        } else {
            cardsLeft--;
            return cards.get(cardsLeft);
        }
    }

    // shuffles the deck
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
