package uk.ac.cf.cs.ons.skillsdb.skillsdb.players;

import uk.ac.cf.cs.ons.skillsdb.skillsdb.played.Played;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.players.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerRepo {

    List<Player> findAll();
    public Player save(Player aPlayer);
    Optional<Player> findById(Long aLong);

}
