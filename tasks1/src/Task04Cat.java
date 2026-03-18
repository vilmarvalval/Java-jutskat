public class Task04Cat {
    private final String name;
    private final String meow;

    public Task04Cat(String name, String meow) {
        this.name = name;
        this.meow = meow;
    }

    public void meow() {
        System.out.println("The cat named " + name + " says: "+ meow);
    }

    public static void main(String[] args) {
        // Create an instance of the Cat class with a name
        Task04Cat cat1 = new Task04Cat("Whiskers", "Meow!");
        Task04Cat cat2 = new Task04Cat("Rex", "Meow!!");

        // Call the meow method on the cat instance
        cat1.meow();
        cat1.meow();
        cat2.meow();
        cat1.meow();
    }
}