//Create a Book class inside the model package.
//This class should have properties like title, author, and ISBN.
package library.model;

public class Book {
    private boolean reserved=false;
    private final String title;
    private final String author;
    private final String ISBN;
    //added ID to give possibility to have multiple copies of the same book
    private final int ID;
    public Book(String title, String author, String ISBN, int ID){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.ID = ID;
    }
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public String getISBN() {
        return this.ISBN;
    }
    public int getID(){
        return this.ID;
    }

    public boolean reserved(){
        return this.reserved;
    }
    public void reserveBook(){
        this.reserved=true;
    }
    public void unreserve(){
        this.reserved=false;
    }
}