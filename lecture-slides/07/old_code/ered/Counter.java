public class Counter{

    private int counter;
   
    public Counter(int initialValue){
    	this.counter = initialValue;
    }
   
    public void increment(){
    	this.counter++;
    }
   
    public int getValue(){
	return counter;
    }
}
