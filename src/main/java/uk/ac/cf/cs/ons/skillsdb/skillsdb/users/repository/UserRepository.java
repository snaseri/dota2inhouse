package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;

public interface UserRepository extends JpaRepository<User, Long> {


    User findByUsername(String username);
}
