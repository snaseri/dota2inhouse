package uk.ac.cf.cs.ons.skillsdb.skillsdb.users.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.User;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.repository.UserRepository;
import uk.ac.cf.cs.ons.skillsdb.skillsdb.users.UserService;

import javax.validation.Valid;

/**
 *
 */
@Controller
public class loginController {

    @Autowired
    UserService userService;




    @Autowired
    UserRepository userRepository;




    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model, @AuthenticationPrincipal UserDetails currentUser) {


        UserDetails user = currentUser;
        model.addAttribute("user", user);
        return "index";
    }


    /**
     * Controller for loading login page.
     * If user is already logged in, open index model. If user is not logged in, open login model.
     * @return
     */
    @RequestMapping(value = { "/login", "/" }, method = RequestMethod.GET)
    public ModelAndView login() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {

            return new ModelAndView("forward:/search/");
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("login");
            return modelAndView;
        }
    }

    /**
     * Controller for loading register page
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }


    /**
     * Controller for registering user
     * @param user
     * @param bindingResult
     * @param modelMap
     * @return
     */
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        // Check for the validations
        if(userExists(user.getUsername())) {
            modelAndView.addObject("errorMessage", "Username taken, please choose another.");
        }

        else {
            userService.save(user);
            modelAndView.addObject("successMessage", "User is registered successfully!");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("login");
        }

        return modelAndView;
    }


    /**
     * Checks whether username is already taken.
     * @param username
     * @return
     */
    private boolean userExists(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return true;
        }
        return false;
    }




    public class SecurityController {

        @RequestMapping(value = "/username", method = RequestMethod.GET)
        @ResponseBody
        public String currentUserName(Authentication authentication) {
            return authentication.getName();
        }

    }








}
