package uk.ac.cf.cs.ons.skillsdb.skillsdb.associatedteams;


import lombok.Data;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.teams.Team;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;


import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * AssociatedTeam is a representation of a user and a team of the SkillsDB.
 *
 * @author  Humzah Hanif
 * @version 1.0
 * @since   2019-11-19
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */
@Data
@Entity
@Table(name = "associatedteams")
public class AssociatedTeam {


    /**
     * Id of the assoiciatedteam.
     *
     * @param id New id for the associatedteam.
     * @return id for the associatedteam.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    /**
     * User id that is linked to the id within the Users table in the SkillsDB.
     *
     * @param user_id A user from the Users table.
     * @return user form the Users table.
     */
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Team id that is linked to the id within the Teams table in the SkillsDB.
     *
     * @param team_id A team from the teams table.
     * @return team form the teams table.
     */
    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;

    /**
     * The data and time that a particular user left the associatedteam.
     */

    @Column(name = "left_team")
    private LocalDateTime leftTeam;

}
