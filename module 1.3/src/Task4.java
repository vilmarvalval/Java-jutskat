//If the user scores ten points for the entire set of problems,
// the program congratulates them on mastering the multiplication tables and terminates.
// Otherwise, the program starts a new set of problems.

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int points=0;
        while (points<10){
            System.out.println("This tool assists in learning multiplication.");
            for (int i = 0; i < 10; i++) {
                int random1 = (int) (Math.random() * 10 + 1);
                int random2 = (int) (Math.random() * 10 + 1);
                System.out.println("What is "+random1+" multiplied by "+random2+"?(enter number only)");
                int guess = Integer.parseInt(scan.nextLine());
                if (guess ==(random1*random2)){
                    points+=1;
                    System.out.println("Correct! Points: "+points);
                } else {
                    System.out.println("Incorrect. Try again");
                }
            }
            if (points<10) {
                System.out.println("Points: "+points+" out of 10, ");
                points = 0;
            };
        }
        System.out.println("You have mastered multiplications, congratulations!");
    }
}