package uk.ac.cf.cs.ons.skillsdb.skillsdb.courses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepoJPA extends CourseRepository, JpaRepository<Course, Long> {


}