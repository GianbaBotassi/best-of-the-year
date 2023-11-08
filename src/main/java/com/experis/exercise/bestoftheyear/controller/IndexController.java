package com.experis.exercise.bestoftheyear.controller;

import com.experis.exercise.bestoftheyear.model.Movie;
import com.experis.exercise.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

;

//Annotazione Controller e request mapping su localhost
@Controller
@RequestMapping("/")
public class IndexController {

    //Rotta per pagina home
    @GetMapping("home")
    public String home() {
        return "home";
    }

    //Rotta pagina movies
    @GetMapping("movies")
    public String movies(Model model) {
        model.addAttribute("movies", getMovies());
        return "movies";
    }

    //Rotta pagina songs
    @GetMapping("songs")
    public String songs(Model model) {
        model.addAttribute("songs", getSongs());
        return "songs";
    }

    @GetMapping("movies/{id}")
    public String movieDetail(@PathVariable int id, Model model) {
        model.addAttribute("movie", getMovie(id));
        return "movieDetail";
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

    private List<Movie> getMovies() {
        Movie[] array = {new Movie(1, "Ritorno al futuro"), new Movie(2, "Ritorno al passato"), new Movie(3, "Ritorno al presente"), new Movie(4, "Ritorno al gerundio"), new Movie(5, "Ritorno all'imperfetto")};
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

    private Movie getMovie(int filter) {
        for (Movie movie : getMovies()) {
            if (movie.getId() == filter) {
                return movie;
            }
        }
        return null;
    }
}
