package uk.ac.cf.cs.ons.skillsdb.skillsdb.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts.Advert;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts.AdvertRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.associatedskills.AssociatedSkill;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.associatedskills.AssociatedSkillRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.courses.Course;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.courses.CourseRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class SearchServiceImpl implements SearchService {

    private UserRepository userRepository;

    private AdvertRepository advertRepository;

    private CourseRepository courseRepository;

    private AssociatedSkillRepository associatedSkillRepository;

    @Autowired
    public SearchServiceImpl(UserRepository userRepository,
                             AdvertRepository advertRepository,
                             CourseRepository courseRepository,
                             AssociatedSkillRepository associatedSkillRepository) {
        this.userRepository = userRepository;
        this.advertRepository = advertRepository;
        this.courseRepository = courseRepository;
        this.associatedSkillRepository = associatedSkillRepository;
    }


    @Override
    public Optional<List<SearchResult>> searchByTitle(String title, SearchType type) {
        switch(type) {
            case USER:
                return searchByUser(title);
            case ADVERT:
                return searchByAdvert(title);
            default:
            case COURSE:
                return searchByCourse(title);
        }
    }

    private Optional<List<SearchResult>> searchByCourse(String terms) {

        // TODO: Carl, how can I improve this?

        List<SearchResult> results = new ArrayList<>();

        Optional<List<Course>> courses = courseRepository.findByNameContains(terms);

        if ( courses.isPresent() ) {
            for( Course c: courses.get() ) {
                results.add( SearchResult.of(c.getName(), c.getDescription(), c.getUrl()) );
            }
            return Optional.of(results);
        } else {
            return Optional.empty();
        }

    }

    private Optional<List<SearchResult>> searchByAdvert(String terms) {

        // TODO: Carl, how can I improve this?

        List<SearchResult> results = new ArrayList<>();

        Optional<Set<Advert>> adverts = advertRepository.findByTitleContains(terms);

        if ( adverts.isPresent() ) {
            for(Advert a: adverts.get()) {
                results.add( SearchResult.of( a.getTitle(), a.getDescription(), a.getUrl() ) );
            }
            return Optional.of(results);
        } else {
            return Optional.empty();
        }

    }

    private Optional<List<SearchResult>> searchByUser(String  terms) {

        List<SearchResult> results = new ArrayList<>();

        // This code is Humzahs, which I am using, but he wrote the function to get users by their skills.

        List<Long> userIds = new ArrayList<>();
        List<User>  users = new ArrayList<>();

        associatedSkillRepository.findABySkillName(terms).forEach( u -> userIds.add(u.getId()) );

        for(Long id: userIds) {
            userRepository.findById(id).ifPresent( users::add );
        }

        Optional<List<User>> usersOpt = Optional.of(users);

        if ( usersOpt.isPresent() ) {
            for(User u: usersOpt.get()) {
                results.add( SearchResult.of( u.getUsername(), u.getUsername(), u.getUrl() ) );
            }
            return Optional.of(results);
        } else {
            return Optional.empty();
        }

    }
}
