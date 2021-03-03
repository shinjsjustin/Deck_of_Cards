
public class Deck
{
   private static final int MAX_PACKS = 6;
   private static final int NUM_CARDS_PER_PACK = 52;
   private static final int MAX_CARDS_PER_DECK = MAX_PACKS * NUM_CARDS_PER_PACK;
   private static Card[] staticPack = new Card[NUM_CARDS_PER_PACK];
   
   private int numPacks;
   private int total;
   private Card[] cards;
   
   
   
   public static Card errorCard = new Card ('E', Card.Suit.spades);
   
   //**************************************************
   //Constructors
   public Deck(int n)
   {
      this.numPacks = n;
      this.total = numPacks*NUM_CARDS_PER_PACK;
      cards = new Card[MAX_CARDS_PER_DECK];
      allocateStaticPack();
      restock(numPacks);
   }
   public Deck()
   {
      this.numPacks = 1;
      this.total = numPacks*NUM_CARDS_PER_PACK;
      cards = new Card[MAX_CARDS_PER_DECK];
      allocateStaticPack();
      restock(numPacks);
   }
   //**************************************************
   
   //**************************************************
   //Private method
   private static void allocateStaticPack()
   {
      staticPack = new Card[NUM_CARDS_PER_PACK];
      
      int k,j;
      Card.Suit st;
      char val;
      
      for(k=0; k<NUM_CARDS_PER_PACK; k++)
      {
         staticPack[k] = new Card();
      }
      for(k = 0; k < 4; k++)
      {
         switch(k)
         {
            case 0:
               st = Card.Suit.diamonds;
               break;
            case 1:
               st = Card.Suit.clubs;
               break;
            case 2:
               st = Card.Suit.hearts;
               break;
            case 3:
               st = Card.Suit.spades;
               break;
            default:
               st = Card.Suit.spades; 
               break;
         }
         staticPack[13*k].set('A', st);
         for(val = '2', j=1; val <= '9'; val++, j++)
         {
            staticPack[13*k+j].set(val,  st);
         }
         staticPack[13*k+9].set('T',  st);
         staticPack[13*k+10].set('J',  st);
         staticPack[13*k+11].set('Q',  st);
         staticPack[13*k+12].set('K',  st);
         
      }
   }
   //**************************************************
   
   //**************************************************
   //public methods
   public boolean restock(int numPacks)
   {
      this.numPacks=numPacks;
      this.total = numPacks*NUM_CARDS_PER_PACK;
      if(numPacks < 1 || numPacks > MAX_PACKS)
      {
         return false;
      }
      else
      {
         for(int i=0; i<numPacks; i++)
         {
            for(int j=0; j<NUM_CARDS_PER_PACK; j++)
            {
               cards[i*NUM_CARDS_PER_PACK+j] = staticPack[j];
            }
         }
         return true;
      }
   }
   
   public void shuffle()
   {
      for(int i=total-1; i>0; i--)
      {
         int rand = (int)(Math.random()*(i+1));
         
         Card temp = cards[i];
         cards[i] = cards[rand];
         cards[rand] = temp;
      }
   }
   
   public Card getTopCard()
   {
      if(total == 0)
      {
         return errorCard;
      }
      else
      {
         return cards[--total];
      }
   }
   
   public Card getCard(int k)
   {
      if(k >= total || k < 0)
      {
         return errorCard;
      }
      else
      {
         return cards[k];
      }
   }
   
   public String toString()
   {
      int k;
      String retVal = "Deck: (";
      for(k=0; k<total; k++)
      {
         retVal += cards[k].toString();
         if(k<total-1)
         {
            retVal += " / ";
         }
      }
      retVal += ")";
      return retVal;
   }
   //**************************************************
   
   //**************************************************
   //Accessors
   public int getNumCards()
   {
      return total;
   }
   public int getNumPacks()
   {
      return numPacks;
   }
   //**************************************************
}
