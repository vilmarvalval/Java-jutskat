//Task 1: Creating a Simple Bank Account Management System
//
//In this exercise, you'll create a simple bank account management system using static variables and methods.


//The main method demonstrates how to use the class by creating accounts,
// performing transactions, and checking the total number of accounts.
package bank;

import java.util.ArrayList;

public class bankManager {
    private static ArrayList<bankAccount> accounts = new ArrayList<bankAccount>();
    private static int numberOfAccounts;
    public static void main(String[] args) {
        System.out.println(addAccount(null));

        System.out.println(addAccount(null));

        System.out.println(addAccount("acc2"));
        System.out.println(addAccount(null));
        System.out.println(addAccount("acc4"));
        System.out.println(addAccount("acc5"));

        System.out.println(changeAccountName(0, "test1 R"));
        System.out.println(changeAccountName(1, "test2"));
        System.out.println(changeAccountName(2, "test3 R"));

        printAccounts();

        removeAccount(0);
        removeAccount(1);

        printAccounts();

        System.out.println(changeAccountName(accounts.size()-1, "test"+(accounts.size())));
        System.out.println(changeAccountName(accounts.size()-2, "test"+(accounts.size()-1)));
        printAccounts();
        System.out.println(changeBalance(5000, accounts.size()-1));
        System.out.println(changeBalance(500, 1));

        System.out.println(changeBalance(500, getID("pena")));
        System.out.println(transferFunds(accounts.size()-1, getID("pena"), 500));
        System.out.println(changeAccountName(1, "pena"));
        System.out.println(changeBalance(500, getID("pena")));
        System.out.println(transferFunds(accounts.size()-1, getID("pena"), 250));
        printAccounts();

        System.out.println(transferFunds(accounts.size()-1, accounts.size()-2, 1000));
        printAccounts();

        removeAccount(-1);
        removeAccount(10);
        addAccount(null);
        printAccounts();
        removeAccount(4);
        removeAccount(4);
    }

    private static String addAccount(String name){
        int id= numberOfAccounts;
        numberOfAccounts++;
        if (name==null){
            accounts.add(new bankAccount("account "+numberOfAccounts, id));
            return "Account id:"+id+" added.";
        } else {
            accounts.add(new bankAccount(name, id));
            return "Account "+name+" added. (id:"+id+")";
        }
    }

    private static void removeAccount(int id){
        if(id<0 || id>accounts.size()-1 || accounts.get(id) == null){
            System.out.println("Account not found. (Queried id:"+id+")");
        } else{
            numberOfAccounts=0;
            accounts.remove(id);
            for(bankAccount a:accounts){
                a.setId(numberOfAccounts);
                numberOfAccounts++;
            }
            System.out.println("Account removed. (Queried id:"+id+")");
            printAccounts();
        }
    }

    private static String changeAccountName(int id, String name){
        return "Account id:"+accounts.get(id).setName(name);
    }

    private static void printAccounts(){
        System.out.println("\nAll accounts:");
        for(bankAccount account : accounts){
            System.out.println("Account id:"+account.accountNumber);
            System.out.println("Account name: "+account.name);
            System.out.println("Account Balance: "+account.balance+"€");
            System.out.println("----------------------------");
        }
    }
    private static int getID(String name){
        for(bankAccount a:accounts){
            if (a.name.equals(name)){
                return a.accountNumber;
            }
        }
        return -1;
    }

    private static String changeBalance(double amount, int id){
        if (id<0 || id>=accounts.size()){
            return "Cannot change balance. Account does not exist. (Queried id:"+id+")";
        } else {
            accounts.get(id).setBalance(amount);
            return accounts.get(id).name+"'s balance changed to: "+accounts.get(id).getBalance();
        }
    }

    private static String transferFunds(int from, int to, double amount){
        if(amount<0){
            return "Cannot transfer negative funds.";
        } else if (from<0 || from>=accounts.size()){
            return "Account does not exist. (Queried id:"+from+")";
        } else if (to<0 || to>=accounts.size()){
            return "Account does not exist. (Queried id:"+to+")";
        } else {
            accounts.get(from).setBalance(accounts.get(from).getBalance()-amount);
            accounts.get(to).setBalance(accounts.get(to).getBalance()+amount);
            return amount+"€ successfully transferred from "+accounts.get(from).name+" to "+accounts.get(to).name;
        }
    }
}