public class Card
{
    private String rank;
    private String suit;
    private int points;

    public Card(String rank, String suit, int points) {
        this.rank = rank;
        this.suit = suit;
        this.points = points;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getPoints() {
        return points;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
