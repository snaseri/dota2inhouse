package uk.ac.cf.cs.ons.skillsdb.skillsdb.comments;

import java.util.List;
import java.util.Optional;

/**
 * CommentRepository allows the caller to access to the comments data source.
 *
 * @author  Sepehr Naseri
 * @version 1.0
 * @since   2019-11-20
 * @see     Comment
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */


public interface CommentRepository {

    /**
     * Find a Comment by id.
     *
     * @param id Of the Comment you want to find.
     * @return Optional Of the selected Comment.
     */
    Optional<Comment> findById(Long id);


    /**
     * Find a Comment by name.
     *
     * @param title Of the Comment you want to find.
     * @return List Of the selected courses.
     */
    List<Comment> findByTitle(String title);

    /**
     * Find a Comment by price.
     *
     * @param  description the Comment you want to find.
     * @return List Of the courses with the given description.
     */
    List<Comment> findByDescription(String description);


}


