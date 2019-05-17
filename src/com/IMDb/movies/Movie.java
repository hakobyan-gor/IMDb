package com.IMDb.movies;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Movie implements Serializable {

    private static int counter = 0;
    private final int ID = ++counter;
    private String title;
    private String description;
    private String genre;
    private int rating;
    private LocalDate premierDate;
    private Map<String, String> actors;
    private List<String> directors;
    private List<String> screenwriters;

    public Movie(
            String title, String description, String genre,
            LocalDate premierDate, Map<String, String> actors,
            List<String> directors, List<String> screenwriters
    ) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.rating = 10;
        this.premierDate = premierDate;
        this.actors = actors;
        this.directors = directors;
        this.screenwriters = screenwriters;
    }

    @Override
    public String toString() {
        return  "Title : " + title +
                "\nDescription : " + description +
                "\nGenre : " + genre +
                "\nRating : " + rating + "/10" +
                "\nPremierDate : " + premierDate +
                "\nActors : " + actors +
                "\nDirectors : " + directors +
                "\nScreenwriters : " + screenwriters;
    }

    public int getID() {
        return ID;
    }

}
