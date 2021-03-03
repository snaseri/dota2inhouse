package uk.ac.cf.cs.ons.skillsdb.skillsdb.skills;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * SkillRepository allows for access to the skills data source.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-11-20
 * @see     Skill
 * @url     https://spring.io/projects/spring-data-jpa
 */
@Repository
public interface SkillRepository extends CrudRepository<Skill, Long> {

  /**
   * Find Skill(s) by name.
   *
   * @param name of skill(s) you wish to find.
   * @return list of skills that match name
   */
  Optional<List<Skill>> findSkillsByName(String name);

  Optional<Skill> findSkillByName(String name);

  Skill findSkillById(long id);
  
}
