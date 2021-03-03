package uk.ac.cf.cs.ons.skillsdb.skillsdb.skills;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts.Advert;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts.AdvertRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts.AdvertService;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.associatedskills.AssociatedSkill;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.associatedskills.AssociatedSkillService;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.courses.Course;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.courses.CourseController;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.courses.CourseRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.enrolledoncourse.EnrolledRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skilltaxonomy.SkillTaxonomy;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skilltaxonomy.TaxonomyRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.UserService;

import java.util.*;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SkillsController.class)
public class ViewSkillProfile {

    @Autowired
    private MockMvc mvc;

    @MockBean
    CourseRepository courseRepo;
    @MockBean
    SkillRepository skillRepo;
    @MockBean
    UserService userRepo;
    @MockBean
    TaxonomyRepository taxoRepo;
    @MockBean
    AssociatedSkillService assosRepo;
    @MockBean
    AdvertService advertRepo;

    @Before
    public void setup() {
        Date date = new Date();
        User user = new User();
        user.setId(1); user.setUsername("sepehr"); user.setPassword("password");

        date.setYear(2015); date.setMonth(5); date.setDate(20);

        Skill skill  = new Skill();
        skill.setName("Java");
        skill.setDescription("Skill description is very simple and easy");
        skill.setId(1);

        Skill childSkill  = new Skill();
        childSkill.setName("ChildSkill");
        childSkill.setDescription("Child description is very simple and easy");
        childSkill.setId(2);

        Skill parentSkill  = new Skill();
        parentSkill.setName("ParentSkill");
        parentSkill.setDescription("Parent description is very simple and easy");
        parentSkill.setId(3);

        SkillTaxonomy taxonomy = new SkillTaxonomy();
        taxonomy.setId(1);
        taxonomy.setParent(parentSkill);
        taxonomy.setChild(childSkill);


        Course course = new Course();
        course.setName("Java");
        course.setDescription("Java coooooooourse");
        course.setPrice(50.0);
        course.setDate(date);
        course.setIsFree(false);
        course.setSkillId(skill);
        course.setUser(user);

        List<AssociatedSkill> emptylist = new ArrayList();

        given(this.skillRepo.findSkillByName("java")).willReturn(Optional.of(skill));
        given(this.taxoRepo.findAllByParentName("java")).willReturn(List.of(taxonomy));
        given(this.taxoRepo.findAllByChildName("java")).willReturn(List.of(taxonomy));
        given(this.courseRepo.findAllBySkillIdName("java")).willReturn(List.of(course));
        given(this.assosRepo.findBySkillName("java")).willReturn(emptylist);

    }

    @WithMockUser(value = "spring")
    @Test
    public void SkillNameIsDisplayed() throws Exception {

        mvc.perform
                (MockMvcRequestBuilders.get
                        ("/skill/java")
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

    @WithMockUser(value = "spring")
    @Test
    public void SkillDescriptionIsDisplayed() throws Exception {

        mvc.perform
                (MockMvcRequestBuilders.get
                        ("/skill/java")
                )
                .andExpect(
                        status().isOk()
                )
                .andExpect(
                        content().string(containsString("Skill description is very simple and easy"))
                )

        ;

    }

    @WithMockUser(value = "spring")
    @Test
    public void SkillParentIsDisplayed() throws Exception {

        mvc.perform
                (MockMvcRequestBuilders.get
                        ("/skill/java")
                )
                .andExpect(
                        status().isOk()
                )
                .andExpect(
                        content().string(containsString("ParentSkill"))
                )

        ;

    }

    @WithMockUser(value = "spring")
    @Test
    public void SkillChildIsDisplayed() throws Exception {

        mvc.perform
                (MockMvcRequestBuilders.get
                        ("/skill/java")
                )
                .andExpect(
                        status().isOk()
                )
                .andExpect(
                        content().string(containsString("ChildSkill"))
                )

        ;

    }

    @WithMockUser(value = "spring")
    @Test
    public void AllCoursesForSkillDisplayed() throws Exception {

        mvc.perform
                (MockMvcRequestBuilders.get
                        ("/skill/java")
                )
                .andExpect(
                        status().isOk()
                )
                .andExpect(
                        content().string(containsString("Java coooooooourse"))
                )

        ;

    }

    @WithMockUser(value = "spring")
    @Test
    public void NoUsersShouldBeDisplayed() throws Exception {

        mvc.perform
                (MockMvcRequestBuilders.get
                        ("/skill/java")
                )
                .andDo(
                        print()
                )
                .andExpect(
                        status().isOk()
                )
                .andExpect(
                        content().string(containsString("There are currently no available users for this skill"))
                )

        ;

    }

    @WithMockUser(value = "spring")
    @Test
    public void NoAdvertsShouldBeDisplayed() throws Exception {

        mvc.perform
                (MockMvcRequestBuilders.get
                        ("/skill/java")
                )
                .andDo(
                        print()
                )
                .andExpect(
                        status().isOk()
                )
                .andExpect(
                        content().string(containsString("There are currently no available adverts for this skill"))
                )

        ;

    }
}
