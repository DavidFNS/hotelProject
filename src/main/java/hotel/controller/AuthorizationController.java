package hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authorization")
public class AuthorizationController {

    @PostMapping("/registration")
    public String RegisterPage(Model model){
        model.addAttribute("title", "Register");
        return "authorization/register";
    }

    @GetMapping("/login")
    public String LoginPage(Model model){
        model.addAttribute("title", "Login");
        return "authorization/login";
    }
}
