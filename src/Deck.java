import java.util.ArrayList;

public class Deck
{
    private ArrayList<Card> cards;
    private int cardsLeft;

    public Deck(String[] rank, String[] suit, int[] value)
    {
        cards = new ArrayList<Card>();

       for (int i = 0; i < rank.length; i++)
        {
            for (String s : suit)
            {
                cards.add(new Card(rank[i],s,value[i]));
            }

        }

        cardsLeft = cards.size();
    }

    public boolean isEmpty()
        {
        if (cardsLeft == 0)
        {
            return true;
        }
        else
        {
            return false;

        }
    }

    public int getCardsLeft()
    {
        return  cardsLeft;
    }

    public Card deal()
    {
        if(cardsLeft == 0)
        {
            return null;
        }
        else
        {
            return cards.get(cardsLeft);
        }
    }

    public  void shuffle()
    {
        for (int i = 0; i < cards.size(); i++)
        {
            double r = (Math.random() );

        }
    }
}
