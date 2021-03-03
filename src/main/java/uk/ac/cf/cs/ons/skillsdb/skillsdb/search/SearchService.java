package uk.ac.cf.cs.ons.skillsdb.skillsdb.search;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * SearchService is a contract that all SearchServices implementations must
 * implement.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-12-10
 */
public interface SearchService {

    /**
     * Return an Optional set of SearchResults that the user has searched for.
     *
     * @param title of the search.
     * @param type of the search {@see SearchType}
     * @return Optional set of SearchResults.
     */
    Optional<List<SearchResult>> searchByTitle(String title, SearchType type);

}