//Task 1: Ticket Reservation System
//Create a Java program that simulates a ticket reservation system for
// a limited number of seats in a theater.
//Implement synchronization to ensure that multiple threads representing customers
// can reserve seats without exceeding the available capacity.

import java.util.ArrayList;

public class Task1{
    public static void main(String[] args){
        int processors = Runtime.getRuntime().availableProcessors();
        int seats = 10;
        int customers = 15;
        int maxTickets = 4;

        simulateCustomers(customers,maxTickets,processors,seats);
    }

    //
    static void simulateCustomers(int customers, int maxTickets, int threads, int seats){
        int completed =0;
        int tickets;
        //this array will track which treads are in use
        ArrayList<Thread> occpdThreads = new ArrayList<>();
        //run simulation as long as necessary to satisfy customer count
        while(completed < customers){
            //assign a task to all given threads
            if(occpdThreads.size() < threads){
                //System.out.println("Assigning thread. Occupied threads: "+occpdThreads.size());
                tickets = (int) (Math.random() * (maxTickets-1))+1;
                occpdThreads.add(new reserveTickets(completed+1, tickets, seats));
                completed++;
            }
            if (!occpdThreads.isEmpty()){
                for (Thread thread : occpdThreads) {
                    //start threads that are not running
                    if(thread.getState() == Thread.State.NEW){
                        thread.start();
                    }
                }
            }
            //remove thread from occupied when finished
            occpdThreads.removeIf(thread -> !thread.isAlive());
        }

    }
}

class reserveTickets extends Thread{
    private final int customer;
    private final int tickets;
    private final int seats;
    private static int reserved;
    reserveTickets(int customer, int tickets, int seats){
        this.customer = customer;
        this.tickets = tickets;
        this.seats = seats;
    }
    public synchronized void reserve(int customer, int amount){
        reserved +=amount;
        if (seats - reserved <0){
            reserved -=amount;
            System.out.println("Customer "+customer+" couldn't reserve "+amount+" tickets. Remaining tickets: "+ (seats-reserved));
        } else {
            System.out.println("Customer "+customer+" reserved "+amount+" tickets. Remaining tickets: "+ (seats-reserved));
        }
    }
    public void run(){
        reserve(this.customer, this.tickets);
    }
}