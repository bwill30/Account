/*
Class: CS 5000/01
Term: Fall 2018
Name:Benjamin McCall
Instructor: Dr. Haddad
Assignment: 11
IDE: IntelliJ IDEA
*/

//Importing the Date and DecimalFormat methods.
import java.util.Date;
import java.text.DecimalFormat;

public class Account {

    //This declares and initializes the id, balance, and annualInterestRate variables.
    private int id = 0;
    private double balance = 0.0;
    private double annualInterestRate = 0.0;
    private Date dateCreated = new Date();
    private String exceptionMessage = "";

    //CONSTRUCTORS
    Account() {

    }

    Account(int id, double balance) {

        setID(id);
        setBalance(balance);
    }

    //GET METHODS
    public int getID() {

        return id;
    }

    public double getBalance() {

        return balance;
    }

    public double getAnnualInterestRate() {

        return annualInterestRate;
    }

    public Date getDate() {

        return dateCreated;
    }

    //SET METHODS
    public void setID(int newID) {

        id = newID;
    }

    public void setBalance(double newBalance) {

        try {

            if (newBalance < 0) {

                throw new IllegalArgumentException();
            }

            else {

                balance = newBalance;
            }
        }

        catch (IllegalArgumentException e){

            exceptionMessage = exceptionMessage + "\n\nInvalid Input: Initial Balance amount must be positive.";
        }
    }

    public void setAnnualInterestRate(double newAnnualInterestRate) {

        try {


            if (newAnnualInterestRate < 0) {

                throw new  IllegalArgumentException();
            }

            else {

                annualInterestRate = newAnnualInterestRate / 100;
            }
        }

        catch ( IllegalArgumentException e){

            exceptionMessage = exceptionMessage + "\n\nInvalid Input: Interest Rate amount must be positive.";
        }
    }

    //ADDITIONAL METHODS
    public double getMonthlyInterestRate () {

         return getAnnualInterestRate()/12;
    }

    public double getMonthlyInterest() {

          return balance * getMonthlyInterestRate();
    }

     public void deposit(double amount) {

        try {

            if (amount < 0) {

                throw new IllegalArgumentException();
            }

            else {

                setBalance(getBalance() + amount);
            }
        }

        catch (IllegalArgumentException e){

            exceptionMessage = exceptionMessage + "\n\nInvalid Input: Deposit amount must be positive.";
        }
    }

    public void withdraw(double amount) {

        try {

            if (amount < 0) {

                throw new IllegalArgumentException();
            }

            else {

                setBalance(getBalance() - amount);
            }
        }

        catch (IllegalArgumentException e){

            exceptionMessage = exceptionMessage + "\n\nInvalid Input: Withdraw amount must be positive.";
        }
    }

    public String toString() {

        //This declares and initializes newFormat to format the output.
        DecimalFormat newFormat = new DecimalFormat("$###,###,##0.00");
        DecimalFormat newPercent = new DecimalFormat("##0.00%");

                 return ("\nAccount ID:\t\t\t" + id +
                         "\nAccount Balance:\t" + newFormat.format(balance) +
                         "\nInterest Rate:\t\t" + newPercent.format(annualInterestRate) +
                         "\nMonthly Interest:\t" + newFormat.format(getMonthlyInterest()) +
                         "\nDate Opened:\t\t" + dateCreated + exceptionMessage);
    }
}
