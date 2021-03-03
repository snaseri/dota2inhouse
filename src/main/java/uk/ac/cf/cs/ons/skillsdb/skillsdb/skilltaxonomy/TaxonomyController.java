package uk.ac.cf.cs.ons.skillsdb.skillsdb.skilltaxonomy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.skills.SkillRepository;

@Controller
public class TaxonomyController {

    private SkillRepository skillRepo;

    public TaxonomyController(SkillRepository sRepo) {
        skillRepo = sRepo;
    }

    @GetMapping(path = "/discover")
    public String createCourse(Model model) {
        model.addAttribute("skills", skillRepo.findAll());
        return "discover/skilldiscover";
    }

    @GetMapping("/discoverSkill")
    public String submitCourse(@RequestParam("search") String searchTerm, Model model) {
        return "redirect:/skill/" + searchTerm;
    }
}
