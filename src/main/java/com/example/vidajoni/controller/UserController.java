package com.example.vidajoni.controller;

import com.example.vidajoni.domain.user;
import com.example.vidajoni.repository.userRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private userRepository userRepository;

    public UserController(com.example.vidajoni.repository.userRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register/submit")
    public String createUser(RedirectAttributes redirectAttributes, @RequestParam String name, @RequestParam String username, @RequestParam String password, @RequestParam String address, @RequestParam String email, @RequestParam String number){
        System.out.println("vi är här!");
        user user1 = new user(name, username, password, address, email, number);
        userRepository.save(user1);
        logger.info("Ny användare registrerad");
        redirectAttributes
                .addAttribute(user1)
                .addFlashAttribute("success", true);
        return "annonser";
    }

    @GetMapping("/login")
    public String loginview(){
        return "login";
    }

    @PostMapping("/login/submit")
    public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes){
        List<user> users = userRepository.findAll();

        for (user currentUser: users) {

            if (username.equals(currentUser.getUserName()) && password.equals(currentUser.getPassword())){

                    String loginSuccess = "Välkommen, "+currentUser.getUserName();
                    redirectAttributes.addFlashAttribute(loginSuccess);
                    return "annonser";
            }
        }

        String loginFail = "Fel användarnamn och/eller lösenord";
        redirectAttributes.addFlashAttribute(loginFail);
        return "login";
    }

}
