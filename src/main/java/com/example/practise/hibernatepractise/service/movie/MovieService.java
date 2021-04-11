package com.example.practise.hibernatepractise.service.movie;


import com.example.practise.hibernatepractise.model.movie.Movie;
import com.example.practise.hibernatepractise.repository.movie.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {


    final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public List<Movie> getAllMovies(){
        List<Movie> all = movieRepository.findAll();
        return all;
    }

    public Movie addNewMovie(Movie movie) {
//        movie.getActors().forEach(actor -> actor.getMovies().add(movie));
        return movieRepository.save(movie);
    }

    public Movie getMovie(int id) {
        return movieRepository.findById((long) id).orElse(null);
    }
}
