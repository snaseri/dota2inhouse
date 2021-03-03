package uk.ac.cf.cs.ons.skillsdb.skillsdb.users;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

/**
 * UserService is a contract that a UserService must be implemented Allowing for controlled access to
 * the UserRepository.
 *
 * @author  Humzah Hanif
 * @version 1.0
 * @since   2019-11-26
 * @see     User
 */
public interface UserService {

    /**
     * Find a User by their unique id.
     *
     * @param id, Users id
     * @return Optional of user
     */
    Optional<User> findUserByIndex(long id);

    /**
     * Find a User(s) by similar username(s).
     *
     * @param searchTerm, Users usernames.
     * @return Optional of a list of potentially matching users.
     */
    Optional<List<User>> findUserBySearch(String searchTerm);

    UserDetails loadUserByUsername(String username);


    User findByUsername(String username);

    void save(User user);

    void deleteUserById (long id);


}

