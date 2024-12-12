public class Card {
    private String rank;
    private String suit;
    private int points;

    // constructor for card
    public Card(String rank, String suit, int points) {
        this.rank = rank;
        this.suit = suit;
        this.points = points;
    }

    // getter for card rank
    public String getRank() {
        return rank;
    }

    // getter for card suit
    public String getSuit() {
        return suit;
    }

    // getter for card points
    public int getPoints() {
        return points;
    }

    // setter for card rank
    public void setRank(String rank) {
        this.rank = rank;
    }

    // setter for card suit
    public void setSuit(String suit) {
        this.suit = suit;
    }

    // setter for card points
    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
