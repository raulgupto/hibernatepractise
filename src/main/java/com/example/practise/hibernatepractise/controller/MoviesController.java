package com.example.practise.hibernatepractise.controller;

import com.example.practise.hibernatepractise.model.movie.Movie;
import com.example.practise.hibernatepractise.model.movie.actor.Actor;
import com.example.practise.hibernatepractise.repository.movie.ActorRepository;
import com.example.practise.hibernatepractise.service.movie.ActorService;
import com.example.practise.hibernatepractise.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by rahulg1 on 4/12/2021.
 */

@RestController
@RequestMapping("/movies")
public class MoviesController {

    final MovieService movieService;
    final ActorService actorService;

    public MoviesController(MovieService movieService, ActorService actorService) {
        this.movieService = movieService;
        this.actorService = actorService;

    }



    @GetMapping("/getAllMovies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.addNewMovie(movie);
    }
    @PostMapping("/addActor")
    public Actor addActor(@RequestBody Actor actor){
        return actorService.addActor(actor);
    }

    @Cacheable(value = "movie-cache", key="#id",  condition = "#id < 1000")
    @GetMapping("/getMovie/{id}")
    public Movie getMovie(@PathVariable(value = "id")int id){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return movieService.getMovie(id);
    }

}
