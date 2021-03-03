package uk.ac.cf.cs.ons.skillsdb.skillsdb.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * UserRepositoryImpl is the implementation of {@See UserRepository} allowing access to the data layer for users.
 *
 * @author  Kyle Davies
 * @author  Humzah Hanif
 * @verison 1.0
 * @since   2019-11-26
 * @see     User
 * @see     UserRepository
 * @url     https://spring.io/guides/gs/accessing-data-jpa/
 */
@Repository
public interface UserRepositoryImpl extends UserRepository, CrudRepository<User, Long> {

    /**
     * Find a User by username.
     *
     * @param username, Users username.
     * @return Optional of user.
     */
    @Override
    User findByUsername(String username);

    /**
     * Find a User(s) by similar username(s).
     *
     * @param username, Users usernames.
     * @return Optional of a list of potentially matching users.
     */
    @Override
    Optional<List<User>> findByUsernameContains(String username);

    /**
     * Find a User by their unique id.
     *
     * @param id, Users unique id.
     * @return Optional of user.
     */
    @Override
    Optional<User> findById(Long id);

    /**
     * Delete a user.
     *
     * @param id, User to delete.
     */
    @Override
    void deleteUserById(long id);

    /**
     * Save a User.
     *
     * @param user, User to save.
     * @return user.
     */
    @Override
    <S extends User> S save(S user);

}
