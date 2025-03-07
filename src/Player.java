// Card game by Deano Roberts

import java.util.ArrayList;

public class Player {
    // Creates arraylist for hand to hold cards
    private ArrayList<Card> hand;
    private int points;
    private String name;

    // Constructor for player with empty hand
    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    // Second constructor for player with  hand
    public Player(String name, ArrayList<Card> hand) {
        this.hand = new ArrayList<>();
        this.name = name;
        points = 0;

    }

    // Getter for points
    public int getPoints() {
        return points;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for hand
    public ArrayList<Card> getHand() {
        return hand;
    }

    // Adds points
    public void addPoints(int points) {
        this.points = this.points + points;

    }

    // Adds a card to hand
    public void addCard(Card card) {
        hand.add(card);
    }


    public String toString() {
        return name + "has" + points + "points" + name + "'s cards: " + hand;
    }
}
