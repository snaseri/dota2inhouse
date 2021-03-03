package uk.ac.cf.cs.ons.skillsdb.skillsdb.played;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.played.Played;

import java.util.List;

@Component
public interface PlayedRepo {

    public Played save(Played aPlayed);
    <S extends Played> List<S> saveAll(Iterable<S> entities);
      List<Played> findAllByMatchIdIdAndPlayerTeam(Long id, String team);
      List<Played> findAllByMatchIdId(Long id);
//

    @Query(value = "select sum(kills) from played where player_id = ?1",
            nativeQuery = true)
    Integer getKillSumByPlayerId(Long player_id);

    @Query(value = "select sum(deaths) from played where player_id = ?1",
            nativeQuery = true)
    Integer getDeathSumByPlayerId(Long player_id);

    @Query(value = "select sum(assists) from played where player_id = ?1",
            nativeQuery = true)
    Integer getAssistsSumByPlayerId(Long player_id);

    @Query(value = "select count(player_id) from played where player_id = ?1",
            nativeQuery = true)
    Integer getTotalGamesPlayer(Long player_id);

    @Query(value = "select count(player_id) from played where player_id = ?1 AND player_role = ?2",
            nativeQuery = true)
    Integer getGamesOnRole(Long player_id, String role);

    @Query(value = "select count(player_id) from played where player_id = ?1 AND is_won = 1",
            nativeQuery = true)
    Integer getGamesWon(Long player_id);

    @Query(value = "select count(player_id) from played where player_id = ?1 AND is_won = 0",
            nativeQuery = true)
    Integer getGamesLost(Long player_id);




}
