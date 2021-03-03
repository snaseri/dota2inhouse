package uk.ac.cf.cs.ons.skillsdb.skillsdb.players;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.players.Player;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.players.PlayerRepo;

import java.util.List;
import java.util.Optional;

public interface PlayerRepoJPA extends PlayerRepo, JpaRepository<Player, Long> {


}
