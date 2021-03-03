public class Card
{
   public enum Suit { clubs, diamonds, hearts, spades }
   private char value;
   private Suit suit;
   private boolean errorFlag = false;
   
   //****************************************
   //constructors
   public Card(char value, Suit suit)
   {
      set(value, suit);
   }
   public Card(char value)
   {
      set(value, Suit.spades);
   }
   public Card()
   {
      set('A', Suit.spades);
   }
   
   public Card(Card card)
   {
      set(card.value, card.suit);
   }
   //****************************************
   
   //Method
   public boolean set(char value, Suit suit)
   {
      this.suit = suit;
      
      if(Card.isValid(value, suit))
      {
         this.value = value;
         errorFlag = false;
      }
      else
      {
         errorFlag = true;
         this.value = 'A';
      }
      
      return errorFlag;
   }
   
   public String toString()
   {
      String retVal;
      if(!errorFlag)
      {
         retVal = String.valueOf(value) + " of " + suit;
      }
      else
      {
         retVal = "Error";
      }
      
      return retVal;
   }
   
   public boolean equals(Card card)
   {
      if(this.value != card.value)
      {
         return false;
      }
      if(this.suit != card.suit)
      {
         return false;
      }
      if(this.errorFlag != card.errorFlag)
      {
         return false;
      }
      else
      {
         return true;
      }
   }
   
   //****************************************
   //Accessors 
   public char getVal()
   {
      return value;
   }
   public Suit getSuit()
   {
      return suit;
   }
   public boolean getFlag()
   {
      return errorFlag;
   }
   //****************************************

   //static method
   private static boolean isValid(char value, Suit suit)
   {
      char upVal = Character.toUpperCase(value);
      
      if(upVal == 'A' || upVal == 'K'
            || upVal == 'Q' || upVal == 'J'
            || upVal == 'T'
            || (upVal >= '2' && upVal <= '9'))
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
}