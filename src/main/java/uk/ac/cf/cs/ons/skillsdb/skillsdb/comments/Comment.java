package uk.ac.cf.cs.ons.skillsdb.skillsdb.comments;


import lombok.Data;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts.Advert;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;

import javax.persistence.*;

/**
 * Comment is a representation of a Comment of the SkillsDB.
 *
 * @author  Sepehr Naseri
 * @version 1.0
 * @since   2019-11-19
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */

@Data
@Entity
@Table(name = "Comments")
public class Comment {

    /**
     * Id of the Comment.
     *
     * @param id New id for the Comment.
     * @return id of the Comment.
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
     * Comment who created and is running Comment
     *
     *
     * @param advert New advert for the comment.
     * @return advert that the Comment is for.
     *
     */
    @ManyToOne
    @JoinColumn(name = "advert_id")
    private Advert advert;


    /**
     * Comment who created and is running Comment
     *
     *
     * @param user_creator new User for the Comment.
     * @return user who left the Comment.
     *
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_creator")
    private User user;


}
