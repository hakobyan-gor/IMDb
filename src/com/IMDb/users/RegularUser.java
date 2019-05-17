package com.IMDb.users;

import com.IMDb.movies.Movie;
import com.IMDb.repository.Repository;

import java.io.*;

public class RegularUser {

    private static final String KEY_VALUE_DIVIDER = " @#001|100#@ ";
    private static final String LINE_DIVIDER = "\n";
    private String regularUserDataFilePath = "src\\com\\IMDb\\usersData\\regularUserData.txt";
    private String adminDataFilePath = "src\\com\\IMDb\\usersData\\adminData.txt";

    boolean signIn(String username, String password){

        if (checkUsernameAndPasswordForSignIn(username,password)){
            System.out.printf("You are just sign in!\nWelcome %s",username);
            return true;
        } else {
            System.out.println("Your username or password is incorrect!\nPlease, try again!");
            return false;
        }

    }

    boolean signUp(String username, String password){

        if (!checkUserNameForSignUp(username)){
            try {
                FileWriter fileWriter = new FileWriter(regularUserDataFilePath, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(username + KEY_VALUE_DIVIDER + password + LINE_DIVIDER);
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            System.out.println("Username already exists!\nPlease, try again!");
            return false;
        }

    }

    private boolean checkUsernameAndPasswordForSignIn(String username, String password){

        try {
            FileReader fileReader = new FileReader(regularUserDataFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                if (line.split(KEY_VALUE_DIVIDER)[0].equals(username) && line.split(KEY_VALUE_DIVIDER)[1].equals(password)){
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

    private boolean checkUserNameForSignUp(String username){

        try {
            FileReader fileReader = new FileReader(regularUserDataFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                if (line.split(KEY_VALUE_DIVIDER)[0].equals(username)){
                    bufferedReader.close();
                    fileReader.close();
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileReader fileReader = new FileReader(adminDataFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                if (line.split(KEY_VALUE_DIVIDER)[0].equals(username)){
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

    void rateMovie(String title, int rating){



    }

    public Movie searchMovie(String title){

        Movie movie;
        Repository<Integer,Movie> repository = new Repository();
        for (int i = 0; i <= repository.getLinesCount(); i++) {
            movie = repository.getMovie(Integer.parseInt(String.valueOf(i)));
            if (movie.toString().contains(title)){
                System.out.println(movie.toString());
                return movie;
            }
        }

        System.out.println("Movie not found!");
        return null;
    }

}
