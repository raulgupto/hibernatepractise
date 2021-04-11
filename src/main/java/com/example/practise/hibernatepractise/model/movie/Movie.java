package com.example.practise.hibernatepractise.model.movie;


import com.example.practise.hibernatepractise.model.movie.actor.Actor;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
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
@Table(name = "MOVIE")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;

    @ManyToMany(mappedBy = "movies", cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH}, fetch = FetchType.LAZY)
    Collection<Actor> actors =  new HashSet<>();

    @ElementCollection
    @JoinTable(name = "movie_rating", joinColumns = @JoinColumn(name = "id"))
    Collection<Rating> ratings = new HashSet<>();

    public long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<Actor> getActors() {
        return actors;
    }

    public void setActors(Collection<Actor> actors) {
        this.actors = actors;
    }

    public Collection<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Collection<Rating> ratings) {
        this.ratings = ratings;
    }
}
