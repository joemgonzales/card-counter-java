public class CardTiers{
    //Class constant
    private static final int ARRAY_SIZE = 1000;
    
    //Instance variables
    private int[] numOfCards;
    private int index;
    
    public CardTiers(){
        numOfCards = new int[ARRAY_SIZE];
        index = 0;
    }
    
    public String[] getCards(){ 
        String[] cardsAsStrings = new String[ARRAY_SIZE];
        
        for (int i = 0; i < numOfCards.length; i++){
            if (numOfCards[i] != 0)
                cardsAsStrings[i] = Integer.toString(numOfCards[i]);
        }
        
        return cardsAsStrings;
    }
    
    public void addCard(int card){
        numOfCards[index++] = card;
    }
    
    public int totalCards(){
        int total = 0;
        
        if (index > 0)
            total = index;
        
        return total;
    }
    
    public String showCards(){
        String s = "";
        
        for (int i = 0; i < getCards().length; i++){
            if (getCards()[i] != null)
                s += getCards()[i]+" ";
        }
        
        return s;
    }
    
    public String toString(){
        return "\n"+Integer.toString(index);
    }
    
}