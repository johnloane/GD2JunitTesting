package com.dkit.gd2.johnloane;

public class BankAccount
{
    private String firstName;
    private String lastName;
    private int accountNumber;
    private double balance;
    private String phoneNumber;
    private int accountType;

    protected static final int CHECKING = 1;
    protected static final int SAVING = 2;

    public BankAccount(String firstName, String lastName, int accountNumber, double balance, String phoneNumber, int typeOfAccount)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.phoneNumber = phoneNumber;
        this.accountType = typeOfAccount;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    @Override
    public String toString()
    {
        return "BankAccount{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    //The branch argument is true if the customer transaction
    //is in a branch with a teller
    //It is false for ATM transactions

    protected double deposit(double amount, boolean branch)
    {
        this.balance += amount;
        return balance;
    }

    //The branch argument is true if the customer transaction
    //is in a branch with a teller
    //It is false for ATM transactions

    protected double withdraw(double amount, boolean branch)
    {
        if((amount > 500.0) && !branch)
        {
            throw new IllegalArgumentException();
        }
        this.balance -= amount;
        return balance;
    }

    protected boolean isChecking()
    {
        return this.accountType == CHECKING;
    }
}
