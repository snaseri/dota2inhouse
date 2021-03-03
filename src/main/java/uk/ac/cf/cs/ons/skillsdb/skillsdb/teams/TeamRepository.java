package uk.ac.cf.cs.ons.skillsdb.skillsdb.teams;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * TeamRepository allows the caller to access to the teams data source.
 *
 * @author  Humzah Hanif
 * @version 1.0
 * @since   2019-11-19
 * @see     Team
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    /**
     * Find a Team by its name.
     *
     * @param name of the team you want to find.
     * @return Optional of the selected team.
     */
    Optional<Team> findByTeamName(String name);
}
