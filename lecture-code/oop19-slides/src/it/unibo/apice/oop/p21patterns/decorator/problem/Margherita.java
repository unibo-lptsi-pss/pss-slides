package it.unibo.apice.oop.p21patterns.decorator.problem;

public class Margherita implements Pizza {

    @Override
    public int getCost() {
        return 650;
    }

    @Override
    public String getIngredients() {
        return "mozzarella, pomodoro";
    }

}
