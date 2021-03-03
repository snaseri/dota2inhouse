package uk.ac.cf.cs.ons.skillsdb.skillsdb.search;

import lombok.Value;

/**
 * SearchResult are results from searches on {@see CourseRepository}, {@see AdvertRepository},
 * and {@see UserRepository}.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-12-10
 */
@Value(staticConstructor = "of")
public class SearchResult {

    /**
     * Title of the SearchResult, could be a Username, Course Title, or Advert Title.
     *
     * @return title
     */
    private String title;

    /**
     * Description of the SearchResult, could be a Username Email, Course Description, or
     * Advert Description.
     *
     * @return description
     */
    private String descripion;

    /**
     * Url of the SearchResult, could be the Url to the page that links to User, Course, or Advert.
     *
     * @return url
     */
    private String url;

}
