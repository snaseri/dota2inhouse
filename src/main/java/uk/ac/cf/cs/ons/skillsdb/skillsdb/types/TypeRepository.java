package uk.ac.cf.cs.ons.skillsdb.skillsdb.types;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * TypeRepository allows for access to the Types data source.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-11-19
 * @see     Type
 */
@Repository
public interface TypeRepository extends CrudRepository<Type, Long> {
  // TODO: Add any needed queries here...
}

