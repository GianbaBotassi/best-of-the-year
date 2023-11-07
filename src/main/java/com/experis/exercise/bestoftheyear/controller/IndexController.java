package com.experis.exercise.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

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

    //Rotta pagina movies
    @GetMapping("movies")
    public String movies(Model model) {
        model.addAttribute("movies", getBestMovies());
        return "movies";
    }

    //Rotta pagina songs
    @GetMapping("songs")
    public String songs(Model model) {
        model.addAttribute("songs", getBestSongs());
        return "songs";
    }

    //Metodi che danno come output movies e songs
    private ArrayList<String> getBestMovies() {
        ArrayList<String> array = new ArrayList<>();
        array.add("Ritorno al futuro");
        array.add("Ritorno al presente");
        array.add("Ritorno al passato");
        array.add("Ritorno all'imperfetto");
        array.add("Ritorno al passato remoto");
        array.add("Ritorno al gerundio");
        array.add("Ritorno all'infinito");
        return array;
    }

    private ArrayList<String> getBestSongs() {
        ArrayList<String> array = new ArrayList<>();
        array.add("Bohemian Rhapsody");
        array.add("Imagine");
        array.add("Hey Jude");
        array.add("Hotel California");
        array.add("Purple Haze");
        array.add("Like a Rolling Stone");
        array.add("Billie Jean");
        return array;
    }
}
