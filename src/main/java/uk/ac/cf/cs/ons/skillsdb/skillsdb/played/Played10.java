package uk.ac.cf.cs.ons.skillsdb.skillsdb.played;

import lombok.Data;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.matches.Match;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.players.Player;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class Played10 {

    /**
     * Id of the user.
     *
     * @param id New id for the user.
     * @return id of the user.
     */



    private long id;
    @NotNull
    private Player playerId;
    private Match matchId;
    @Min(0)
    @NotNull
    private Double kills;
    @Min(0)
    @NotNull
    private Double assists;
    @Min(0)
    @NotNull
    private Double deaths;
    private Boolean isWon;
    private String playerRole;
    private String playerTeam;

    private Boolean isRadientWinner;
    private Boolean isDireWinner;

    private long id1;
    @NotNull
    private Player playerId1;
    private Match matchId1;
    @Min(0)
    @NotNull
    private Double kills1;
    @Min(0)
    @NotNull
    private Double assists1;
    @Min(0)
    @NotNull
    private Double deaths1;
    private Boolean isWon1;
    private String playerRole1;
    private String playerTeam1;

    private long id2;
    @NotNull
    private Player playerId2;
    private Match matchId2;
    @Min(0)
    @NotNull
    private Double kills2;
    @Min(0)
    @NotNull
    private Double assists2;
    @Min(0)
    @NotNull
    private Double deaths2;
    private Boolean isWon2;
    private String playerRole2;
    private String playerTeam2;

    private long id3;
    private Player playerId3;
    private Match matchId3;
    @Min(0)
    @NotNull
    private Double kills3;
    @Min(0)
    @NotNull
    private Double assists3;
    @Min(0)
    @NotNull
    private Double deaths3;
    private Boolean isWon3;
    private String playerRole3;
    private String playerTeam3;

    private long id4;
    @NotNull
    private Player playerId4;
    private Match matchId4;
    @Min(0)
    @NotNull
    private Double kills4;
    @Min(0)
    @NotNull
    private Double assists4;
    @Min(0)
    @NotNull
    private Double deaths4;
    private Boolean isWon4;
    private String playerRole4;
    private String playerTeam4;

    private long id5;
    @NotNull
    private Player playerId5;
    private Match matchId5;
    @Min(0)
    @NotNull
    private Double kills5;
    @Min(0)
    @NotNull
    private Double assists5;
    @Min(0)
    @NotNull
    private Double deaths5;
    private Boolean isWon5;
    private String playerRole5;
    private String playerTeam5;

    private long id6;
    @NotNull
    private Player playerId6;
    private Match matchId6;
    @Min(0)
    @NotNull
    private Double kills6;
    @Min(0)
    @NotNull
    private Double assists6;
    @Min(0)
    @NotNull
    private Double deaths6;
    private Boolean isWon6;
    private String playerRole6;
    private String playerTeam6;

    private long id7;
    @NotNull
    private Player playerId7;
    private Match matchId7;
    @Min(0)
    @NotNull
    private Double kills7;
    @Min(0)
    @NotNull
    private Double assists7;
    @Min(0)
    @NotNull
    private Double deaths7;
    private Boolean isWon7;
    private String playerRole7;
    private String playerTeam7;

    private long id8;
    @NotNull
    private Player playerId8;
    private Match matchId8;
    @Min(0)
    @NotNull
    private Double kills8;
    @Min(0)
    @NotNull
    private Double assists8;
    @Min(0)
    @NotNull
    private Double deaths8;
    private Boolean isWon8;
    private String playerRole8;
    private String playerTeam8;

    private long id9;
    @NotNull
    private Player playerId9;
    private Match matchId9;
    @Min(0)
    @NotNull
    private Double kills9;
    @Min(0)
    @NotNull
    private Double assists9;
    @Min(0)
    @NotNull
    private Double deaths9;
    private Boolean isWon9;
    private String playerRole9;
    private String playerTeam9;

}
