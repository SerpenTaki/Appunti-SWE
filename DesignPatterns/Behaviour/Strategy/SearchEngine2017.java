package Behaviour.Strategy;

import java.util.Collections;
import java.util.List;

/**
 * * Implementation of the version of the 2017 of the search engine algorithm.
 */

public class SearchEngine2017 implements SearchEngine<SearchContext2017> {
    @Override
    public List<String> search(SearchContext2017 query) {
        return Collections.singletonList("A new result!!!!");
    }
}
