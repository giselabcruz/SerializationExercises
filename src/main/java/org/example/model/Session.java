package org.example.model;

import java.io.Serializable;

public class Session implements Serializable {

    private Movie movie;
    private Theater theater;
    private double startTime;

    public Session(Movie movie, Theater theater, double startTime) {
        this.movie = movie;
        this.theater = theater;
        this.startTime = startTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }
}
