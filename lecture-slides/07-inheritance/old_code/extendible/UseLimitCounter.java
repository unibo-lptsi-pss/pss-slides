public class UseLimitCounter{	
   public static void main(String[] s){
    	LimitCounter c = new LimitCounter(0,5);
    	System.out.println(""+c.getValue()); // 0
    	System.out.println(""+c.isOver()); // false
    	c.increment();
    	c.increment();
    	System.out.println(""+c.getValue()); // 2
    	System.out.println(""+c.isOver()); // false
    	c.increment();
    	c.increment();
    	c.increment();
    	c.increment();
    	c.increment();
    	c.increment();
    	c.increment();
    	System.out.println(""+c.getValue()); // 5
    	System.out.println(""+c.isOver()); // true
   }
}
