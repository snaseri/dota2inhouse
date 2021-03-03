package uk.ac.cf.cs.ons.skillsdb.skillsdb.skilltaxonomy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxonomyRepoJPA extends TaxonomyRepository, JpaRepository<SkillTaxonomy, Long> {

}
