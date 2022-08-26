package it.unibo.apice.oop.p21patterns.decorator.problem;

public class UsePizza {

    public static void main(String[] args) {
        Pizza pizza = new Margherita();
        Pizza pizza2 = new IngredienteFunghi(new Margherita());
        Pizza pizza3 = new IngredienteFunghi(new IngredienteFunghi(new Margherita()));
        Pizza pizza4 = new GlutFree(new IngredienteFunghi(new IngredienteFunghi(new Margherita())));
        
    }

}
