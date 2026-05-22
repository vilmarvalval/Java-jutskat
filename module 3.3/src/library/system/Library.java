//Step 2: Define Classes
//Create a Library class inside the system package.
//This class should manage the library's allBooks and members.
//Implement methods to add allBooks, add members, borrow allBooks, and return allBooks.
package library.system;
import library.model.Book;
import library.model.LibraryMember;

import java.util.ArrayList;
import java.util.Objects;

public class Library {
    private static int ID=0;
    private final int libID;
    private static int memberCount;
    private static final ArrayList<Book> globalBooks = new ArrayList<>();
    private final ArrayList<Book> allBooks = new ArrayList<>();
    ///allBooks has kind of been replaced by globalBooks, prolly can be removed?
    private final ArrayList<Book> localBooks = new ArrayList<>();
    private static final ArrayList<LibraryMember> members = new ArrayList<>();
    public Library(int libID) {
        this.libID = libID;
    }
    public String addBook(String name, String author, String ISBN) {
        if (name.isEmpty() || author.isEmpty() || ISBN.isEmpty()) {
            return "Lib ID-"+this.libID+": Error adding book: Name, Author or ISBN is empty";
        }
        Book book = new Book(name, author, ISBN, ID);
        ID++;
        globalBooks.add(book);
        allBooks.add(book);
        localBooks.add(book);
        return "Lib ID-"+this.libID+": '"+name+"' -Book added successfully.";
    }
    public String getBookISBN(String title, String author) {
        //left over after moving from ISBN identification to unique ID identification
        // to allow multiple copies of same book. Could still be useful.
        if (title==null && author==null || Objects.equals(title, "") && Objects.equals(author, "")) {
            return "-1";
        }else if (author==null){
            for (Book book : allBooks) {
                if(book.getTitle().equals(title)){
                    return book.getISBN();
                }
            }
            return "-1";
        } else if (title==null){
            for (Book book : allBooks) {
                if(book.getAuthor().equals(author)){
                    return book.getISBN();
                }
            }
            return "-1";
        } else {
            for (Book book : allBooks) {
                if(book.getTitle().equals(title) && book.getAuthor().equals(author)){
                    return book.getISBN();
                }
            }
            return "-1";
        }
    }
    public int getBookID(String title, String author) {
        //takes either author, title or both to search for book ID.
        // If both fields are null or book is not found, returns -1 as the book ID,
        // indicating that the search has failed.
        if (title==null && author==null || Objects.equals(title, "") && Objects.equals(author, "")) {
            return -1;
        }else if (title==null){
            //First attempts to search local books and if that fails,
            // searches all books.(In case member returns the book to a different library.)
            for (Book book : localBooks) {
                if(book.getAuthor().equals(author)){
                    return book.getID();
                }
            }
            for (Book book : allBooks) {
                if(book.getAuthor().equals(author)){
                    return book.getID();
                }
            }
            return -1;
        } else if (author==null) {
            for (Book book : localBooks) {
                if(book.getTitle().equals(title)){
                    return book.getID();
                }
            }
            for (Book book : allBooks) {
                if(book.getTitle().equals(title)){
                    return book.getID();
                }
            }
            return -1;
        } else {
            for (Book book : localBooks) {
                if(book.getTitle().equals(title) && book.getAuthor().equals(author)){
                    return book.getID();
                }
            }
            for (Book book : allBooks) {
                if(book.getTitle().equals(title) && book.getAuthor().equals(author)){
                    return book.getID();
                }
            }
            return -1;
        }
    }
    public int getUserBookID(String title, String author, int userID) {
        //more specialized version of the getBookID required for correctly returning a book.
        // Searches for user's 'borrowed' instead of library's/all books.
        if (title==null && author==null || Objects.equals(title, "") && Objects.equals(author, "")) {
            return -1;
        }else if (title==null){
            for (Book book : members.get(userID).borrowed) {
                if(book.getAuthor().equals(author)){
                    return book.getID();
                }
            }
            return -1;
        } else if (author==null) {
            for (Book book : members.get(userID).borrowed) {
                if(book.getTitle().equals(title)){
                    return book.getID();
                }
            }
            return -1;
        } else {
            for (Book book : members.get(userID).borrowed) {
                if(book.getTitle().equals(title) && book.getAuthor().equals(author)){
                    return book.getID();
                }
            }
            return -1;
        }
    }

    //Unlike in previous modules(or even removeMember()), 'remove' command here doesn't re-distribute ID's for books.
    //It doesn't seem like implementing such would be easy, so I decided not to do so.
    public String removeBook(int bookID){
        if (bookID==-1) {
            return "Lib ID-"+this.libID+": Unable to remove, book ID not found.";
        } else {
            for (Book book : allBooks) {
                if(book.getID()==bookID){
                    allBooks.remove(book);
                    localBooks.remove(book);
                    return "Lib ID-"+this.libID+": Book removed successfully. (Queried ID:" + bookID +")";
                }
            }
            return "Lib ID-"+this.libID+": Unable to remove, book not found. (Queried ID:" + bookID +")";
        }
    }
    public void printAllBooks(){
        System.out.println("\nLib ID-"+this.libID+": List of all Books:");
        for (Book book : allBooks) {
            System.out.println("-------------------------------");
            System.out.println("ID: "+book.getID());
            System.out.println("Title: "+book.getTitle());
            System.out.println("Author: "+book.getAuthor());
            System.out.println("ISBN: "+book.getISBN());
            System.out.println("Reserved: "+book.reserved());
        }
        System.out.println("-------------------------------");
    }
    public void printLocalBooks(){
        System.out.println("\nLib ID-"+this.libID+": List of books in inventory:");
        for (Book book : localBooks) {
            System.out.println("-------------------------------");
            System.out.println("ID: "+book.getID());
            System.out.println("Title: "+book.getTitle());
            System.out.println("Author: "+book.getAuthor());
            System.out.println("ISBN: "+book.getISBN());
            System.out.println("Reserved: "+book.reserved());
        }
        System.out.println("-------------------------------");
    }


    public String addMember(String name) {
        for(LibraryMember member : members){
            if (member.getMemberName().equals(name)) {
                return "Lib ID-"+this.libID+": Member '"+name+"' already exists.";
            }
        }
        members.add(new LibraryMember(memberCount,name));
        memberCount++;
        return  "Lib ID-"+this.libID+": '"+name+"' added to members successfully.";

    }
    public int getMemberID(String name) {
        for(LibraryMember member: members){
            if (Objects.equals(member.getMemberName(), name)){
                return member.getMemberID();
            }
        }
        return -1;
    }
    public String removeMember(int id) {
        if(id<0 || id>memberCount){
            return "Lib ID-"+this.libID+": Unable to remove user, invalid ID. (Queried ID: "+id+")";
        } else {
            members.remove(id);
            memberCount=0;
            for(LibraryMember member: members){
                member.setMemberID(memberCount);
                memberCount++;
            }
            return "Lib ID-"+this.libID+": Member removed successfully. (Queried ID: "+id+")";
        }
    }
    public void printMembers(){
        System.out.println("\nLib ID-"+this.libID+": List of members:");
        for(LibraryMember member: members){
            System.out.println("-------------------------");
            System.out.println("Member ID: "+member.getMemberID());
            System.out.println("Member Name: "+member.getMemberName());
            System.out.println("Borrowed books: "+member.getBorrowed());
            System.out.println("Reserved books: "+member.getReserved());
        }
        System.out.println("-------------------------");
    }

    public String borrowBook(int bookID, int memberID) {
        //checks if member id or book ISBN is -1
        // which would indicate the getID/ISBN search has failed before attempting to borrow the book
        if (bookID==-1) {
            return "Lib ID-"+this.libID+": Unable to borrow, book ID not found.";
        } else if (memberID==-1) {
            return "Lib ID-"+this.libID+": Unable to borrow, member ID not found.";
        } else {
            //search for member id
            for (LibraryMember member: members) {
                if (member.getMemberID()==memberID) {
                    //if member id matches, search for book ISBN
                    for(Book book : localBooks){
                        if(book.getID()== bookID){
                            if (book.reserved()) {
                                if (userReservedBook(bookID, memberID)){
                                    member.borrowed.add(book);
                                    member.reserved.removeIf(b -> b.getID()==bookID);
                                    //book borrowed from separate list to avoid breaking ID/ISBN search etc.
                                    // +to remember which books have been in the library in the first place
                                    localBooks.remove(book);
                                    return "Lib ID-" + this.libID + ": '" + member.getMemberName() +
                                            "' borrowed a reserved book successfully. (Queried ID:" + bookID + ")";
                                }
                                return "Lib ID-"+this.libID+": User '"+member.getMemberName()+
                                        "' unable to borrow, book has been reserved. (Queried ID:" + bookID +")";
                            } else {
                                member.borrowed.add(book);
                                //book borrowed from separate list to avoid breaking ID/ISBN search etc.
                                // +to remember which books have been in the library in the first place
                                localBooks.remove(book);
                                return "Lib ID-" + this.libID + ": '" + member.getMemberName() +
                                        "' borrowed a book successfully. (Queried ID:" + bookID + ")";
                            }
                        }
                    }
                    return "Lib ID-"+this.libID+
                            ": Unable to borrow, book not found in library. (Queried ID:" + bookID +")";
                }
            }
            return "Lib ID-"+this.libID+": Unable to borrow, member not found. (Queried ID: "+memberID+")";
        }
    }

    public String returnBook(int bookID, int memberID) {
        //same as above, confirms neither ID nor ISBN is -1, aka a failed search.
        if (bookID == -1) {
            return "Lib ID-"+this.libID+": Unable to return, book ID not found.";
        } else if (memberID == -1) {
            return "Lib ID-"+this.libID+": Unable to return member ID not found.";
        } else {
            //locate member
            for (LibraryMember member: members) {
                if (member.getMemberID()==memberID) {
                    //locate book
                    for(Book book : localBooks){
                        if(book.getID()==bookID){
                            //check if member has such book.
                            for(Book book1 : member.borrowed){
                                if(book1.getID()==bookID){
                                    member.borrowed.remove(book);
                                    localBooks.add(book);
                                    return "Lib ID-"+this.libID+": '"+member.getMemberName()+
                                            "' returned book titled: '"+book.getTitle()+"' returned successfully.";
                                }
                            }
                            return "Lib ID-"+this.libID+": Unable to return, member '"+member.getMemberName()+
                                    "' has no such book. (Queried ID:" + bookID +")";
                        }
                    }
                    for(Book book : globalBooks){
                        if(book.getID()==bookID){
                            //check if member has such book. + if it's new
                            for(Book book1 : member.borrowed){
                                if(book1.getID()==bookID){
                                    member.borrowed.remove(book1);
                                    localBooks.add(book);
                                    allBooks.add(book);
                                    return "Lib ID-"+this.libID+": '"+member.getMemberName()+
                                            "' returned book titled: '"+book.getTitle()+ "' successfully. "+
                                            "New in this Library.";
                                }
                            }
                            return "Lib ID-"+this.libID+": Unable to return, member '"+member.getMemberName()+
                                    "' has no such book. (Queried ID:" + bookID +")";
                        }
                    }
                    return "Lib ID-"+this.libID+": Unable to return, book not found. (Queried ID:" + bookID +")";
                }
            }
            return "Lib ID-"+this.libID+": Unable to return, member not found. (Queried ID: "+memberID+")";
        }
    }

    public boolean userReservedBook(int bookID ,int memberID) {
        for (LibraryMember member: members) {
            if (member.getMemberID()==memberID) {
                for(Book book : member.reserved){
                    if(book.getID()==bookID){
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public String reserveBook(int bookID, int memberID) {
        if (bookID== -1) {
            return "Lib ID-"+this.libID+": Unable to reserve, book ID not found.";
        } else if (memberID == -1) {
            return "Lib ID-"+this.libID+": Unable to reserve, member ID not found.";
        } else {
            for (LibraryMember member: members) {
                if (member.getMemberID()==memberID) {
                    for(Book book : localBooks){
                        if(book.getID()==bookID){
                            for(Book book1 : member.borrowed){
                                if(book1.getID()==bookID){
                                    return "Lib ID-"+this.libID+": Book already reserved by user:" +
                                            " '"+member.getMemberName()+"'";
                                }
                            }
                            book.reserveBook();
                            member.reserved.add(book);
                            return "Lib ID-"+this.libID+": Book reserved successfully by user:" +
                                    " '"+member.getMemberName()+"'";
                        }
                    }
                    return "Lib ID-"+this.libID+": Unable to reserve," +
                            " book not found. (Queried ID:" + bookID +")";
                }
            }
            return "Lib ID-"+this.libID+": Unable to reserve," +
                    " member not found. (Queried ID: "+memberID+")";
        }
    }
    public String unreserveBook(int bookID, int memberID) {
        if (bookID == -1) {
            return "Lib ID-"+this.libID+": Unable to unreserve, book ID not found.";
        } else if (memberID == -1) {
            return "Lib ID-"+this.libID+": Unable to unreserve, member ID not found.";
        } else {
            for (LibraryMember member: members) {
                if (member.getMemberID()==memberID) {
                    for(Book book : localBooks){
                        if(book.getID()==bookID){
                            for(Book book1 : member.reserved){
                                if(book1.getID()==bookID){
                                    book.unreserve();
                                    member.reserved.remove(book1);
                                    return "Lib ID-"+this.libID+": Book unreserved successfully by user:" +
                                            " '"+member.getMemberName()+"'";
                                }
                            }
                            return "Lib ID-"+this.libID+": Unable to unreserve," +
                                    " user has no reservation for such book. (Queried ID:" + bookID +")";
                        }
                    }
                    return "Lib ID-"+this.libID+": Unable to unreserve,"+
                            " book not found. (Queried ID:" + bookID +")";
                }
            }
            return "Lib ID-"+this.libID+": Unable to unreserve,"+
                    " user not found. (Queried ID: "+memberID+")";
        }
    }
}