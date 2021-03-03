package uk.ac.cf.cs.ons.skillsdb.skillsdb.types;

import lombok.Data;

import javax.persistence.*;

/**
 * Adverts are represented by Types.
 *
 * @author  Kyle Davies
 * @version 1.0
 * @since   2019-11-19
 * @see     Advert
 */
@Data
@Entity
@Table(name = "Types")
public class Type {

  /**
   * Id of the Type.
   *
   * @param id New id of Type.
   * @return id of Type.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  /**
   * Type of the Type.
   *
   * @param name New name of type of Type.
   * @return name of Type.
   */
  @Enumerated(EnumType.STRING)
  private AdvertType name;


}
