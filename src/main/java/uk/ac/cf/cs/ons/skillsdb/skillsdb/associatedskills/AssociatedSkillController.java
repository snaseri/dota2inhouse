package uk.ac.cf.cs.ons.skillsdb.skillsdb.associatedskills;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class AssociatedSkillController {

    private AssociatedSkillService service;

    public AssociatedSkillController(AssociatedSkillService service){this.service = service;}

    @GetMapping("as/{id}")
    public String showASPage(@PathVariable("id") long id, Model model){

        Optional<AssociatedSkill> as = service.findByASIndex(id);

        if (as.isPresent()) {
            model.addAttribute("aSKey", as.get());
            return "0";
        } else{
            return "404";
        }
    }

    @GetMapping("findBySkill")
    public String findBySkill(@RequestParam("search") String searchTerm, Model model) {

        List<AssociatedSkill> asList = service.findBySkillName(searchTerm);

        if (!asList.isEmpty()){
            model.addAttribute("searchTermKey", searchTerm);
            List userList = new ArrayList<User>();
            for (AssociatedSkill i : asList){
                userList.add(i.getUser());
            }

            model.addAttribute("asListKey", asList);
            model.addAttribute("userListKey", userList);
            return "as/as_list";
        } else {
            return "404";
        }
    }
}
