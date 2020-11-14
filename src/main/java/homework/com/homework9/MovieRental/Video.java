package main.java.homework.com.homework9.MovieRental;

public class Video {
    private String title;
    private Boolean checkedOut;
    private double averageUserRating;
    private int numberOfRatingsFromUsers;

    public Video(String title) {
        this.title = title;
        checkedOut = false;
    }


    public void checkedOut() {
        this.checkedOut = true;
    }

    public void returned() {
        this.checkedOut = false;
    }

    public void setAverageUserRating(double averageUserRating) {
        if (numberOfRatingsFromUsers == 0) {
            this.averageUserRating = averageUserRating;
            numberOfRatingsFromUsers = 1;
        } else {
            this.averageUserRating = (averageUserRating + this.averageUserRating * numberOfRatingsFromUsers) / (numberOfRatingsFromUsers + 1);
            numberOfRatingsFromUsers++;
        }
    }


    public String getTitle() {
        return title;
    }

    public Boolean getCheckedOut() {
        return checkedOut;
    }

    public double getAverageUserRating() {
        return averageUserRating;
    }
}
