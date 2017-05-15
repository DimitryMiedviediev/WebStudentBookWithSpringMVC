package uni.db.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String getSignInPage(Model model) {
        model.addAttribute("user", new User());
        return "sign_in";
    }

    @PostMapping("/validateUser")
    public String validateUser(@ModelAttribute("user") User user, Model model){
        if(authenticationService.validateUser(user.getUsername(), user.getEmail(), user.getPassword())){
            return "redirect:/trap";
        }else{
            model.addAttribute("error", "has-error");
            return "sign_in";
        }
    }

    @RequestMapping("/sign_up")
    public String getSignUpPage(Model model) {
        model.addAttribute("user", new User());
        return "sign_up";
    }

    @PostMapping("/createNewUser")
    public String createNewUser(@ModelAttribute("user") User user, Model model) {
        if (authenticationService.testUserForm(user.getUsername(), user.getEmail(), user.getPassword())) {
            authenticationService.createNewUser(user);
            return "redirect:/sign_in";
        } else {
            model.addAttribute("error", "error");
            return "sign_up";
        }
    }

    @RequestMapping("/trap")
    public String getTrapPage() {
        return "trap";
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
