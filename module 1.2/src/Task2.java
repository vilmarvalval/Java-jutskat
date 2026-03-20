import java.util.Scanner;

public class Task2 {
    public static void main(String[] args){
        float first;
        float second;
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("Enter width of triangle:");
            try {
                first = Float.parseFloat(scanner.nextLine());
                while (loop){
                    System.out.println("Enter height of triangle:");
                    try {
                        second = Float.parseFloat(scanner.nextLine());
                        System.out.println("Hypotenuse: "+Math.sqrt(Math.pow(first,2)+Math.pow(second,2)));
                        loop = false;
                    } catch (Throwable err){
                        System.out.println("Enter a valid number.");
                    }
                }
            } catch (Throwable err){
                System.out.println(err);
                System.out.println("Enter a valid number.");
            }
        }
    }
}