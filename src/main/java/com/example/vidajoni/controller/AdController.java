package com.example.vidajoni.controller;

import com.example.vidajoni.domain.ad;
import com.example.vidajoni.domain.user;
import com.example.vidajoni.repository.AdRepository;
import com.example.vidajoni.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdController {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private userRepository userRepository;


    @GetMapping("/ads")
    public String listAds(Model model) {
        List<ad> ads = adRepository.findAll();
        model.addAttribute("ads", ads);
        return "adlist";

    }

/*    @GetMapping("/user")
    public String listUsers (Model model){
        List<user> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "user";
    }*/

    @GetMapping("/user")
    public String listUsers (Model model){
        model.addAttribute("users", userRepository.findAll());
        return "user";
    }

    //    @GetMapping("/findAllCharacters")
    //    public String allCharacters(Model model) {
    //        List<Character> allCharacters = repository.findAllCharacters();
    //        model.addAttribute("characters", allCharacters);
    //        return "showAllCharacters";
    //    }
}
