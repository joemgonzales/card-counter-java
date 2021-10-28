import java.util.Scanner;
import java.io.*;

public class CardCounter{
    
    public static void main (String[] args){
        CardTiers highCards = new CardTiers();
        CardTiers neutralCards = new CardTiers();
        CardTiers lowCards = new CardTiers();
        RunningCount avgCount = new RunningCount();
        Probability probability = new Probability();
        
        Scanner keyboard = new Scanner(System.in);
        int count = 0;
        int nextInt = 0;
        String userInput = "";
        do {
            System.out.print("Enter card, 0 to quit. Card: \n");
            nextInt = keyboard.nextInt();
            if(nextInt >= 2 && nextInt <= 6){
                highCards.addCard(nextInt);
                count++;
                avgCount.addValue(count);
                System.out.println("High card. Count is currently: "+count);
                probability.calcHighCardPrb();
                probability.calcLCPrb();
                probability.calcNCPrb();
                System.out.println(probability);
            }
            else if (nextInt >= 7 && nextInt <= 9){
                neutralCards.addCard(nextInt);
                System.out.println("Netural card. Count is currently: "+count);
                probability.calcNtrlCardPrb();
                probability.calcLCPrb();
                probability.calcHCPrb();
                System.out.println(probability);                
            }
            else if (nextInt == 10 || nextInt == 11 || nextInt == 1){
                lowCards.addCard(nextInt);
                count--;
                avgCount.addValue(count);                
                System.out.println("Low card. Count is currently: "+count);
                probability.calcLowCardPrb();
                probability.calcNCPrb();
                probability.calcHCPrb();
                System.out.println(probability);                
            }
            if (nextInt > 11)
                System.out.println("Not a valid card.");
   
        } while(nextInt!=0);
       int totalCards = highCards.totalCards()+neutralCards.totalCards()+lowCards.totalCards();
        System.out.println("The number of high cards (2 to 6) dealt: "+highCards);
        // System.out.println("These were the high cards that were dealt: "+"\n"+highCards.showCards());
        System.out.println("The number of neutral cards (7 to 9) dealt: "+neutralCards);
        // System.out.println("These were the neutral cards that were dealt: "+"\n"+neutralCards.showCards());
        System.out.println("The number of low cards (10s, aces) dealt: "+lowCards);
        // System.out.println("These were the low cards that were dealt: "+"\n"+lowCards.showCards());
        
        System.out.println("The total number of cards pulled was: "+totalCards);
        try {
        System.out.println("The average value of the count was: "+(avgCount.sumValues()/totalCards));
        }
        catch (ArithmeticException ae){
            System.out.println("No average to calculate.");
        }
        
        try{
            PrintWriter countData = new PrintWriter("NewCountData.txt");
            
            countData.println("The number of high cards (2 to 6) dealt: "+highCards);
            countData.println("The number of neutral cards (7 to 9) dealt: "+neutralCards);
            countData.println("The number of low cards (10s, aces) dealt: "+lowCards);
            countData.println("The total number of cards pulled was: "+totalCards);
            countData.println("The average value of the count was: "+(avgCount.sumValues()/totalCards));
            countData.close();
        } catch (IOException ioe){
            System.out.println("Something went wrong.");
        }
        
        System.out.println("End of game. Data printed. Good luck next time!");
    }
}
    
    
    
