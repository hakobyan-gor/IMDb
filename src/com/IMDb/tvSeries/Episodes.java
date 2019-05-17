package com.IMDb.tvSeries;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Episodes {

    private static int counter = 0;
    private final int ID = ++counter;

    private String title;
    private int rating;
    private LocalDate premierDate;
    private Map<String, String> actors;
    private List<String> directors;
    private List<String> screenwriters;

    public Episodes(
            String title, int rating, LocalDate premierDate,
            Map<String, String> actors, List<String> directors,
            List<String> screenwriters)
    {
        this.title = title;
        this.rating = rating;
        this.premierDate = premierDate;
        this.actors = actors;
        this.directors = directors;
        this.screenwriters = screenwriters;
    }

    @Override
    public String toString() {
        return  "ID : " + ID +
                "\nTitle : " + title +
                "\nRating : " + rating +
                "\nPremierDate : " + premierDate +
                "\nActors : " + actors +
                "\nDirectors : " + directors +
                "\nScreenwriters : " + screenwriters;
    }
}
