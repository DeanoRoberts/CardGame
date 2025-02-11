import javax.swing.*;
import java.awt.*;

public class Card {
    private String rank;
    private String suit;
    private int points;
    private Image image;
    private GameViewer window;

    private final int CARD_IMAGE_WIDTH = 965;
    private final int CARD_IMAGE_HEIGHT = 1358;


    // constructor for card
    public Card(String rank, String suit, int points, Image image, GameViewer window) {
        this.rank = rank;
        this.suit = suit;
        this.points = points;
        this.image = image;
        this.window = window;

    }

    public void draw(Graphics g)
    {


        g.drawImage(image, 		// image to draw
                50, 50, 	// (x, y) of upper left corner in output window
                CARD_IMAGE_WIDTH / 2, CARD_IMAGE_HEIGHT / 2,	// width, height
                window);

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
