//Task 1: Multi-threaded Number Printing
//Write a Java program that uses two threads to print numbers alternately.
//One thread should print odd numbers, and the other thread should print even numbers.
//The program should allow specifying a range of numbers to be printed.

public class Task1{
    public static void main(String[] args) {
        int to = 20;
        Thread t1 = new count("Odd",to/2);
        Thread t2 = new count("Even",to/2);

        t1.start();
        t2.start();
    }
}

class count extends Thread {
    private final String thread;
    private final int start;
    private final int to;
    public count(String thread, int to) {
        this.thread = thread;
        this.to = to;
        if (thread.equals("Odd")) {
            this.start=1;
        } else{
            this.start=2;
        }
    }
    public void run() {
        for (int i = 0; i < this.to; i++) {
            System.out.printf("%4s Thread: %s\n",this.thread,(this.start+i*2));
        }
    }
}