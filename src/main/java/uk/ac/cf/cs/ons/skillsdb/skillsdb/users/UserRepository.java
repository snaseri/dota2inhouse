package uk.ac.cf.cs.ons.skillsdb.skillsdb.users;

import java.util.List;
import java.util.Optional;

/**
 * UserRepository defines a contract that UserRepositories must implement to be considered a UserRepository.
 *
 * @author  Kyle Davies
 * @author  Humzah Hanif
 * @version 1.0
 * @since   2019-11-26
 * @see     User
 */
public interface UserRepository  {

    /**
     * Find a User by username.
     *
     * @param username, Users username.
     * @return Optional of user.
     */
    User findByUsername(String username);

    /**
     * Find a User(s) by similar username(s).
     *
     * @param username, Users usernames.
     * @return Optional of a list of potentially matching users.
     */
    Optional<List<User>> findByUsernameContains(String username);

    /**
     * Find a User by their unique id.
     *
     * @param id, Users unique id.
     * @return Optional of user.
     */
    Optional<User> findById(Long id);

    /**
     * Delete a user.
     *
     * @param id, User to delete.
     */
    void deleteUserById(long id);

    /**
     * Save a User.
     *
     * @param user, User to save.
     * @return user.
     */
    <S extends User> S save(S user);

}
