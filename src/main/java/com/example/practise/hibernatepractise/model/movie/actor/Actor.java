package com.example.practise.hibernatepractise.model.movie.actor;


import com.example.practise.hibernatepractise.model.movie.Movie;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Table(name = "ACTOR")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String name;
    boolean isMale;

    public Actor(String name, boolean isMale) {
        this.name = name;
        this.isMale = isMale;
    }

    public Actor() {
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH})
    @JoinTable(
    joinColumns = {@JoinColumn (name = "actor_id")},
    inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    Collection<Movie> movies = new HashSet<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Collection<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Collection<Movie> movies) {
        this.movies = movies;
    }
}
