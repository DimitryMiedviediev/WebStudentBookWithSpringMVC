package uni.db.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String getSignInPage() {
        return "authentication/sign_in";
    }

    @RequestMapping("/sign_up")
    public String getSignUpPage(Model model) {
        model.addAttribute("user", new User());
        return "authentication/sign_up";
    }

    @PostMapping("/createNewUser")
    public String createNewUser(@ModelAttribute("user") User user){
        authenticationService.createNewUser(user);
        return "redirect:/sign_in";
    }

    @RequestMapping("/trap")
    public String getTrapPage(){
        return "authentication/trap";
    }



}
