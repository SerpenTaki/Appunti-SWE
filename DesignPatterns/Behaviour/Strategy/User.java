package Behaviour.Strategy;

import java.util.List;

/**
 * A client that makes some searches.
 */
public class User {
    public static void main(String[] args) {
        final SearchEngine se = new SearchEngineFactory().build();
        // Once you have more than one implementation of a strategy, the difficult task
        // is to create the right context to use it, without locking the client. An
        // abstract factory could help us doing so.

        System.out.println("LOL");

        final List<String> results =
                se.search(new SearchContext2016("Blue Waffle", "User info"));
    }
}
