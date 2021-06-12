package project.demo.restoran.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String showMainMenu(){
        return "main-page";
    }

    @GetMapping("/auth/login")
    public String authorization(){
        return "login-page";
    }

//    @GetMapping("/cafe/menu")
//    public String showMenu(){
//        return "menu/menu-page";
//    }
}
