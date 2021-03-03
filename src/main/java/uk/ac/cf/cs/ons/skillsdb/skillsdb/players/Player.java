package uk.ac.cf.cs.ons.skillsdb.skillsdb.players;

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

@Data
@Entity
@Table(name = "Players")
public class Player {

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
    private String name;



    public String getUrl() {
        return "/player/" + id;
    }

}
