public class LibraryMain {
    public static void main(String[] args){
        Library lib = new Library();
        User Matti = new User("Matti", 25);
        User Linda = new User("Linda", 30);

        lib.addBook("testi 1","testi 1","01.01.1970");
        lib.addBook("testi 2","testi 1","16.08.2008");
        lib.addBook("testi 3","testi 2","02.02.2020");

        System.out.println(lib.findByAuthor("testi 1"));
        lib.borrowBook("testi 1", Matti);

        lib.borrowBook("testi 1", Matti);
        System.out.println(lib.displayBooks());
        System.out.println("'testi 1' is available: "+lib.isBookAvailable("testi 1"));
        System.out.println("'testi 2' is available: "+lib.isBookAvailable("testi 2"));

        System.out.println(Matti.borrowed);

        lib.returnBook("testi 1", Matti);
        System.out.println(Matti.borrowed);

        lib.returnBook("testi 1", Matti);
        System.out.println("'testi 1' is available: "+lib.isBookAvailable("testi 1"));

        lib.borrowBook("testi 1", Linda);
        lib.returnBook("testi 1", Matti);
        lib.returnBook("testi 1", Linda);
        lib.returnBook("testi 1", Matti);
    }
}