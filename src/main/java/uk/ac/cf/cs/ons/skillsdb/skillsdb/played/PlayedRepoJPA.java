package uk.ac.cf.cs.ons.skillsdb.skillsdb.played;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.played.Played;

import java.util.List;
import java.util.Optional;

public interface PlayedRepoJPA extends PlayedRepo, JpaRepository<Played, Long> {


}
