// Card game by Deano Roberts

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private GameViewer window;
    private int state;
    private Deck deck;

    private Player p1;
    private Player p2;

    // Constructor for our Game class
    public Game(String[] ranks, String[] suits, int[] values) {
        state = 0;
        window = new GameViewer(this);

        // creates the deck and players for our game
        deck = new Deck(ranks, suits, values, window);
        p1 = new Player("player 1", new ArrayList<>());
        p2 = new Player("Player 2", new ArrayList<>());

        // Repaints window to update changes
        window.repaint();

    }

    // Getter for Player1
    public Player getP1() {
        return p1;
    }

    // Getter for Player2
    public Player getP2() {
        return p2;
    }

    // Getter For Player 2
    public int getState() {
        return state;
    }

    // Prints the instructions
    public void printInstructions() {

        System.out.println("Today you will be playing 21!");
        System.out.println("type 1 to continue");
        Scanner scanner = new Scanner(System.in);
        boolean notValidInput = true;
        // Prompts the user until there is a valid input
        while (notValidInput) {
            String answer = scanner.nextLine();

            if (answer.equals("1")) {
                state = 1;
                break;
            } else {
                System.out.println("type 1 to continue");
            }
        }
        window.repaint();

    }

    // Our main method to run our game
    public void playGame() {
        state = 1;
        // Shuffles deck
        deck.shuffle();
        // Plays each players turn and gets there score
        int p1Score = turn(p1);
        int p2Score = turn(p2);
        // Find out who won based on players scores
        whoWon(p1Score, p2Score);


    }

    // Runs the turn of a player
    private int turn(Player player) {
        int score = 0;
        boolean playing = true;
        Scanner scanner = new Scanner(System.in);

        while (playing) {
            // Deals a card to the player form the created deck
            Card card = deck.deal();
            // Adds it to there hand
            player.addCard(card);
            // Add the points of the score
            player.addPoints(card.getPoints());
            score += card.getPoints();
            window.repaint();
            // Tells then what they drew and how much it is worth
            System.out.println(player.getName() + " drew a " + card.getRank() + " of " + card.getSuit());
            System.out.println("Your score is a " + score);
            // Sees if they went over 21
            if (score > 21) {
                System.out.println("You went over 21 :(");
                break;
            }
            // Created to score user input
            String answer;
            // Checks to see if valid input, if not prompts them tell they do
            while (true) {
                System.out.println("Would you like to draw another card?(yes or no)");
                answer = scanner.nextLine();
                if (answer.equals("yes")) {
                    break;
                } else if (answer.equals("no")) {
                    playing = false;
                    break;
                } else {
                    System.out.println("Enter a valid input (yes or no).");
                }
            }


        }
        // Returns total score of player
        return score;
    }

    // Figures out who won based on the score
    private void whoWon(int p1Score, int p2Score) {
        if (p1Score > 21 && p2Score <= 21) {
            System.out.println("Player 2 win!");
            state = 2;
        } else if (p2Score > 21 && p1Score <= 21) {
            System.out.println("Player 1 win!");
            state = 2;
        } else if (p1Score > 21 && p2Score > 21) {
            System.out.println("You both lose! :(");
            state = 2;
        } else if (p1Score > p2Score && p1Score <= 21) {
            System.out.println("Player 1 win!");
            state = 2;
        } else if (p2Score > p1Score && p2Score <= 21) {
            System.out.println("Player 2 win!");
            state = 2;
        } else {
            System.out.println("You tied!");
            state = 2;
        }

        window.repaint();
    }

    // Gets the end message for the game
    public String getEndMessage() {
        int p1Score = p1.getPoints();
        int p2Score = p2.getPoints();

        if (p1Score > p2Score && p1Score <= 21) {
            return "Player 1 Wins!";
        } else if (p2Score > p1Score && p2Score <= 21) {
            return "Player 2 Wins!";

        } else if (p1Score > 21 && p2Score <= 21) {
            return "Player 2 Wins!";
        } else if (p2Score > 21 && p1Score <= 21) {
            return "Player 1 Wins!";
        } else if (p1Score > 21 && p2Score > 21) {
            return "You both lost! : (";
        } else {
            return "You Tied! :(";
        }


    }


    public static void main(String[] args) {
        // Creates array list so we can create all our cards
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

        // Creates a new game
        Game game = new Game(ranks, suits, values);
        // Prints the game instructions
        game.printInstructions();
        // Plays the game
        game.playGame();

    }

    // Getter for the deck
    public Deck getDeck() {
        return deck;
    }
}






