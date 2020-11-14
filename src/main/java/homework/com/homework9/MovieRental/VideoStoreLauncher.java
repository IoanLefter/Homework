package main.java.homework.com.homework9.MovieRental;

public class VideoStoreLauncher {
    public static void main(String[] args) {
        VideoStore storeA = new VideoStore();
        storeA.addVideo("The Matrix");
        storeA.addVideo("Godfather II");
        storeA.addVideo("Star Wars Episode IV: A New Hope");

        storeA.checkOut("The Matrix");
        storeA.returnVideo("The Matrix");
        storeA.returnVideo("The Matrix");
        storeA.checkOut("The Matrix");
        storeA.checkOut("The Matrix");
        storeA.returnVideo("Star Wars Episode IV: A New Hope");
        storeA.checkOut("Godfather II");
        System.out.println();
        storeA.receiveRating("The Matrix", 9.1);
        storeA.receiveRating("Godfather II", 9.5);
        storeA.receiveRating("Star Wars Episode IV: A New Hope", 8.6);
        storeA.receiveRating("The Matrix", 9.2);
        storeA.receiveRating("Godfather II", 8.8);
        storeA.receiveRating("Star Wars Episode IV: A New Hope", 9);
        storeA.receiveRating("Godfather II", 9);
        System.out.println();
        storeA.listInventory();
    }
}
