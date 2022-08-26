package it.unibo.apice.oop.p15gui.mvc;

public class Application{
	
	public static void main(String[] args){
		Controller c = new Controller();
		Model m = new Model();
		View v = new View();
		c.setModel(m);
		c.setView(v);
		c.setFileName("/home/mirko/aula/archive.bin");
	}
}
