package uk.ac.cf.cs.ons.skillsdb.skillsdb.courses;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.enrolledoncourse.EnrolledOnCourse;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.enrolledoncourse.EnrolledRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skills.Skill;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skills.SkillRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.UserService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CourseController {

    private CourseRepository courseRepo;
    private SkillRepository skillRepo;
    private EnrolledRepository enrollRepo;
    private UserService userRepo;

    public CourseController(CourseRepository aRepo, SkillRepository sRepo, EnrolledRepository eRepo, UserService uRepo) {
        courseRepo = aRepo;
        skillRepo = sRepo;
        enrollRepo = eRepo;
        userRepo = uRepo;

    }


    @GetMapping(path = "/course/create")
    public String createCourse(Model model) {
        model.addAttribute("course", new Course());
        model.addAttribute("skills", skillRepo.findAll());
        return "courses/create";
    }

    @PostMapping("/course/create")
    public String submitCourse(@ModelAttribute("course") @Valid Course course, BindingResult result, Model model) {

        if (course.getSkillId() == null) {
            Skill s = new Skill();
            s.setDescription("Unspecified");
            s.setName("Unspecified");
            course.setSkillId(s);
        }

        if ( result.hasErrors() ) {
            model.addAttribute("skills", skillRepo.findAll());
            return "courses/create";
        }

        //TODO set the user as the logged in user
        User defaultUser = new User();
        defaultUser.setPassword("password");
        defaultUser.setUsername("username");
        course.setUser(defaultUser);
        courseRepo.save(course);

        return "redirect:/courses/" + course.getId();
    }

    @GetMapping("/courses/{id}")
    public String coursePage(@PathVariable("id") Long id, Model model) {

            String enrollmessage = null;
        
            Optional<Course> course = courseRepo.findById(id);
            if (!course.isPresent()) {
                return "404";
            }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username =  authentication.getName();

        User user = userRepo.findByUsername(username);


//        if(enrollRepo.findAllByUserIdAndCourseId(user.getId(),id).isPresent()) {
//            enrollmessage = "You have already enrolled for this course";
//        }

            int enrolledUsers = enrollRepo.countAllByCourseIdIs(course.get().getId());
            model.addAttribute("course", course.get());
            model.addAttribute("enrolled", enrolledUsers);
            model.addAttribute("enrollmessage", enrollmessage);


        return "courses/course";
    }

    @PostMapping("/courses/{id}")
    public String courseEnroll(@PathVariable("id") Long id, Model model) {


        String enrollmessage = null;

        Optional<Course> course = courseRepo.findById(id);
        if (!course.isPresent()) {
            return "404";
        }

        int enrolledUsers = enrollRepo.countAllByCourseIdIs(course.get().getId());
        //TODO set the user as the logged in user

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username =  authentication.getName();

        User user = userRepo.findByUsername(username);


//        User defaultUser = new User();
//        defaultUser.setPassword("password");
//        defaultUser.setUsername("username");

        EnrolledOnCourse enroll = new EnrolledOnCourse();


        if(enrollRepo.findAllByUserIdAndCourseId(user.getId(),id).isPresent()) {
            enrollmessage = "You have enrolled for this course";
            return "redirect:/courses/" + id;
        }
        else {
            enroll.setCourse(course.get());
            enroll.setUser(userRepo.findUserByIndex(user.getId()).get());
            enrollRepo.save(enroll);
            enrolledUsers = enrollRepo.countAllByCourseIdIs(course.get().getId());
            enrollmessage = "You have successfully enrolled on this course";
        }

        model.addAttribute("course", course.get());
        model.addAttribute("enroll", enroll);
        model.addAttribute("enrolled", enrolledUsers);
        model.addAttribute("enrollmessage", enrollmessage);

        return "/courses/course";
    }


}
