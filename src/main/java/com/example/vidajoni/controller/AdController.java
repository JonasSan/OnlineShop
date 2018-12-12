package com.example.vidajoni.controller;

import com.example.vidajoni.domain.ad;
import com.example.vidajoni.domain.test;
import com.example.vidajoni.repository.AdRepository;
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
    private com.example.vidajoni.repository.testRepository testRepository;


    @GetMapping("/lili")
    public String listAds(Model model) {

        List<ad> ads = adRepository.findAll();
        model.addAttribute("ads", ads);
        return "adlist";

    }

    @GetMapping("/test")
    public String listTest (Model model){
        List<test> tests = testRepository.findAll();
        model.addAttribute("tests", tests);
        return "testlist";
    }
}
