package uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts;

import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;


/**
 * AdvertRepository is a Contract that all AdvertRepositories must implement, following the Repository
 * Pattern.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-12-11
 * @see     Advert
 * @url     https://spring.io/projects/spring-data-jpa
 */
public interface AdvertRepository {

    /**
     * Find all Adverts where the advert title is like title.
     *
     * @param title, Adverts title
     * @return Optional set of Adverts
     */
    Optional<Set<Advert>> findByTitleContains(String title);

    /**
     * Find a Advert by the adverts unique id.
     *
     * @param id, Adverts unique id.
     * @return Optional of Advert
     */
    Optional<Advert> findById(Long id);

    /**
     * Save Advert.
     *
     * @param advert, Advert to save.
     * @return Advert.
     */
    <S extends Advert> S save(S advert);

    /**
     * Find all Adverts with associated skill.
     *
     * @param skill, Skill to search Adverts for.
     * @return Optional set of matching adverts.
     */
    Optional<Set<Advert>> findAllBySkillIdName(String skill);

    /**
     * Find all Adverts.
     *
     * @return Iterable of all Adverts.
     */
    Iterable<Advert> findAll();
}
