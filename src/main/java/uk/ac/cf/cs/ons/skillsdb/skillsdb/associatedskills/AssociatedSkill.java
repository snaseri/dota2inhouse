package uk.ac.cf.cs.ons.skillsdb.skillsdb.associatedskills;


import lombok.Data;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skills.Skill;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;


import javax.persistence.*;

/**
 * AssociatedSkills is a representation of a user and a skill of the SkillsDB.
 *
 * @author  Humzah Hanif
 * @version 1.0
 * @since   2019-11-19
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */
@Data
@Entity
@Table(name = "Associated_Skills")
public class AssociatedSkill {


    /**
     * Id for the associatedskill.
     *
     * @parama id New id for the associatyedskill.
     * @return id for the associatedskill.
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
     * Skill id that is linked to the id within the Skills table in the SkillsDB.
     *
     * @param skill_id A skill from the skills table.
     * @return skill from the skills table.
     */
    @OneToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    /**
     * Rating of the skills.
     *
     * @param rating New rating for the associatedskill.
     * @return rating for the associatedskill.
     */
    @Column(name = "rating")
    private int rating;

}
