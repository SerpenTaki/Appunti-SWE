package Strutturali.Decorator;

import java.util.List;

public abstract class ToppedPizza implements Pizza{ //Decora una pizza con i vari ingredienti Corrisponde AL NOSTRO DECORATOR
    private final Pizza toDecorate; //Aggregazione

    protected ToppedPizza(Pizza toDecorate){
        this.toDecorate = toDecorate;
    }

    public List<String> ingredients(){
        return addIngredients(toDecorate.ingredients());
    }

    @Override
    public int cookingTime(){
        return toDecorate.cookingTime();
    }

    protected abstract List<String> addIngredients(List<String> ingredients);
}
