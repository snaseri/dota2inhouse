package uk.ac.cf.cs.ons.skillsdb.skillsdb.courses;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skills.Skill;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Course is a representation of a workshop in the SkillsDB.
 *
 * @author  Sepehr Naseri
 * @version 1.0
 * @since   2019-11-19
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */

@Data
@Entity
@Table(name = "Courses")
public class Course {

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
     * name of the course.
     *
     * @param name New name for the course.
     * @return name of the course.
     */
    @Column(name = "name")
    @Length(min = 5, max = 30, message = "Course name has to be 5-30 characters long")
    private String name;


    /**
     * description for the course.
     *
     *
     * @param description New description for the course.
     * @return description of the course.
     */

    @Column(name = "description")
    @Length(min = 5, max = 250, message = "Course description has to be 5-250 characters long")
    private String description;


    /**
     * Boolean to see if course is free.
     *
     *
     * @param isFree Wether the course is free or not.
     * @return Wether the course is free or not.
     */
    @Column(name = "is_free")
    private Boolean isFree;


    /**
     * The Price of the course.
     *
     *
     * @param price new price for the course.
     * @return the price for the course.
     */
    @Column(name = "price")
    @Min(0)
    @NumberFormat(pattern = "#,###,###,###.##")
    @NotNull
    private Double price;



    /**
     * date that the course is going to be.
     *
     *
     * @param date new Date for the course.
     * @return date of the course.
     */
    @Column(name = "posted")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please Select a date")
    private Date date;

//    public String prettyDate() {
//        return date.format (DateTimeFormatter.ofPattern("yyyy-MM-dd") );
//    }


    /**
     * User who created and is running course
     *
     *
     * @param user_creator new User for the course.
     * @return user of the course.
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_creator")
    private User user;


    /**
     * The skill that the course is
     *
     *
     * @param skill_id new Skill for the course.
     * @return skill of the course.
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_id")
//    @NotNull(message = "Please Select a skill")
    private Skill skillId;


    public String getUrl() {
        return "/courses/" + id;
    }

}
