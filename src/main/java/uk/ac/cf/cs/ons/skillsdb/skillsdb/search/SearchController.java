package uk.ac.cf.cs.ons.skillsdb.skillsdb.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.search.execptions.SearchResultNotFound;

import java.util.Optional;

/**
 * SearchController allows the client to search for Courses, Adverts, and Users.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-12-10
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    public static final String SEARCH_PAGE = "usearch/index";

    private SearchService searchService;

    /**
     * Allows for an implementation of SearchService to be injected through Inversion of Control (IoC),
     * and Dependency Injection (DI).
     */
    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    /**
     * Allows for the client to search for Adverts, Courses, and Users through a view.
     *
     * @param search, What they are searching for.
     * @param type, What type of thing they are Searching for {@see SearchType}
     * @return SEARCH_PAGE
     * @throws SearchResultNotFound if no results are returned.
     */
    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String index(@RequestParam("term") Optional<String> search, @RequestParam("type") Optional<SearchType> type, Model model)  throws SearchResultNotFound  {
        model.addAttribute("results", searchService.searchByTitle( search.orElse("Java"), type.orElse(SearchType.COURSE))
                .orElseThrow( () -> new SearchResultNotFound("No Results") ));
        return SEARCH_PAGE;
    }
}
