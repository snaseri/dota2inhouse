package uk.ac.cf.cs.ons.skillsdb.skillsdb.reviews;

import java.util.List;
import java.util.Optional;

/**
 * ReviewRepository allows the caller to access to the reviews data source.
 *
 * @author  Sepehr Naseri
 * @version 1.0
 * @since   2019-11-20
 * @see     Review
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */


public interface ReviewRepository {

    /**
     * Find a Comment by id.
     *
     * @param id Of the review you want to find.
     * @return Optional Of the selected review.
     */
    Optional<Review> findById(Long id);


    /**
     * Find a Comment by name.
     *
     * @param title Of the review you want to find.
     * @return List Of the selected courses.
     */
    List<Review> findByTitle(String title);

    /**
     * Find a Comment by price.
     *
     * @param  description the review you want to find.
     * @return List Of the courses with the given description.
     */
    List<Review> findByDescription(String description);


}


