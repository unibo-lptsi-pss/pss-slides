package it.unibo.apice.oop.p14io.trans;
import java.util.Date;
import java.io.*;

public class APersona implements java.io.Serializable{
	private static final long serialVersionUID = -8985026380526620812L;
	
	final private String nome;
    transient private Date lastUse = new Date();
  
    public APersona(String nome){
    	this.nome = nome;		
    }
    	
    public void used(){
    	this.lastUse = new Date();
    }
	
	public String toString(){
    	return this.nome + ":" + (this.lastUse==null ? "null" : this.lastUse.getTime());
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException{
    	out.defaultWriteObject(); // accetto il comportamento di default in scrittura
    	System.err.println("writing");
    }
    // una sorta di costruttore..
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
    	in.defaultReadObject();
    	System.err.println("reading");
    	this.lastUse = new Date(); // in lettura, ripristino la data corrente 
    }   
}