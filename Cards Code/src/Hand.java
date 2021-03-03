

public class Hand
{
   private static final int MAX_CARDS = 30;
   private int numCards;
   private Card[] myCards;
   
   //Default constructor
   public Hand()
   {
      myCards = new Card[MAX_CARDS];
      resetHand();
   }
   
   //empty array
   public void resetHand()
   {
      numCards=0;
   }

   //Into hand
   public boolean takeCard(Card card)
   {
      if(numCards >= MAX_CARDS)
      {
         return false;
      }
      
      if(myCards[numCards]==null)
      {
         myCards[numCards] = new Card();
      }
      myCards[numCards++].set(card.getVal(), card.getSuit());
      return true;
   }
   
   //Out of hand
   public Card playCard()
   {
      Card errorCard = new Card('E', Card.Suit.spades);
      
      if(numCards == 0)
      {
         return errorCard;
      }
      else
      {
         return myCards[--numCards];
      }
   }
   
   //Accessor
   public int getNumCards()
   {
      return numCards;
   }
   
   //To String
   public String toString()
   {
      int k;
      String retVal = "Hand =  ( ";

      for (k = 0; k < numCards; k++)
      {
         retVal += myCards[k].toString();
         if (k < numCards - 1)
         {
            retVal += " | ";
         }
      }
      retVal += " )";
      return retVal;
   }
   
   //Method to inspect a specific card
   public Card inspectCard(int k)
   {
      if(myCards[k].getFlag())
      {
         System.out.println("Bad card.");
      }
      return myCards[k];
   }
}