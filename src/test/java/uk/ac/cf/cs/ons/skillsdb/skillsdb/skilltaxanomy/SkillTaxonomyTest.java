package uk.ac.cf.cs.ons.skillsdb.skillsdb.skilltaxanomy;

import org.junit.Before;
import org.junit.Test;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skills.Skill;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skilltaxonomy.SkillTaxonomy;

import static org.junit.Assert.assertEquals;

public class SkillTaxonomyTest {

  private SkillTaxonomy skilltaxanomy;
  private Skill child = new Skill();
  private Skill parent = new Skill();


  @Before
  public void setup() {
    parent.setId(1);
    parent.setName("Java");
    parent.setName("Objects");

    child.setId(2);
    child.setName("Python");
    child.setDescription("Procedural");

    skilltaxanomy = new SkillTaxonomy();
    skilltaxanomy.setId(2);
    skilltaxanomy.setParent(parent);
    skilltaxanomy.setChild(child);
  }

  @Test
  public void taxonomyCanHaveIdChanged() {
    int newId = 2;
    skilltaxanomy.setId(newId);
    assertEquals( newId, skilltaxanomy.getId() );
  }

  @Test
  public void skillParentCanBeChanged() {
    int newId = 2;
    skilltaxanomy.setId(newId);
    skilltaxanomy.setChild(parent);
    assertEquals( skilltaxanomy.getChild(), skilltaxanomy.getParent() );
  }

  @Test
  public void taxonomyParentCanHaveNameChanged() {
    String newName = "Python";
    skilltaxanomy.getParent().setName(newName);
    assertEquals( newName, skilltaxanomy.getParent().getName() );
  }

  @Test
  public void taxonomyChildCanHaveDescriptionChanged() {
    String newDesc = "Programming with Python 3.7";
    skilltaxanomy.getChild().setDescription(newDesc);
    assertEquals( newDesc, skilltaxanomy.getChild().getDescription() );
  }


}
