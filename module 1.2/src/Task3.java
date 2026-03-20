//One leiviskä is 20 naula.
//One naula is 32 luoti.
//One luoti is 13.28 grams.

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args){
        boolean loop=true;
        float number;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("Enter weight to convert (in grams):");
            try {
                number = Integer.parseInt(scanner.nextLine());
                int leviskät = (int) Math.floor(number/(13.28*32*20));
                int naulat = (int) Math.floor(number/(13.28*32)-leviskät*20);
                double luodit = number/13.28 - naulat*32 - leviskät*20*32;
                System.out.printf("Weight is: "+leviskät+" Leviskää, "+naulat+" naulaa, and "+"%.2f"+ " luotia.%n", luodit);
                loop = false;
            } catch (Throwable err){
                System.out.println("Enter a valid number");
            }
        }
    }
}