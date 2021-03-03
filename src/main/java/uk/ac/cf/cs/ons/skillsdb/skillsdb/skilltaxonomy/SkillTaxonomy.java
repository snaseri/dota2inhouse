package uk.ac.cf.cs.ons.skillsdb.skillsdb.skilltaxonomy;


import lombok.Data;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skills.Skill;

import javax.persistence.*;

/**
 * SkillTaxonomy is the hierarchy of skills in the SkillsDB.
 *
 * @author  Sepehr Naseri
 * @version 1.0
 * @since   2019-11-19
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 *
 */

@Data
@Entity
@Table(name = "Taxonomy")
public class SkillTaxonomy {


    /**
     * Id of the taxonomy.
     *
     * @param id New id for the taxonomy.
     * @return id of the taxonomy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;



    /**
     * The parent skill
     *
     *
     * @param skill_id new Parent for the Skill.
     * @return parent of the skill.
     *
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private Skill parent;

    /**
     * The child skill
     *
     *
     * @param skill_id new Child for the Skill.
     * @return child of the skill.
     *
     */
    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "child_id")
    private Skill child;
}
