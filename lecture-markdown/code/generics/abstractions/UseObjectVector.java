public class UseObjectVector {
    public static void main(String[] s){
    	// Serie di Fibonacci
    	ObjectVector vobj = new ObjectVector();
    	// fib(0)=fib(1)=1, fib(N)=fib(N-1)+fib(N-2) if N>1
    	vobj.addElement(1); // grazie all'autoboxing
    	vobj.addElement(1);
    	for (int i=0;i<20;i++){
    	    vobj.addElement( // servono downcast specifici
    	    	(Integer)vobj.getElementAt(vobj.getLength()-1)+ 
    	    	(Integer)vobj.getElementAt(vobj.getLength()-2)  
    	    );
    	}
    	System.out.println(vobj);
    	// |1|1|2|3|5|8|13|21|34|55|89|144|233|..
    	// 377|610|987|1597|2584|4181|6765|10946|17711|
    	
    	// Altro esempio
    	ObjectVector vobj2 = new ObjectVector();
    	vobj2.addElement("Prova");
    	vobj2.addElement("di");
    	vobj2.addElement("vettore");
    	vobj2.addElement(new Object());
    	System.out.println(vobj2);
    	String str = (String)vobj2.getElementAt(1); // "di"
    	//String str2 = (String)vobj2.getElementAt(3); // Exception
    }
} 
