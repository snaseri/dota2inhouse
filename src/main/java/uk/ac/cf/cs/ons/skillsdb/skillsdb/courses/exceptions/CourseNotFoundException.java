package uk.ac.cf.cs.ons.skillsdb.skillsdb.courses.exceptions;

public class CourseNotFoundException extends Exception {
  public CourseNotFoundException(String errorMessage) {
    super(errorMessage);
  }
}
