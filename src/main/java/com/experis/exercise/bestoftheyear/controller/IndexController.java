package com.experis.exercise.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

;

//Annotazione Controller e request mapping su localhost
@Controller
@RequestMapping("/")
public class IndexController {

    //Rotta per pagina home
    @GetMapping("home")
    public String home(Model model) {
        model.addAttribute("nome", "Gianbattista");
        return "home";
    }
}
