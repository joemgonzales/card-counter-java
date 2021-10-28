public class RunningCount{
    //Class constant
    private static final int ARRAY_SIZE = 1000;
    
    //Instance variables
    private int[] currentCount;
    private int index;
    
    //Constructor
    public RunningCount(){
        currentCount = new int[ARRAY_SIZE];
        index = 0;
    }
    
    public void addValue(int a){
        currentCount[index++] = a;
    }
    
    // code longest positive and negative count range
    
    public int sumValues(){
        int sum = 0;
        
        for (int i = 0; i < index; i++){
            sum += currentCount[i];
        }
        
        return sum;
    }
}
