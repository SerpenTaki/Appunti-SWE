package Behaviour.Strategy;

import java.util.Collections;
import java.util.List;

/**
 * Implementation of the version of the 2016 of the search engine algorithm.
 */

public class SearchEngine2016 implements SearchEngine<SearchContext2016> {
    @Override
    public List<String> search(SearchContext2016 query) {
        return Collections.singletonList("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
    }
}