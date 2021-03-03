package uk.ac.cf.cs.ons.skillsdb.skillsdb.courses;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.enrolledoncourse.EnrolledRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skills.Skill;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skills.SkillRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.UserService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(CourseController.class)
public class ViewCourseDetailTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    CourseRepository courseRepo;
    @MockBean
    SkillRepository skillRepo;
    @MockBean
    EnrolledRepository enrollRepo;
    @MockBean
    UserService userRepo;

    @WithMockUser(value = "spring")
    @Test
    public void theOneWhereTheCourseDetailsAreOK() throws Exception {


        Date date = new Date();
        User user = new User();
        user.setId(1); user.setUsername("sepehr"); user.setPassword("password");

        date.setYear(2015); date.setMonth(5); date.setDate(20);

        Skill skill  = new Skill();
        skill.setName("Java");
        skill.setDescription("Skill description is very simple and easy");
        skill.setId(1);

        List<Skill> list = new ArrayList<>();
        list.add(skill);
        given(this.skillRepo.findAll()).willReturn(list);
        given(this.enrollRepo.findAllByUserIdAndCourseId(1,1)).willReturn(null);

        Course course = new Course();
        course.setName("Java");
        course.setDescription("Java coooooooourse");
        course.setPrice(50.0);
        course.setDate(date);
        course.setIsFree(false);
        course.setSkillId(skill);
        course.setUser(user);
        given(this.courseRepo.findById(1L)).willReturn(Optional.of(course));
        given(this.enrollRepo.countAllByCourseIdIs(1L)).willReturn(0);

        mvc.perform
                (MockMvcRequestBuilders.get
                        ("/courses/1")
                )
                .andDo(
                        print()
                )
                .andExpect(
                        status().isOk()
                )
                .andExpect(
                        content().string(containsString("Java"))
                )

        ;

    }

}
