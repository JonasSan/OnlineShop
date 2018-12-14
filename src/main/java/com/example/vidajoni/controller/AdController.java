package com.example.vidajoni.controller;

import com.example.vidajoni.domain.ad;
import com.example.vidajoni.domain.user;
import com.example.vidajoni.repository.AdRepository;
import com.example.vidajoni.repository.userRepository;
import org.apache.tomcat.jni.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.text.Document;
import java.util.List;
import java.util.Optional;

@Controller
public class AdController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

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

    @GetMapping("/newAd")
    public String newAd() {
        return "newAd";
    }


    @GetMapping("/user")
    public String listUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user";
    }


    @PostMapping("/newAd/submit")
    public String createAd(Model model, RedirectAttributes redirectAttributes, @RequestParam String title,
                           @RequestParam String description, @RequestParam String size, @RequestParam String picture
            , @RequestParam String price) {
        System.out.println("vi är här!");
        ad ad1 = new ad(title, description, size, picture, price);
        adRepository.save(ad1);
        logger.info("Ny annons skapad!");
        redirectAttributes
                .addAttribute(ad1);
//                .addFlashAttribute("success", true);

        List<ad> latestAds = adRepository.findAll();

        int max = 0;
        for (ad currentAd : latestAds) {
            if (currentAd.getId() > max)
                max = currentAd.getId();
        }
        System.out.println(max);
        Optional<ad> latestAd = adRepository.findById(max);

        if (latestAd.isPresent()) {
            model.addAttribute("latestAd", latestAd.get());
            System.out.println(latestAd.get());
            return "annonsvy";
        } else {
            return "newAd";
        }
        
    }

//
    @GetMapping("/newAd/test")
    public String printAd(Model model) {
        List<ad> latestAds = adRepository.findAll();

        int max = 0;
        for (ad currentAd : latestAds) {
            if (currentAd.getId() > max)
                max = currentAd.getId();
        }
        System.out.println(max);
        Optional<ad> latestAd = adRepository.findById(max);

        if (latestAd.isPresent()) {
            model.addAttribute("latestAd", latestAd.get());
            System.out.println(latestAd.get());
            return "annonsvy";
        } else {
            return "newAd";
        }
    }

    //    @GetMapping("/findAllCharacters")
    //    public String allCharacters(Model model) {
    //        List<Character> allCharacters = repository.findAllCharacters();
    //        model.addAttribute("characters", allCharacters);
    //        return "showAllCharacters";
    //    }
}
