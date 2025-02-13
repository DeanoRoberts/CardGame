import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameViewer extends JFrame
{
    private Game game;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 1000;
    private final int TITLE_BAR_HEIGHT = 23;

    public  GameViewer(Game game)
    {
        this.game = game;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("CardGame");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);

    }

    public void paint(Graphics g)
    {
        if (game.getState() == 0)
        {
            String instructions = "  Today you will be playing 21!\n" + "type 1 to continue";
            g.drawString(instructions, 100, 100);
        }

        if (game.getState() == 1)
        {
            game.getDeck().deal().draw(g);
        }

    }
}
