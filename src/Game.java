import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private GameViewer window;
    private int state;
    private Deck deck;

    private Player p1;
    private Player p2;


    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    // constructor for our Game class
    public Game(String[] ranks, String[] suits, int[] values) {
        state = 0;
        window = new GameViewer(this);

        // creates the deck for our game
        deck = new Deck(ranks, suits, values, window);

       p1 = new Player("player 1", new ArrayList<>());
       p2 = new Player("Player 2", new ArrayList<>());
       window.repaint();

    }

    public int getState() {
        return state;
    }

    // prints the instructions
    public void printInstructions() {

        System.out.println("Today you will be playing 21!");
        System.out.println("type 1 to continue");
        Scanner scanner = new Scanner(System.in);
        boolean notValidInput = true;

       while(notValidInput)
       {
           String answer = scanner.nextLine();

           if (answer.equals("1"))
           {
               state = 1;
               break;
           }else
           {
               System.out.println("type 1 to continue");
           }
       }

    }

    // our main method to run our game
    public void playGame() {
        state = 1;
        // shuffles deck
        deck.shuffle();
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
            Card card = deck.deal();
            // adds it to there hand
            player.addCard(card);
            // add the points of the score
            score += card.getPoints();
            window.repaint();
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


    public static void main(String[] args) {
        // creates array list so we can create all our cards
        String[] ranks = {"Ace", "2", "3", "4", "5","6","7","8", "9", "10","Jack", "Queen", "King"};
        String[] suits = {"Spades","Hearts","Diamonds", "Clubs"};
        int[] values = {1,2,3,4,5,6,7,8,9,10,11,12,13};

        // creates a new game
        Game game = new Game(ranks, suits, values);
        // prints the game instructions
        game.printInstructions();
        // plays the game
        game.playGame();

    }

    public Deck getDeck() {
        return deck;
    }
}






