package Behaviour.Strategy;

import java.util.List;

/**
 * A search engine that returns a list of url with respect to an input query.
 * We are using generics to let the compiler check if we are using the right
 * context type as input.
 */
public interface SearchEngine<T extends SearchContext> {
    List<String> search(T context);
}

