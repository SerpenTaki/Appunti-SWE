package Strutturali.Decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class LoggedPizza extends ToppedPizza {
    private static final Logger logger = Logger.getLogger(LoggedPizza.class.getName());

       protected LoggedPizza(Pizza toDecorate) {
        super(toDecorate);
    }

    @Override
    protected List<String> addIngredients(List<String> ingredients) {
       logger.info(ingredients.toString());
       return ingredients;
    }
}
