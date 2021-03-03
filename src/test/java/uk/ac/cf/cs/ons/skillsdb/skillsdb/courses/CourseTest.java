package uk.ac.cf.cs.ons.skillsdb.skillsdb.courses;

import org.junit.Before;
import org.junit.Test;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CourseTest {

    private Course course;

    @Before
    public void setup() {
        Date date = new Date();
        course = new Course();
        course.setId(1);
        course.setName("Python");
        course.setDescription("teaching lots of python");
        course.setIsFree(false);
        course.setPrice(50.00);
        course.setDate(date);
        course.setUser(new User());

    }

    @Test
    public void courseCanChangeName() {
        String newName = "Python: 1";
        course.setName(newName);
        assertEquals( newName, course.getName() );
    }

    @Test
    public void courseCanChangeDescripton() {
        String newDescription = "Python for Starters";
        course.setDescription(newDescription);
        assertEquals( newDescription, course.getDescription() );

    }

    @Test
    public void courseCanChangePrice() {
        double newPrice = 50.50;
        course.setPrice(newPrice);
        assertEquals( newPrice, course.getPrice(), 0 );
    }

}