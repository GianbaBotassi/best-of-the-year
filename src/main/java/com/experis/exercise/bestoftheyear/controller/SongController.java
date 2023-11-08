package com.experis.exercise.bestoftheyear.controller;

import com.experis.exercise.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class SongController {
    @GetMapping("songs")
    public String songs(Model model) {
        model.addAttribute("songs", getSongs());
        return "songs";
    }


    @GetMapping("songs/{id}")
    public String songDetail(@PathVariable int id, Model model) {
        model.addAttribute("song", getSong(id));
        return "songDetail";
    }

    //Metodi che danno come output movies e songs
    private List<Song> getSongs() {
        Song[] array = {new Song(1, "Bohemian Rhapsody"), new Song(2, "Imagine"), new Song(3, "Hotel California"), new Song(4, "Purple Haze"), new Song(5, "Billie Jean")};
        return Arrays.asList(array);
    }


    private Song getSong(int filter) {
        for (Song song : getSongs()) {
            if (song.getId() == filter) {
                return song;
            }
        }
        return null;
    }
}
