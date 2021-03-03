package uk.ac.cf.cs.ons.skillsdb.skillsdb.skilltaxonomy;

import java.util.List;
import java.util.Optional;

/**
 * TaxonomyRepository allows the caller to access to the courses data source.
 *
 * @author  Sepehr Naseri
 * @version 1.0
 * @since   2019-11-20
 * @see     SkillTaxonomy
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */


public interface TaxonomyRepository {

    /**
     * Find a SkillTaxonomy by id.
     *
     * @param id Of the SkillTaxonomy you want to find.
     * @return Optional Of the selected SkillTaxonomy.
     */
    Optional<SkillTaxonomy> findById(Long id);

    List<SkillTaxonomy> findAllByChild_Name(String name);

    List<SkillTaxonomy> findAllByParentName (String name);

    List<SkillTaxonomy> findAllByChildName (String name);


}


