public class UseBiCounter{	
   public static void main(String[] s){
    	BiCounter c=new BiCounter(0);
    	System.out.println(""+c.getValue()); // 0
    	c.increment();
    	c.increment();
    	System.out.println(""+c.getValue()); // 2
        c.decrement();
        System.out.println(""+c.getValue()); // 1
   }
}
