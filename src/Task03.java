import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the third number:");
        int third = Integer.parseInt(scanner.nextLine());

        System.out.println("The sum of the numbers is " + (first + second + third));
        System.out.println("Product of numbers: " + (first*second*third) );
        //convert to float in order to support decimals vvv
        System.out.println("Average of numbers: " + (float) (first + second + third) /3);
    }
}