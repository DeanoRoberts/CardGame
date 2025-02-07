import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameViewer extends JFrame
{
    private Game game;
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private final ArrayList<Image> cardImages;

    public void GameViewer(Game game)
    {
        this.game = game;
        for (int i = 0; i < 52; i++)
        {
            String f = "Resources/" + i + ".png";
            cardImages.add(new ImageIcon(f).getImage());
        }
    }
}
