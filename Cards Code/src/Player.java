
import java.util.Scanner;

public class Player
{
   public static void main(String[] args)
   {
      Deck playerDeck = new Deck();
      playerDeck.shuffle();
      
      Scanner keyboard = new Scanner(System.in);
      int numPlayers = 0;
      System.out.println("How many players? ");
      if(keyboard.hasNextInt())
      {
         numPlayers = keyboard.nextInt();
         keyboard.hasNextLine();
      }
      else
      {
         System.out.println("Please enter a number.");
      }
      
      //Up to here is fine... problems below
      
      Hand[] playerArray = new Hand[numPlayers];
      for(int m=0; m<numPlayers; m++)
      {
         playerArray[m] = new Hand();
      }
      
      int dividedBy = playerDeck.getNumCards()/numPlayers;
      int remainderBy = playerDeck.getNumCards()%numPlayers;
      
      
      for(int m=0; m<numPlayers; m++)
      {
         for(int i=0; i < dividedBy; i++)
         {
            playerArray[m].takeCard(playerDeck.getTopCard());
         }
      }
      
      for(int n=0; n<remainderBy; n++)
      {
         playerArray[n].takeCard(playerDeck.getTopCard());
      }
      
      for(int j=0; j<numPlayers; j++)
      {
         System.out.println(playerArray[j].toString());
         System.out.println("number of cards: " + playerArray[j].getNumCards());
      }
      
      
      
      keyboard.close();
   }
}
//Enum for suit