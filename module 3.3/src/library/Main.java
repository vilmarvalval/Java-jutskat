//Step 3: Implement Main Application
//Create a Main class outside the packages (in the root directory).
//In this class, create instances of the Library class, add Books and members,
// and perform borrowing and returning operations.
package library;

import library.system.Library;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nCreating library objects");
        Library library1 = new Library(1);
        Library library2 = new Library(2);

        library1.addBook("test1","test author","1");
        System.out.println(
                library1.addBook("test2","AAAAAA","2"));
        System.out.println(
                library1.addBook(
                        "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "9780345418913"
                )
        );
        library2.addBook("The King in Yellow", "Robert W. Chambers", "9798867200091");
        library1.addBook("Mustat aukot","Markus Hotakainen","9789511373810");
        library1.addBook("Linnunradan Kapteeni","Tero Niemi","9789527275597");
        System.out.println(library1.addBook("","",""));

        System.out.println("Testing removing command");
        System.out.println(
                library1.removeBook(library1.getBookID("test2",null)));
        System.out.println(
                library1.addBook("test2","AAAAAA","2"));

        System.out.println("\nCreating members");

        library1.addMember("Marisa");
        //members are currently synced between objects. This tests prevention of duplicate members
        System.out.println(
                library2.addMember("Patchouli")
        );
        System.out.println(
                library1.addMember("Patchouli")
        );
        System.out.println(
                library1.addMember("Alice")
        );
        System.out.println(
                library2.addMember("D"));
        System.out.println(
                library1.addMember("Vilmarvalval")
        );

        library1.printMembers();
        System.out.println(
                library2.removeMember(library2.getMemberID("D"))
        );

        library1.printMembers();
        library1.printLocalBooks();

        System.out.println("\nTesting borrowing commands");
        //testing different incorrect borrowing commands
        System.out.println(
                library2.borrowBook(//incorrect
                        library1.getBookID(null,"Robert W. Chambers"),
                        library2.getMemberID("Patchouli")
                )
        );
        System.out.println(
                library1.borrowBook(//incorrect
                        library1.getBookID(null,"Robert W. Chambers"),
                        library2.getMemberID("Patchouli")
                )
        );
        //correct one requires book to be fetched from the same library it is being borrowed from,
        // technically if both libraries have the same book, it doesn't matter which library its fetched from.
        System.out.println(
                library2.borrowBook(//correct
                        library2.getBookID(null,"Robert W. Chambers"),
                        library2.getMemberID("Patchouli")
                )
        );

        System.out.println(
                library1.borrowBook(library1.getBookID("test1", null),
                        library1.getMemberID("Marisa"))
        );
        System.out.println(
                library1.borrowBook(
                        library1.getBookID("Mustat aukot", null),
                        library1.getMemberID("Vilmarvalval")
                )
        );
        System.out.println(
                library1.borrowBook(
                        library1.getBookID(null, "Tero Niemi"),
                        library1.getMemberID("Vilmarvalval")
                )
        );
        //check books and members
        library1.printLocalBooks();
        library2.printMembers();
        System.out.println(
            library1.returnBook(
                    library2.getUserBookID(null, null,library2.getMemberID("Patchouli")),
                    library2.getMemberID("Patchouli")
            )
        );

        //testing if member is able to return a book to a different library
        System.out.println(
                library2.returnBook(
                        library2.getUserBookID(null, "Robert W. Chambers",library2.getMemberID("Patchouli")),
                        library2.getMemberID("Patchouli")
                )
        );

        System.out.println(
                library1.returnBook(
                        library1.getUserBookID("test1", null,library1.getMemberID("Marisa")),
                        library1.getMemberID("Marisa")
                )
        );
        //testing if a library can have multiple copies of the same book
        System.out.println(
                library1.addBook("test2","AAAAAA","2")
        );

        library1.printLocalBooks();
        library2.printLocalBooks();
        library1.printMembers();

        System.out.println(
                library1.borrowBook(
                        library1.getBookID(null, "AAAAAA"),
                        library1.getMemberID("Alice")
                )
        );
        System.out.println(
                library1.borrowBook(
                        library1.getBookID(null, "AAAAAA"),
                        library1.getMemberID("Alice")
                )
        );
        library1.printMembers();
        System.out.println(
                library1.returnBook(
                        library1.getUserBookID(null, "AAAAAA",library1.getMemberID("Marisa")),
                        library1.getMemberID("Marisa")
                )
        );
        System.out.println(
                library2.returnBook(
                        library1.getUserBookID("test2", "AAAAAA",library1.getMemberID("Alice")),
                        library1.getMemberID("Alice")
                )
        );
        System.out.println(
                library2.returnBook(
                        library1.getUserBookID("test2", "AAAAAA",library1.getMemberID("Alice")),
                        library1.getMemberID("Alice")
                )
        );
        System.out.println(
                library2.returnBook(
                        library1.getUserBookID("test2", "AAAAAA",library1.getMemberID("Alice")),
                        library1.getMemberID("Alice")
                )
        );

        library2.borrowBook(
                library2.getBookID("test1", null),
                library2.getMemberID("Marisa")
        );

        library2.printLocalBooks();
        library1.printMembers();

        // reserving/unreserving tests
        System.out.println(
            library2.reserveBook(
                    library2.getBookID("test2", null),
                    library2.getMemberID("Marisa")
            )
        );
        System.out.println(
                library2.unreserveBook(
                        library2.getBookID("test2", null),
                        library2.getMemberID("Marisa")
                )
        );
        System.out.println(
                library2.reserveBook(
                        library2.getBookID("test2", null),
                        library2.getMemberID("Marisa")
                )
        );
        System.out.println("\nChecking after reservation");
        library2.printLocalBooks();
        library1.printAllBooks();
        library2.printMembers();
        System.out.println("\nAttempting to borrow reserved book");
        System.out.println(
                library2.borrowBook(
                        library2.getBookID(null, "AAAAAA"),
                        library2.getMemberID("Alice")
                )
        );
        System.out.println(
            library2.borrowBook(
                    library2.getBookID(null, "AAAAAA"),
                    library2.getMemberID("Marisa")
            )
        );
        System.out.println(
                library1.borrowBook(
                        library1.getBookID("test1", null),
                        library1.getMemberID("Marisa")
                )
        );
        System.out.println(
                library2.borrowBook(
                        library2.getBookID(null, "AAAAAA"),
                        library2.getMemberID("Alice")
                )
        );
        library2.printLocalBooks();
        library2.printMembers();
    }
}