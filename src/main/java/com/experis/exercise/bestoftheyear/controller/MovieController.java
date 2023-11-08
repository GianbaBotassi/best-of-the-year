package com.experis.exercise.bestoftheyear.controller;

import com.experis.exercise.bestoftheyear.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class MovieController {
    @GetMapping("movies")
    public String movies(Model model) {
        model.addAttribute("movies", getMovies());
        return "movies";
    }

    @GetMapping("movies/{id}")
    public String movieDetail(@PathVariable int id, Model model) {
        model.addAttribute("movie", getMovie(id));
        return "movieDetail";
    }

    private List<Movie> getMovies() {
        Movie[] array = {new Movie(1, "Ritorno al futuro"), new Movie(2, "Ritorno al passato"), new Movie(3, "Ritorno al presente"), new Movie(4, "Ritorno al gerundio"), new Movie(5, "Ritorno all'imperfetto")};
        return Arrays.asList(array);
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
