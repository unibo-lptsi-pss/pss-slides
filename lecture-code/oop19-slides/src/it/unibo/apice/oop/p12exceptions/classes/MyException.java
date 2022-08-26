package it.unibo.apice.oop.p12exceptions.classes;

public class MyException extends RuntimeException{
    
    // tengo traccia degli argomenti che hanno causato il problema
    private final String[] args;
    
    public MyException(final String s, final String[] args){
    	super(s);
    	this.args = args;
    }
    
    // modifico la toString per evidenziare this.args
    public String toString(){
    	String str = "Stato argomenti: ";
    	str = str + java.util.Arrays.toString(args);
    	str = str + "\n" + super.toString();
    	return str;
    }
}

