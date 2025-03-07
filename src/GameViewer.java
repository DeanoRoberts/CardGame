// Card game by Deano Roberts

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameViewer extends JFrame {
    private Game game;
    // Window width for game
    private final int WINDOW_WIDTH = 1000;
    // Window height for game
    private final int WINDOW_HEIGHT = 1000;

    // Constructor for the Game Viewer class
    public GameViewer(Game game) {
        this.game = game;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("CardGame");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);

    }

    // Our paint method the handles the drawing of our window
    public void paint(Graphics g) {
        // Resets the background for our game to white
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // If the game state is 0(the start of the game), it will display the instructions
        if (game.getState() == 0) {
            String instructions = "  Today you will be playing 21!\n" + "" + "type 1 to continue";
            g.setColor(Color.BLACK);
            g.drawString(instructions, 100, 100);
        }
        // If the game state is 1( the game is playing), it will print the cards of the players hands
        if (game.getState() == 1) {
            Player p1 = game.getP1();
            Player p2 = game.getP2();
            g.setColor(Color.BLACK);

            // Draws players 1 cards
            for (int i = 0; i < p1.getHand().size(); i++) {
                p1.getHand().get(i).draw(g, 100 + i * 100, 75);
                g.drawString("Its player 1's turn", 300, 470);

            }
            // Draws player 2 cards
            for (int i = 0; i < p2.getHand().size(); i++) {
                p2.getHand().get(i).draw(g, 100 + i * 100, 600);
                g.setColor(Color.WHITE);
                g.fillRect(300, 460, 300, 40);
                g.setColor(Color.BLACK);
                g.drawString("Its player 2's turn", 300, 470);
            }

            // Draw titles for P1 and P2
            g.setColor(Color.BLACK);
            g.drawString("P1:", 30, 250);
            g.drawString("P2:", 30, 800);
            g.drawString("Would you like another card? (yes/no)", 300, 500);


        }
        // If the game state is 2(the end of the game), it will print game over screen
        if (game.getState() == 2) {
            g.setColor(Color.BLACK);
            // Draws winner message
            g.drawString("The Game is Over! " + game.getEndMessage(), 350, 400);

        }

    }
}
