package uk.ac.cf.cs.ons.skillsdb.skillsdb.associatedskills;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


/**
 * AssociatedSkillRepository allows the caller to access to the associatedskills data source.
 *
 * @author  Humzah Hanif
 * @version 1.0
 * @since   2019-11-19
 * @see     AssociatedSkill
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */

@Repository
public interface AssociatedSkillRepository extends CrudRepository<AssociatedSkill, Long> {

    /**
     * Be able to find a user based on the skills that they have declared.
     *
     * @param skill of the user that you want to find.
     * @return List of Users that have the searched skill.
     */
    List<AssociatedSkill> findBySkill(String skill);

    List<AssociatedSkill> findABySkillName(String searchTerm);

    void deleteAssociatedSkillsByUserId(long id);

    List<AssociatedSkill> findByuser_id(long id);
}
