package uk.ac.cf.cs.ons.skillsdb.skillsdb.comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepoJPA extends CommentRepository, JpaRepository<Comment, Long> {
}
