import java.util.ArrayList;

public class Player {
    // creates arraylist for hand to hold cards
    private ArrayList<Card> hand;
    private int points;
    private String name;

    // constructor for player with empty hand
    public Player(String name) {
        this.name = name;
        points = 0;
    }

    // second constructor for player with  hand
    public Player(String name, ArrayList<Card> hand) {
        this.hand = new ArrayList<Card>();
        this.name = name;
        points = 0;

    }

    // getter for points
    public int getPoints() {
        return points;
    }

    // getter for name
    public String getName() {
        return name;
    }

    // getter for hand
    public ArrayList<Card> getHand() {
        return hand;
    }

    // adds points
    public void addPoints(int points) {
        this.points = this.points + points;

    }

    // adds a card to hand
    public void addCard(Card card) {
        hand.add(card);
    }


    public String toString() {
        return name + "has" + points + "points" + name + "'s cards: " + hand;
    }
}
