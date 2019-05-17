package com.IMDb.repository;

import com.IMDb.movies.Movie;

import java.io.*;

public class Repository<Key, Value extends Serializable> {

    private static final String KEY_VALUE_DIVIDER = " @#001|100#@ ";
    private static final String LINE_DIVIDER = "\n";
    private String movieDataFilePath = "src\\com\\IMDb\\moviesAndTVSeriesData\\MovieData.txt";
    private String tvSeriesDataFilePath = "src\\com\\IMDb\\moviesAndTVSeriesData\\TVSeriesData.txt";

    public void putMovie(Key id, Value movie){

        try {
            FileWriter fileWriter = new FileWriter(movieDataFilePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            FileReader fileReader = new FileReader(movieDataFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            boolean bool = false;
            while ((line = bufferedReader.readLine()) != null){
                if (line.split(KEY_VALUE_DIVIDER)[0].equals(id.toString())){
                    bool = true;
                }
            }
            if (!bool){
                bufferedWriter.write(id.toString() + KEY_VALUE_DIVIDER + Serializer.serialize(movie) + LINE_DIVIDER);
                bufferedWriter.flush();
                bufferedWriter.close();
                fileWriter.close();
                bufferedReader.close();
                fileReader.close();
                System.out.println("Movie just added!");
            } else {
                bufferedWriter.close();
                fileWriter.close();
                bufferedReader.close();
                fileReader.close();
                System.out.println("Movie already exists!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Value getMovie(Key id){

        Value movie = null;
        try {
            FileReader fileReader = new FileReader(movieDataFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                if (line.split(KEY_VALUE_DIVIDER)[0].equals(id.toString())){
                    movie = (Value) Serializer.deserialize(line.split(KEY_VALUE_DIVIDER)[1]);
                    bufferedReader.close();
                    fileReader.close();
                    return movie;
                }
            }
        }catch (IOException e){
            e.getStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    void putTVSeries(Key id, Value tvSeries){

        try {
            FileWriter fileWriter = new FileWriter(tvSeriesDataFilePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(id.toString() + KEY_VALUE_DIVIDER + Serializer.serialize(tvSeries) + LINE_DIVIDER);
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    Value getTVSeries(Key id){

        Value tvSeries = null;
        try {
            FileReader fileReader = new FileReader(tvSeriesDataFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                if (line.split(KEY_VALUE_DIVIDER)[0].equals(id.toString())){
                    tvSeries = (Value) Serializer.deserialize(line.split(KEY_VALUE_DIVIDER)[1]);
                    bufferedReader.close();
                    fileReader.close();
                    break;
                }
            }
        }catch (IOException e){
            e.getStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return tvSeries;
    }

//    public int getID(String title){
//
//        Value movie;
//        int movieID;
//
//        try {
//            FileReader fileReader = new FileReader(movieDataFilePath);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line;
//            while ((line = bufferedReader.readLine()) != null){
//                if (movie = Serializer.deserialize(line.split(KEY_VALUE_DIVIDER)[1]).title.e)
//            }
//        }
//
//        return movieID;
//    }

    public int getLinesCount(){

        int lineCount = 0;
        try {
            FileReader fileReader = new FileReader(movieDataFilePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            lineCount = (int) bufferedReader.lines().count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lineCount;
    }

}
