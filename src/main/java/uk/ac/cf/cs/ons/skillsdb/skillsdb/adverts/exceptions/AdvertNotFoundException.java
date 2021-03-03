package uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts.exceptions;

public class AdvertNotFoundException extends Exception {
  public AdvertNotFoundException(String errorMessage) {
    super(errorMessage);
  }
}
