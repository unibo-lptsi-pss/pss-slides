public class UseMultiCounter{	
    public static void main(String[] s){
    	MultiCounter mc = new MultiCounter(10);
    	System.out.println(""+mc.getValue()); // 10
    	mc.increment();
    	mc.increment();
    	System.out.println(""+mc.getValue()); // 12
    	mc.multiIncrement(10);
    	System.out.println(""+mc.getValue()); // 22
    }
}
