package org.example.model;

import java.io.Serializable;

public class Movie implements Serializable {


    private String title;
    private double time;


    public Movie(String title, double time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

}
