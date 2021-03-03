package uk.ac.cf.cs.ons.skillsdb.skillsdb.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * UserServiceImpl is an implementation of {@see UserService} allowing controlled access to the UserRepository.
 *
 * @author  Humzah Hanif
 * @version 1.0
 * @since   2019-11-26
 * @see     User
 * @see     UserService
 */
@Service
@Transactional

public class UserServiceImpl implements UserDetailsService,UserService {




    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder encoder;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Allows for an implementation of UserService to be created with an implementation of UserRepository.
     * 
     * @param repository, implementation of UserRepository.
     */
    public UserServiceImpl(UserRepository repository) {
        userRepository = repository;
    }

    /**
     * Find a User by their unique id.
     *
     * @param id, Users id
     * @return Optional of user
     */
    @Override
    public Optional<User> findUserByIndex(long id) {
        return userRepository.findById(id);
    }

    /**
     * Find a User(s) by similar username(s).
     *
     * @param searchTerm, Users usernames.
     * @return Optional of a list of potentially matching users.
     */
    @Override
    public Optional<List<User>> findUserBySearch(String searchTerm){
        return userRepository.findByUsernameContains(searchTerm);
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
    }


    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }



    @Override
    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteUserById(id);
    }


}
