import java.util.ArrayList;

public class Book {
    String title;
    String author;
    String date;

    double rating;
    ArrayList<String> reviews;

    boolean available;

    //setRating(double rating):
        // This method sets the rating of the book.
    void setRating(double rating){
        this.rating = rating;
    }

    //addReview(String review):
        // This method adds a review to the book.
    void addReview(String review){
        this.reviews.add(review);
    }
}