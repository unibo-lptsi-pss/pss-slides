public class Unbounded{
    
    public static void printLength(Vector<?> vect){
    	System.out.println(vect.getLength());
    }
    
    public static void main(String[] s){
    	Vector<Integer> vector = new Vector<>();
    	vector.addElement(1);
    	vector.addElement(2);
    	vector.addElement(3);
    	// Posso passare Vector<Integer> dove si attende
    	// Vector<?>
    	printLength(vector);
    }
} 
