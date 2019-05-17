package com.IMDb.tvSeries;

import java.io.Serializable;
import java.util.ArrayList;

public class TVSeries implements Serializable {

    private static int counter = 0;
    private final int ID = ++counter;
    private String title;
    private String description;
    private String genre;
    private ArrayList<Seasons> seasons;

    public TVSeries(
            String title, String description,
            String genre, ArrayList<Seasons> seasons
    ) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.seasons = seasons;
    }

    @Override
    public String toString() {
        return "Title='" + title +
                "Description='" + description +
                "Genre='" + genre +
                "Seasons=" + seasons;
    }
}
