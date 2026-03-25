//Write a program that prompts the user to enter two positive integers,
// start and end (where start < end).
// The program should generate and display all the prime numbers between start and end, inclusive.
//A prime number is a positive integer greater than 1 that has no positive divisors other than 1 and itself.
//Your program should use control structures (such as loops and conditional statements)
// to implement the logic for generating and checking prime numbers.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task3 {
    static boolean isPrime(int n){
        if (n<=1){
            return false;
        }

        for (int i = 2; i < n; i ++) {
            if (n%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean loop = true;
        System.out.println("This program finds all prime numbers between two given numbers.");
        while (loop){
            System.out.println("Give first positive number.");
            try {
                int one = Integer.parseInt(scan.nextLine());
                while (loop){
                    System.out.println("Give second number.");
                    try {
                        int two = Integer.parseInt(scan.nextLine());
                        int min;
                        int max;
                        if (two < one){
                            min = two;
                            max = one;
                        } else {
                            min = one;
                            max = two;
                        }
                        List<Integer> primes= new ArrayList<Integer>();
                        for (int i = min; i < max; i++) {
                            if (isPrime(i)){
                                primes.add(i);
                            }
                        }
                        System.out.println("Primes: "+ Arrays.toString(primes.toArray()));
                        loop = false;
                    } catch (Throwable err){
                        System.out.println("Invalid input.");
                    }
                }
            }catch (Throwable err){
                System.out.println("Invalid input.");
            }
        }
    }
}