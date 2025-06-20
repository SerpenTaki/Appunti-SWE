package Strutturali.Decorator;

import java.util.ArrayList;
import java.util.List;

public class MozzarellaCheesePizza extends ToppedPizza{
    protected MozzarellaCheesePizza(Pizza toDecorate) {
        super(toDecorate);
    }

    @Override
    protected List<String> addIngredients(List<String> ingredients) {
        // This decoration add its features after the feature of the original class
        final List<String> ingredientsCopy = new ArrayList<>(ingredients);
        ingredientsCopy.add("Mozzarella cheese");
        return ingredientsCopy;
    }
}
