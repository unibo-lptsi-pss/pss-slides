package it.unibo.apice.oop.p14io.files;

public class Persona implements java.io.Serializable{
	
	final private String nome;
    final private int annoNascita;
    final private boolean sposato;
    
  
    public Persona(String nome,int annoNascita,boolean sposato){
    	this.nome = nome;		
    	this.annoNascita = annoNascita;
    	this.sposato = sposato;
    }
  
    public String toString(){
    	return this.nome + ":" + this.annoNascita + ":" + 
    	       (this.sposato ? "spos" : "non-spos");
    }
}