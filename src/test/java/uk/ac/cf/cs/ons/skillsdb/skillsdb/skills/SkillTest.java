package uk.ac.cf.cs.ons.skillsdb.skillsdb.skills;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SkillTest {

  private Skill skill;

  @Before
  public void setup() {
    skill = new Skill();
    skill.setId(1);
    skill.setName("Java");
    skill.setDescription("Programming with Java: 11");
  }

  @Test
  public void skillCanHaveIdChanged() {
    int newId = 2;
    skill.setId(newId);
    assertEquals( newId, skill.getId() );
  }

  @Test
  public void skillCanHaveNameChanged() {
    String newName = "Python";
    skill.setName(newName);
    assertEquals( newName, skill.getName() );
  }

  @Test
  public void skillCanHaveDescriptionChanged() {
    String newDesc = "Programming with Python 3.7";
    skill.setDescription(newDesc);
    assertEquals( newDesc, skill.getDescription() );
  }


}
