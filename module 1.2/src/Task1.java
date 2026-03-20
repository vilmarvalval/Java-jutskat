import java.util.Scanner;

public class Task1 {
    public static void main(String[] args){
        boolean advance = false;
        int number;
        while (!advance) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Fahrenheit to convert into Celsius (number only)");
            try {
                number = Integer.parseInt(scanner.nextLine());
                System.out.println((( number - 32)* (float) 5/9) + "°C");
                advance = true;
            } catch (Throwable err) {
                System.out.println("Enter a valid number.");
            }
        }
    }
}