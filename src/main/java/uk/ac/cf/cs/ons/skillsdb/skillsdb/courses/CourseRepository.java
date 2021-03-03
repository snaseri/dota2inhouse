package uk.ac.cf.cs.ons.skillsdb.skillsdb.courses;

import javax.crypto.Cipher;
import java.util.List;
import java.util.Optional;

/**
 * TaxonomyRepository allows the caller to access to the courses data source.
 *
 * @author  Sepehr Naseri
 * @version 1.0
 * @since   2019-11-20
 * @see     Course
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */


public interface CourseRepository {

    /**
     * Find a Course by id.
     *
     * @param id Of the course you want to find.
     * @return Optional Of the selected course.
     */
    Optional<Course> findById(Long id);


    Optional<List<Course>> findByNameContains(String terms);

    /**
     * Find a Course by name.
     *
     * @param name Of the course you want to find.
     * @return List Of the selected courses.
     */
    List<Course> findByName(String name);


    /**
     * Find a Course by price.
     *
     * @param price Of the course you want to find.
     * @return List Of the courses with selected price.
     */
    List<Course> findByPrice(Double price);

    public Course save(Course aCourse);

    List<Course> findAllBySkillIdName(String name);
}


