package uni.db.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uni.db.project.entity.User;
import uni.db.project.service.AuthenticationService;

/**
 * Created by Dimitry on 13.05.17.
 */
@Controller
//@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping("/sign_in")
    public ModelAndView getSignIn() {
        return new ModelAndView("/authentication/sign_in", "command", new User());
    }

    @PostMapping("/validateUser")
    public String validateUser(@ModelAttribute("SpringWeb") User user, ModelMap model) {
        if (authenticationService.validateUser(user.getUsername(), user.getEmail(), user.getPassword())) {
            return "redirect:/trap";
        } else {
//            model.addAttribute("error", "has-error");
            return "redirect:/sign_in";
        }
    }

    @RequestMapping("/sign_up")
    public String getSignUpPage(Model model) {
        model.addAttribute("user", new User());
        return "authentication/sign_up";
    }

    @PostMapping("/createNewUser")
    public String createNewUser(@ModelAttribute("user") User user) {
        if (user.getUsername() != null
                && !user.getUsername().equals("")
                && user.getEmail() != null
                && !user.getEmail().equals("")
                && authenticationService.validateEmail(user.getEmail())
                && user.getPassword() != null
                && !user.getPassword().equals("")
                && authenticationService.validatePassword(user.getPassword())) {
            authenticationService.createNewUser(user);
            return "redirect:/sign_in";
        } else {
            return "redirect:/sign_up";
        }
    }

    @RequestMapping("/trap")
    public String getTrapPage() {
        return "authentication/trap";
    }


//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public ModelAndView user() {
//        return new ModelAndView("/user", "command", new User());
//    }
//
//    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
//    public String addUser(@ModelAttribute("SpringWeb")User user,
//                          ModelMap model) {
//        model.addAttribute("username", user.getUsername());
//        model.addAttribute("password", user.getPassword());
//
//        return "/users";
//    }


}
