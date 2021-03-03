package uk.ac.cf.cs.ons.skillsdb.skillsdb.reviews;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepoJPA extends ReviewRepository, JpaRepository<Review, Long> {
}
