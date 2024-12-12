import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        // creates array list so we can create all our cards
        String[] ranks = {"King", "Queen", "Ace", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        int[] values = {10, 10, 1, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        // creates a new game
        Game game = new Game(ranks, suits, values);
        // prints the game instructions
        game.printInstructions();
        // plays the game
        game.playGame();

    }

}
