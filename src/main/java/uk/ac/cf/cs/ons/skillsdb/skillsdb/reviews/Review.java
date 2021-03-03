package uk.ac.cf.cs.ons.skillsdb.skillsdb.reviews;


import lombok.Data;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.courses.Course;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;

import javax.persistence.*;

/**
 * review is a representation of a review of the SkillsDB.
 *
 * @author  Sepehr Naseri
 * @version 1.0
 * @since   2019-11-19
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */

@Data
@Entity
@Table(name = "Reviews")
public class Review {

    /**
     * Id of the review.
     *
     * @param id New id for the review.
     * @return id of the review.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;



    /**
     * name of the Comment.
     *
     * @param title New title for the Comment.
     * @return title of the Comment.
     */
    @Column(name = "title")
    private String title;



    /**
     * description for the Comment.
     *
     *
     * @param description New description for the Comment.
     * @return description for the Comment.
     *
     */
    @Column(name = "description")
    private String description;


    /**
     * course of the Review
     *
     *
     * @param course new course for the Comment.
     * @return course that the Comment is for.
     *
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;


    /**
     * user who created the Review
     *
     *
     * @param review_creator new review for the Comment.
     * @return review of the Comment.
     *
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_creator")
    private User user;


}
