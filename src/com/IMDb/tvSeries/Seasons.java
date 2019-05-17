package com.IMDb.tvSeries;

import java.util.ArrayList;

public class Seasons {

    private static int counter = 0;
    private final int ID = ++counter;
    private ArrayList<Episodes> episodes;

    public Seasons(ArrayList<Episodes> episodes) {
        this.episodes = episodes;
    }

    @Override
    public String toString() {
        return "Season : " + ID + "\n" + episodes;
    }
}
