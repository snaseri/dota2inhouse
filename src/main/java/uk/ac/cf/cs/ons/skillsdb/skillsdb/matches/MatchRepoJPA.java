package uk.ac.cf.cs.ons.skillsdb.skillsdb.matches;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.matches.Match;


public interface MatchRepoJPA extends MatchRepo, JpaRepository<Match, Long> {
}
