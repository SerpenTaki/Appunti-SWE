package Strutturali.Decorator;

import java.util.List;

public class Pizzaiolo {
    public static void main(String[] args) {
        Pizza viennese = new LoggedPizza(new WurstelPizza(new TomatoPizza(new TomatoPizza(new MozzarellaCheesePizza(new BasePizza())))));
        Pizza margherita = new TomatoPizza(new MozzarellaCheesePizza(new BasePizza()));
        Pizza whitePizza = new MozzarellaCheesePizza(new BasePizza());
        System.out.println("Viennese pizza ingredients: " + mkString(viennese.ingredients()));
        System.out.println("Margherita pizza ingredients: " + mkString(margherita.ingredients()));
        System.out.println("White pizza ingredients: " + mkString(whitePizza.ingredients()));
    }

    private static String mkString(List<String> list) {
        return list.stream().reduce((s, s2) -> s + ", " + s2).get().toString();
    }
}
