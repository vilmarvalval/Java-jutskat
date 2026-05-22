//You'll create a BankAccount class with instance variables for the account number and balance.
//The totalAccounts static variable keeps track the total number of accounts.
//You'll also implement instance methods for depositing and withdrawing funds,
// as well as a static method to retrieve the total number of accounts.
package bank;

public class bankAccount {
    protected String name;
    protected int accountNumber;
    protected double balance;
    protected bankAccount(String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    protected String setName(String name) {
        this.name = name;
        return this.accountNumber+"'s name set to: "+this.name;
    }
    protected void setId(int id){
        this.accountNumber = id;
    }

    protected double getBalance() {
        return this.balance;
    }
}