package uk.ac.cf.cs.ons.skillsdb.skillsdb.users;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Collection;

/**
 * User is a representation of a user of the SkillsDB.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-11-19
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */
@Data
@Entity
@Table(name = "Users")
public class User {

    /**
     * Id of the user.
     *
     * @param id New id for the user.
     * @return id of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    /**
     * Username of the user.
     *
     * @param username New username for the user.
     * @return username of the user.
     */
    @Column(name = "username")
    private String username;

    /**
     * Password of the user.
     *
     * TODO: This probably shouldn't be a String.
     *
     * @param password New password for the user.
     * @return password of the user.
     *
     */
    @Column(name = "password")
    private String password;


    public String getUrl() {
        return "/user/" + getId();
    }

}