package com.example.practise.hibernatepractise.model.movie;

import javax.persistence.Embeddable;

@Embeddable
public class Rating {
    String type;
    double rating;

    public Rating() {
    }

    public Rating(String type, double rating) {
        this.type = type;
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
