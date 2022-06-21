static int countElements(int[] array,int elem){
    Counter c=new Counter();
    for (int i: array){
    	if (i==elem){
    	    c.increment();
    	}
    }
    return c.getValue();
}
