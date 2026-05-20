import java.util.ArrayList;

public class Library {
    static final ArrayList<Book> books = new ArrayList<>();

    static void addBook(String title, String author, String date){
        Book listBook = new Book();
        listBook.title = title;
        listBook.author = author;
        listBook.date = date;
        listBook.available = true;
        listBook.rating = 0;
        listBook.reviews = new ArrayList<>();
        books.add(listBook);
    }

    static String findByAuthor(String author){
        author = author.toLowerCase();
        StringBuilder filter = new StringBuilder();
        for (int i = 0; i < books.toArray().length; i++) {
            if (books.get(i).author.equals(author)){
                filter.append(books.get(i).title).append("\n");
            }
        }
        return filter.toString();
    }

    static String displayBooks(){
        StringBuilder allBooks = new StringBuilder();
        allBooks.append("All books:\nTitle, Author, DD.MM.YYYY\n");
        for (int i = 0; i < books.toArray().length; i++) {
            allBooks.append(books.get(i).title)
                    .append(" ").append(books.get(i).author)
                    .append(" ").append(books.get(i).date)
                    .append(books.get(i).rating>=15? (books.get(i).rating>=35?
                            (books.get(i).rating>=55? (books.get(i).rating>=75?
                                    (books.get(i).rating>=95? " *****" : " -****") :" --***") :" ---**") : " ----*") :" -----")
                    .append(books.get(i).available? " Available.\n":" Unavailable.\n");
        }
        return allBooks.toString();
    }
    //isBookAvailable(String title):
        // This method returns a boolean indicating whether
        // the book with the specified title is available in the library.
    static boolean isBookAvailable(String title){
        for (int i = 0; i < books.toArray().length; i++) {
            if (books.get(i).title.equals(title))
                return books.get(i).available;
        }
        return false;
    }

    //getAverageBookRating():
        // This method should calculate and return the average rating of all books in the library.
    static double getAverageBookRating(){
        double average=0;
        for (int i = 0; i < books.toArray().length; i++) {
            average+=books.get(i).rating;
        }
        average= average/books.toArray().length;
        return average;
    }

    //getMostReviewedBook():
        // This method should return the book with the highest number of reviews.
    static String getMostReviewedBook(){
        int top = 0;
        int topi = 0;
        for (int i = 0; i < books.toArray().length; i++) {
            if (books.get(i).reviews.size()>top) {
                top = books.get(i).reviews.size();
                topi = i;
            }
        }
        return books.get(topi).title;
    }

    //Modify the Library class to keep track (e.g., add, remove, find and list)
    // of library users and their borrowed books,
    // that means the user should have methods to borrow and return books through the library system.

    //borrowBook(String title):
        //This method simulates a book being borrowed.
    static void borrowBook(String title, User user){
        for (int i = 0; i < books.toArray().length; i++) {
            if (books.get(i).title.equals(title)){
                if (books.get(i).available) {
                    books.get(i).available = false;
                    System.out.println(title + " -book borrowed by user: "+user.name);
                    user.borrowed.add(books.get(i));
                    //return books.get(i);
                } else{
                    System.out.println(title+" -book unavailable.");
                }
            }
        }
    }

    //returnBook(Book book):
        //This method simulates a book being returned to the library.
    static void returnBook(String title, User user){
        for (int i = 0; i < books.toArray().length; i++) {
            if (books.get(i).title.equals(title)){
                if (!books.get(i).available) {
                    boolean userHasBook=false;
                    for (int j = 0; j < user.borrowed.toArray().length; j++) {
                        if (user.borrowed.get(j).title.equals(books.get(i).title)){
                            books.get(i).available = true;
                            userHasBook = true;
                            user.borrowed.remove(books.get(i));
                        }
                    }
                    if (userHasBook){
                        System.out.println(title + " -book returned by user: "+user.name);
                    } else {
                        System.out.println("User "+ user.name+" has no borrowed books titled "+title);
                    }
                } else {
                    System.out.println("User: "+user.name+" failed to return book: "+title+". Book has already been returned.");
                }
            }
        }
    }

}
