package uk.ac.cf.cs.ons.skillsdb.skillsdb.types;

import uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts.Advert;

/**
 * Types also have names which are noted below.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-11-19
 * @see     Type
 */
public enum AdvertType {
  ACCELERATION("Acceleration"),
  TUTORING("Tutoring"),
  ADVICE("Advice"),
  ASSISTANCE("Assitance");

  private final String name;

  AdvertType(String name) {
    this.name = name;
  }

  public String toString() {
    return name;
  }
}
