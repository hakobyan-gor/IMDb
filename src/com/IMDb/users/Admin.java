package com.IMDb.users;

import com.IMDb.movies.Movie;
import com.IMDb.repository.Repository;

import java.io.*;

public class Admin {

    private static final String KEY_VALUE_DIVIDER = " @#001|100#@ ";
    private static final String LINE_DIVIDER = "\n";
    private Repository<Integer, Movie> repository = new Repository<>();
    private String adminDataFilePath = "src\\com\\IMDb\\usersData\\adminData.txt";

    public boolean signIn(String username, String password) {

        if (checkUsernameAndPasswordForSignIn(username, password)) {
            System.out.printf("You are just sign in!\nWelcome %s", username);
            return true;
        } else {
            System.out.println("Your username or password is incorrect!\nPlease, try again!");
            return false;
        }

    }

    private boolean checkUsernameAndPasswordForSignIn(String username, String password) {

        try {
            FileReader fileReader = new FileReader(adminDataFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.split(KEY_VALUE_DIVIDER)[0].equals(username) && line.split(KEY_VALUE_DIVIDER)[1].equals(password)) {
                    bufferedReader.close();
                    fileReader.close();
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void addMovie(Movie movie) {

        repository.putMovie(movie.getID(), movie);

    }

}
