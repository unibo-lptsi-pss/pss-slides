package it.unibo.apice.oop.p21patterns.decorator.problem;

public class GlutFree implements Pizza {
    
    private final Pizza pizza;
    
    public GlutFree(Pizza pizza) {
        super();
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return (int)(this.pizza.getCost() * 1.1);
    }

    @Override
    public String getIngredients() {
        return "[GF] "+this.pizza.getIngredients();
    }
    
}
