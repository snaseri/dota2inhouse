package uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * AdvertRepositoryImpl is an implementation of the AdvertRepository, Which allows
 * access to Adverts data source.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-12-07
 * @see     Advert
 */
@Repository
public interface AdvertRepositoryImpl extends AdvertRepository, CrudRepository<Advert, Long> {

    /**
     * Find all Adverts where the advert title is like title.
     *
     * @param title@return Optional set of Adverts
     */
    @Override
    Optional<Set<Advert>> findByTitleContains(String title);

    /**
     * Find a Advert by the adverts unique id.
     *
     * @param id@return Optional of Advert
     */
    @Override
    Optional<Advert> findById(Long id);

    /**
     * Save Advert.
     *
     * @param advert@return Advert.
     */
    @Override
    <S extends Advert> S save(S advert);

    /**
     * Find all Adverts with associated skill.
     *
     * @param skill@return Optional set of matching adverts.
     */
    @Override
    Optional<Set<Advert>> findAllBySkillIdName(String skill);

    /**
     * Find all Adverts.
     *
     * @return Iterable of all Adverts.
     */
    @Override
    Iterable<Advert> findAll();
}
