package it.unibo.apice.oop.p21patterns.decorator.problem;

public abstract class Ingrediente implements Pizza {
    
    private final Pizza pizza;
    
    public Ingrediente(Pizza pizza) {
        super();
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return this.singleCost() + this.pizza.getCost();
    }

    @Override
    public String getIngredients() {
        return this.pizza.getIngredients()+", "+name();
    }
    
    protected abstract int singleCost();
    
    protected abstract String name();

}
