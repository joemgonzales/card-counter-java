public class Probability{
    //Instance variables
    private double highCardPrb = 38.46;
    private double ntrlCardPrb = 23.07;
    private double lowCardPrb = 38.46;
    private int[] highCards = new int[160];
    private int[] lowCards = new int[160];
    private int[] neutralCards = new int[96];
    private int[] totalCards = new int[416];
    private int hcIndex = 159;
    private int lcIndex = 159;
    private int ncIndex = 95;
    private int tcIndex = 415;
    
    public Probability(){
        for (int i = 0; i < highCards.length; i++){
            highCards[i] = i;
        }
        for (int i = 0; i < lowCards.length; i++){
            lowCards[i] = i;
        }
        for (int i = 0; i < neutralCards.length; i++){
            neutralCards[i] = i;
        }
        for (int i = 0; i < totalCards.length; i++){
            totalCards[i] = i;
        }   
    }
    
    public int getTotalCards(){
        return tcIndex;
    }
    
    public int getHighCards(){
        return hcIndex;
    }
    
    public int getLowCards(){
        return lcIndex;
    }
    
    public int getNtrlCards(){
        return ncIndex;
    }
    
    public void calcHighCardPrb(){        
        highCardPrb = ((double)highCards[hcIndex]/(double)totalCards[tcIndex])*100.0;
        hcIndex--;
        tcIndex--;
    }
    
    public void calcHCPrb(){
        highCardPrb = ((double)highCards[hcIndex]/(double)totalCards[tcIndex])*100.0;
    }
    
    public void calcLowCardPrb(){
        lowCardPrb = ((double)lowCards[lcIndex]/(double)totalCards[tcIndex])*100.0;
        lcIndex--;
        tcIndex--;
    }
    
    public void calcLCPrb(){
        lowCardPrb = ((double)lowCards[lcIndex]/(double)totalCards[tcIndex])*100.0;
    }
    
    public void calcNtrlCardPrb(){
        ntrlCardPrb = ((double)neutralCards[ncIndex]/(double)totalCards[tcIndex])*100.0;
        ncIndex--;
        tcIndex--;
    }
    
    public void calcNCPrb(){
        ntrlCardPrb = ((double)neutralCards[ncIndex]/(double)totalCards[tcIndex])*100.0;
    }
    
    public String toString(){
        return "Next card chances ("+tcIndex+"/416)\n"+
               "[2 to 6]: "+String.format("%.2f",highCardPrb)+"%"+"  ("+(hcIndex+1)+"/160)"+"  "+
               "[7 to 9]: "+String.format("%.2f",ntrlCardPrb)+"%"+"  ("+(ncIndex+1)+"/96)"+"  "+
               "[10s, aces]: "+String.format("%.2f",lowCardPrb)+"%"+"  ("+(lcIndex+1)+"/160)";
    }
    
}
