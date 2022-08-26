package it.unibo.apice.oop.p21patterns.decorator.problem;

public class IngredienteFunghi extends Ingrediente {

    public IngredienteFunghi(Pizza pizza) {
        super(pizza);
    }

    @Override
    protected int singleCost() {
        return 100;
    }

    @Override
    protected String name() {
        return "Funghi";
    }

}
