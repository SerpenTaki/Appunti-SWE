package Strutturali.Decorator;

import java.util.ArrayList;
import java.util.List;

public class TomatoPizza extends ToppedPizza {

    protected TomatoPizza(Pizza toDecorate) {
        super(toDecorate);
    }

    protected List<String> addIngredients(List<String> ingredients) {
        // This decoration add its features after the feature of the original class
        final List<String> ingredientsCopy = new ArrayList<>(ingredients);
        ingredientsCopy.add("tomato");
        return ingredientsCopy;
    }
}
