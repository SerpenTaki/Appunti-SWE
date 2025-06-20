package Behaviour.Strategy;

/**
 * A factory that creates search engines
 */

public class SearchEngineFactory {
    public SearchEngine<?> build() {
        return new SearchEngine2016();
    }
}
