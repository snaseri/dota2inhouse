package uk.ac.cf.cs.ons.skillsdb.skillsdb.players;

import lombok.Data;

@Data
public class PlayerStats {

    private String name;
    private int kills;
    private int deaths;
    private int assists;
    private int wins;
    private int losses;
    private int totalgames;

    public double winrate() {
        return wins/losses;
    }

    private int hardsup;
    private int sup;
    private int off;
    private int carry;
    private int mid;
}
