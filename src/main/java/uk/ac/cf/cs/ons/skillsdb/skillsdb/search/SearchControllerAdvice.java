package uk.ac.cf.cs.ons.skillsdb.skillsdb.search;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.search.execptions.SearchResultNotFound;

import java.util.List;

/**
 * SearchControllerAdvice will handle errors thrown by SearchController.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-12-10
 * @see     SearchResultNotFound
 */
@ControllerAdvice
public class SearchControllerAdvice {

    /**
     * Handles an error when the {@see SearchResultNotFound} is thrown.
     *
     * @param exception SearchResultNotFound
     * @param model Model
     * @return SEARCH_PAGE
     */
    @ExceptionHandler(SearchResultNotFound.class)
    public String handleNoSearchResults(SearchResultNotFound exception, Model model) {
        model.addAttribute("results", List.of());
        return SearchController.SEARCH_PAGE;
    }

}
