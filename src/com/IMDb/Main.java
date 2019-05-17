package com.IMDb;

import com.IMDb.movies.Movie;
import com.IMDb.repository.Repository;
import com.IMDb.users.Admin;
import com.IMDb.users.RegularUser;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String,String> actors = new HashMap<>();
        actors.put("a","a");
        actors.put("b","b");
        actors.put("c","c");
        ArrayList<String> directors = new ArrayList<>();
        directors.add("as");
        directors.add("as");
        directors.add("as");
        ArrayList<String> screenwriters = new ArrayList<>();
        screenwriters.add("ad");
        screenwriters.add("ad");
        screenwriters.add("ad");
        Movie movie = new Movie("A","a","a", LocalDate.of(1200, Month.DECEMBER,1),actors,directors,screenwriters);
        Repository<Integer,Movie> repository = new Repository<>();
        Admin admin = new Admin();
        admin.addMovie(movie);
        Movie movie1 = new Movie("A","a","a", LocalDate.of(1200, Month.DECEMBER,1),actors,directors,screenwriters);
        Movie movie2 = new Movie("A","a","a", LocalDate.of(1200, Month.DECEMBER,1),actors,directors,screenwriters);
        Movie movie3 = new Movie("A","a","a", LocalDate.of(1200, Month.DECEMBER,1),actors,directors,screenwriters);
        admin.addMovie(movie1);
        admin.addMovie(movie2);
        admin.addMovie(movie3);

        RegularUser regularUser = new RegularUser();
        Movie movie4 = regularUser.searchMovie("A");
        System.out.println(movie4);

    }

}
