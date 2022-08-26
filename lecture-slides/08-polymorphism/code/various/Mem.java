class Mem{
	
	public static void main(String[] s) {
	    
	    // Runtime da' info sull'esecuzione
		Runtime r=Runtime.getRuntime();	
		
		long free = r.freeMemory();
	    
	    int size = Integer.parseInt(s[0]);
	    Object[] o = new Object[size];
	    
	    System.out.println("Creo array: "+(free-r.freeMemory()));
	    
	    free = r.freeMemory();
	  
		for (int i=0;i<size;i++){
			o[i] = new Object();
		}
		
		System.out.println("Array riempito: "+(free-r.freeMemory()));
		System.out.println("Occupazione Object: "+((free-r.freeMemory())/size));

	}
} 
