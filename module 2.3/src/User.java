import java.util.ArrayList;

public class User {
    String name;
    int age;
    ArrayList<Book> borrowed = new ArrayList<>();
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}