package main.java.com.homework.homework9.MovieRental;

import java.util.ArrayList;
import java.util.List;

public class VideoStore {
    private List<Video> storeMovies = new ArrayList<>();


    public void addVideo(String movieTitle) {
        storeMovies.add(new Video(movieTitle));
    }


    public void checkOut(String movieTitle) {
        int found = 0;
        for (int i = 0; i <= storeMovies.size() - 1; i++) {

            if (storeMovies.get(i).getTitle().equals(movieTitle) && (!storeMovies.get(i).getCheckedOut())) {
                storeMovies.get(i).checkedOut();
                System.out.println("You successfully rented " + movieTitle);
                found = 1;
                return;
            }
        }
        if (found == 0) {
            System.out.println(movieTitle + " is not available for rent.");
        }
    }

    public void returnVideo(String movieTitle) {
        int found = 0;
        for (int i = 0; i <= storeMovies.size() - 1; i++) {

            if (storeMovies.get(i).getTitle().equals(movieTitle) && (storeMovies.get(i).getCheckedOut())) {
                storeMovies.get(i).returned();
                System.out.println("You successfully returned " + movieTitle);
                found = 1;
                return;
            }
        }
        if (found == 0) {
            System.out.println(movieTitle + " is not rented from our store or has been already returned.");
        }
    }

    public void receiveRating(String movieTitle, double rating) {
        int found = 0;
        for (int i = 0; i <= storeMovies.size() - 1; i++) {

            if (storeMovies.get(i).getTitle().equals(movieTitle)) {
                storeMovies.get(i).setAverageUserRating(rating);
                System.out.println("You successfully rated " + movieTitle + " with grade " + rating);
                found = 1;
                return;
            }
        }
        if (found == 0) {
            System.out.println(movieTitle + " is not in our database. Please retype the name.");
        }
    }

    public void listInventory() {
        System.out.println("You can rent the following movies from our store:");
        for (int i = 0; i <= storeMovies.size() - 1; i++) {
            System.out.println(storeMovies.get(i).getTitle() + ": Is already rented?= " + storeMovies.get(i).getCheckedOut() + "; average rating is " + storeMovies.get(i).getAverageUserRating());
        }
    }


}


