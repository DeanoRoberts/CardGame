// Card game by Deano Roberts

import java.awt.*;

public class Card {
    private String rank;
    private String suit;
    private int points;
    private Image image;
    private GameViewer window;


    private final int CARD_IMAGE_WIDTH = 965;
    private final int CARD_IMAGE_HEIGHT = 1358;


    // Constructor for the Card Class
    public Card(String rank, String suit, int points, Image image, GameViewer window) {
        this.rank = rank;
        this.suit = suit;
        this.points = points;
        this.image = image;
        this.window = window;

    }

    // Draws the card on the screen at the specified (x, y) position
    public void draw(Graphics g, int x, int y) {

        g.drawImage(image,        // Image to draw
                x, y,    // (x, y) of upper left corner in output window
                CARD_IMAGE_WIDTH / 4, CARD_IMAGE_HEIGHT / 4,    // Scaled width, height
                window);


    }

    // Getter for card rank
    public String getRank() {
        return rank;
    }

    // Getter for card suit
    public String getSuit() {
        return suit;
    }

    // Getter for card points
    public int getPoints() {
        return points;
    }

    // Setter for card rank
    public void setRank(String rank) {
        this.rank = rank;
    }

    // Setter for card suit
    public void setSuit(String suit) {
        this.suit = suit;
    }

    // Setter for card points
    public void setPoints(int points) {
        this.points = points;
    }

    // Overrides the toString method
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
