package uk.ac.cf.cs.ons.skillsdb.skillsdb.associatedskills;

import java.util.List;
import java.util.Optional;

public interface AssociatedSkillService {

    Optional<AssociatedSkill> findByASIndex(long id);

    List<AssociatedSkill> findBySkillName (String searchTerm);

    void deleteAssociatedSkillsByUserId(long id);

    List<AssociatedSkill> findByuser_id(long id);


}
