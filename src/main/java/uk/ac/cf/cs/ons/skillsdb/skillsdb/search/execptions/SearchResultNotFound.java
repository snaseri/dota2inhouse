package uk.ac.cf.cs.ons.skillsdb.skillsdb.search.execptions;

/**
 * SearchResultNotFound is a exception that will be thrown when there
 * are no SearchResults.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-12-10
 */
public class SearchResultNotFound extends Exception {
  public SearchResultNotFound(String errorMessage) {
    super(errorMessage);
  }
}
