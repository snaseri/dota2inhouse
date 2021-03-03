package uk.ac.cf.cs.ons.skillsdb.skillsdb.teams;


import lombok.Data;

import javax.persistence.*;

/**
 * Team is a representation of a team of the SkillsDB.
 *
 * @author  Humzah Hanif
 * @version 1.0
 * @since   2019-11-19
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */
@Data
@Entity
@Table(name = "Teams")
public class Team {

    /**
     * Id of the team
     *
     * @param id New id for the team
     * @return id for the team
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    /**
     * Name of the team
     *
     * @param New name for the team
     * @return name for the team
     */
    @Column(name = "name")
    private String teamName;

    /**
     * Description for the team
     *
     * @param description New description for the team
     * @return description for the team
     */
    @Column(name = "description")
    private String teamDescription;

}
