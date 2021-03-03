package uk.ac.cf.cs.ons.skillsdb.skillsdb.played;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.matches.Match;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.players.Player;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skills.Skill;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.types.AdvertType;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "Played")
public class Played {

    /**
     * Id of the user.
     *
     * @param id New id for the user.
     * @return id of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "player_id")
    private Player playerId;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "match_id")
    private Match matchId;


    @Column(name = "kills")
//    @Min(0)
//    @NotNull
    private Double kills;

    @Column(name = "assists")
//    @Min(0)
//    @NotNull
    private Double assists;

    @Column(name = "deaths")
//    @Min(0)
//    @NotNull
    private Double deaths;


    @Column(name = "is_won")
    private Boolean isWon;


    @Column(name = "player_role")
    private String playerRole;

    @Column(name = "player_team")
    private String playerTeam;


//    public String prettyDate() {
//        return date.format (DateTimeFormatter.ofPattern("yyyy-MM-dd") );
//    }

    public String getUrl() {
        return "/played/" + id;
    }
}
