//Create a LibraryMember class inside the model package.
//This class should represent a library member and have properties like name, member ID, and borrowed books.
package library.model;

import java.util.ArrayList;

public class LibraryMember {
    private int memberID;
    private final String memberName;
    public ArrayList<Book> reserved = new ArrayList<>();
    public ArrayList<Book> borrowed = new ArrayList<>();
    public LibraryMember(int memberID, String memberName) {
        this.memberID = memberID;
        this.memberName = memberName;
    }
    public String getMemberName(){
        return this.memberName;
    }
    public int getMemberID(){
        return this.memberID;
    }
    public void setMemberID(int memberID){
        this.memberID = memberID;
    }

    public String getBorrowed(){
        StringBuilder books = new StringBuilder();
        for(Book book : this.borrowed){
            books.append("\n").append("  *  ").append(book.getTitle());
        }
        return books.toString();
    }
    public String getReserved(){
        StringBuilder reserved = new StringBuilder();
        for(Book book: this.reserved){
            reserved.append("\n").append("  -  ").append(book.getTitle());
        }
        return reserved.toString();
    }
}