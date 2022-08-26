package it.unibo.apice.oop.p21patterns.decorator;

public class GlutFree extends IngredientDecorator {
	
	public GlutFree(Pizza p){
		super(p);
	}
	
	public int getCost(){
		return (int)(super.getCost() * 1.1);
	}
	
	public String getIngredients(){
		return "[GF] "+super.getIngredients();
	}
	
}
