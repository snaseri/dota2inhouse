package uk.ac.cf.cs.ons.skillsdb.skillsdb.played;

import uk.ac.cf.cs.ons.skillsdb.skillsdb.types.Type;

/**
 * Types also have names which are noted below.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-11-19
 * @see     Type
 */
public enum PlayerRole {
  HARD_SUPPORT("Hard Support"),
  SUPPORT("Support"),
  OFFLANE("Offlane"),
  MID_LANE("Midlane"),
  HARD_CARRY("Carry");

  private final String name;

  PlayerRole(String name) {
    this.name = name;
  }

  public String toString() {
    return name;
  }
}
