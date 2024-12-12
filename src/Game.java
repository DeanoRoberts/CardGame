import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    // creates array list so we can create all our cards
    private String[] ranks = {"King", "Queen", "Ace", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
    private String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private int[] values = {10, 10, 1, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    // creates the deck for our game
    Deck game = new Deck(ranks, suits, values);

    // constructor for our Game class
    public Game(String[] ranks, String[] suits, int[] values) {
        this.ranks = ranks;
        this.suits = suits;
        this.values = values;

    }
    // prints the instructions
    public void printInstructions() {
        System.out.println("Today you will be playing 21!");
        System.out.println("Player 1 will go first");

    }

    // our main method to run our game
    public void playGame() {
        // shuffles deck
        game.shuffle();
        // creates our two players
        Player p1 = new Player("player 1", new ArrayList<>());
        Player p2 = new Player("Player 2", new ArrayList<>());
        // plays each players turn and gets there score
        int p1Score = turn(p1);
        int p2Score = turn(p2);
        // find out who won based on players scores
        whoWon(p1Score, p2Score);


    }
    // runs the turn of a  player
    private int turn(Player player) {
        int score = 0;
        boolean playing = true;
        Scanner scanner = new Scanner(System.in);

        while (playing) {
            // deals a card to the player form the created deck
            Card card = game.deal();
            // adds it to there hand
            player.addCard(card);
            // add the points of the score
            score += card.getPoints();
            // tells then what they drew and how much it is worth
            System.out.println(player.getName() + " drew a " + card.getRank() + " of " + card.getSuit());
            System.out.println("Your score is a " + score);
            // sees if they went over 21
            if (score > 21) {
                System.out.println("You went over 21 :(");
                break;
            }
            // created to score user input
            String answer;
           // checks to see if valid input, if not prompts them tell they do
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
        // returns total score of player
        return score;
    }
    // figures out who won based on the score
    private void whoWon(int p1Score, int p2Score) {
        if (p1Score > 21 && p2Score < 21) {
            System.out.println("Player 2 win!");
        } else if (p2Score > 21 && p1Score < 21) {
            System.out.println("Player 1 win!");
        } else if (p1Score > 21 && p2Score > 21) {
            System.out.println("You both lose! :(");
        } else if (p2Score > p1Score) {
            System.out.println("Player 2 win!");
        } else if (p1Score > p2Score) {
            System.out.println("Player 1 win!");
        } else {
            System.out.println("You tied!");
        }
    }

}






