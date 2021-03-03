package uk.ac.cf.cs.ons.skillsdb.skillsdb.skills;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts.Advert;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.adverts.AdvertService;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.associatedskills.AssociatedSkill;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.associatedskills.AssociatedSkillService;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.courses.Course;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.courses.CourseRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skilltaxonomy.SkillTaxonomy;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skilltaxonomy.TaxonomyRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.UserService;

import java.util.*;

@Controller
public class SkillsController {

    private UserService userRepo;
    private SkillRepository skillRepo;
    private TaxonomyRepository taxoRepo;
    private CourseRepository courseRepo;
    private AssociatedSkillService assosRepo;
    private AdvertService advertRepo;


    public SkillsController(SkillRepository sRepo,UserService uRepo, TaxonomyRepository tRepo,
    CourseRepository cRepo, AssociatedSkillService aRepo, AdvertService adRepo){
        userRepo=uRepo;
        skillRepo=sRepo;
        taxoRepo=tRepo;
        courseRepo=cRepo;
        assosRepo = aRepo;
        advertRepo = adRepo;
    }

    /**
     * Return a HTML with the skill name, description, child and parent if exists,
     * courses, adverts and all the users who know the skill.
     *
     * @param name, skills unique name.
     * @return view
     */
    @GetMapping("skill/{i}")
    public String showUserPage(@PathVariable("i") String name, Model model){
        List<Advert> adverts1 = new ArrayList<Advert>();

        Optional<Skill> skill = skillRepo.findSkillByName(name);
        List<SkillTaxonomy> children = taxoRepo.findAllByParentName(name);
        List<SkillTaxonomy> parent = taxoRepo.findAllByChildName(name);
        List<Course> courses = courseRepo.findAllBySkillIdName(name);
        List<AssociatedSkill> assoskills = assosRepo.findBySkillName(name);
        Optional<Set<Advert>> adverts = advertRepo.findAllBySkillIdName(name);

        if (adverts.isPresent()) {
            adverts1.addAll(advertRepo.findAllBySkillIdName(name).get());
        }


//        adverts1.addAll(adverts.get());
//        adverts.ifPresent( set -> set.forEach(adverts1::add) );

        List userList = new ArrayList<User>();
        for (AssociatedSkill i : assoskills){
            userList.add(i.getUser());
        }


        if (skill.isPresent()) {
            model.addAttribute("skillKey", skill.get());
            model.addAttribute("childKey", children);
            model.addAttribute("parentKey", parent);
            model.addAttribute("courseKey", courses);
            model.addAttribute("userKey", userList);
            model.addAttribute("advertKey", adverts1);

            return "skill/skillprofile";
        } else {
            return "404";
        }
    }
}
