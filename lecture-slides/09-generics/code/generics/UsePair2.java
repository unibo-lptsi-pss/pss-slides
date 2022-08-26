public class UsePair2{
    public static void main(String[] s){
	// Parametri in new Vector() inferiti dal tipo della variabile  	
    	Vector<Pair<String,Integer>> v = new Vector<>(); 
    	// Parametri in new Pair(..) inferiti dal tipo degli argomenti
    	v.addElement(new Pair<>("Prova",1));		
    	v.addElement(new Pair<>("di",2));		
    	v.addElement(new Pair<>("Vettore",3));
    	String str = v.getElementAt(0).getFirst() + " " + 
    		     v.getElementAt(1).getFirst() + " " +
    		     v.getElementAt(2).getFirst(); // Nota, nessun cast!
        System.out.println(str);
        System.out.println(v);
        
        // Inferenza grazie agli argomenti e tipo variabile..
        List<Pair<Integer,Integer>> l = 
          new List<>(new Pair<>(1,1), 
          new List<>(new Pair<>(2,2),
          new List<>(new Pair<>(3,3),
          null)));
        System.out.println(l);
    }
}

