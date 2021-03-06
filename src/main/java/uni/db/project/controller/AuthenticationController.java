package uni.db.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uni.db.project.entity.User;
import uni.db.project.service.AuthenticationService;

/**
 * Created by Dimitry on 13.05.17.
 */
@Controller
@RequestMapping("/authentication")
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
            return "redirect:trap";
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
            authenticationService.createUser(user);
            return "redirect:sign_in";
        } else {
            model.addAttribute("error", "has-error");
            return "sign_up";
        }
    }

    @RequestMapping("/trap")
    public String getTrapPage(Model model) {
        return "trap";
    }
}
