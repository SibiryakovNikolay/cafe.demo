package project.demo.restoran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import project.demo.restoran.model.auth.User;
import project.demo.restoran.service.impl.UserServiceImpl;

import javax.validation.Valid;

@Controller
public class Registration {
    private UserServiceImpl userServiceImpl;

    @Autowired
    public Registration(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
    @GetMapping("/registration/success")
    public String successRegistration(){
        return "registration/success-page";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model){
        User user = new User();
        model.addAttribute("userForm", user);
        return "registration/registration-page";
    }
    @PostMapping("/registration")
    public String createUser(@ModelAttribute("userForm")@Valid User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "registration/registration-page";
        }
        if (!user.getPassword().equals(user.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration/registration-page";
        }
        if (!userServiceImpl.save(user)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration/registration-page";
        }
        userServiceImpl.save(user);
        return "redirect:/registration/success";
    }
}
