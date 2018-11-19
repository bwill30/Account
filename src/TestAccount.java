// - Code by Ben McCall

//Importing the Scanner method.
import java.util.Scanner;

//This program will create accounts and display the account information.
public class TestAccount {

    //Create main method
    public static void main(String[] args) {

        //This declares and initializes the input and another variables.
        Scanner input = new Scanner(System.in);
        String another = "Y";

        while (another.equalsIgnoreCase("y")) {

            //This explains what the program does to the user.
            System.out.print("\nThis program will create accounts and display the account information.\n");

            System.out.print("\nInstructions: Please enter numbers only.\n");

            //Prompts user to enter a value for the account ID
            System.out.print("\nEnter your Account ID: ");
            int acctID = input.nextInt();

            //Prompts user to enter a value for the account balance.
            System.out.print("\nPlease enter your current account balance: ");
            double acctBal = input.nextDouble();

            //Prompts user to enter a value for the deposit amount.
            System.out.print("\nPlease enter the amount you would like to deposit: ");
            double deposit = input.nextDouble();

            //Prompts user to enter a value for the withdraw amount.
            System.out.print("\nPlease enter the amount you would like to withdraw: ");
            double withdraw = input.nextDouble();

            //Prompts user to enter a value for the interest rate.
            System.out.print("\nPlease enter your interest rate: ");
            double interest = input.nextDouble();

            //Creating object
           Account myObject = new Account(acctID,acctBal);

           //Getting the date the account was created
           myObject.getDate();

            //WITHDRAW & DEPOSIT
            myObject.deposit(deposit);
            myObject.withdraw(withdraw);

            //Setting annualInterestRate
            myObject.setAnnualInterestRate(interest);

            //Display account information
            System.out.println(myObject.toString());

            //Asks the user if they would like to run the program again.
            System.out.println("\n\nWould you like to try again?(Y/N): ");
            another = input.next();
        }
    }
}
