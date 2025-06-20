package Strutturali.Decorator;

import java.util.List;

public abstract class PreToppedDecorator implements Pizza{
    private final Pizza pizza;

    public PreToppedDecorator(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public List<String> ingredients(){
        final List<String> toppingIngredients = toppingIngredients();
        toppingIngredients.addAll(pizza.ingredients());
        return toppingIngredients;
    }

    protected abstract List<String> toppingIngredients();

    @Override
    public int cookingTime(){
        return 0;
    }
}
