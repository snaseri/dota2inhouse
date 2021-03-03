package uk.ac.cf.cs.ons.skillsdb.skillsdb.enrolledoncourse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrolledRepoJPA extends EnrolledRepository, JpaRepository<EnrolledOnCourse, Long> {

}
