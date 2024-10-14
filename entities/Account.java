package entities;

import exception.InvalidQuantity;
import java.util.Date;
import java.util.Random;

public class Account {
    Random random = new Random();

    protected Date dateLogup;
    protected String holder;
    protected Integer password;
    protected Double balance;

    public Account(Date dateLogup, String holder, Integer password, Double balance) {
        this.dateLogup = dateLogup;
        this.holder = holder;
        this.password = password;
        this.balance = balance;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void deposit(double amount)
    {
        if(amount > 0 && amount <= 50.000)
        {
            balance += amount;
        }

        else{
            throw new InvalidQuantity("The amount to be deposited must be greater than 0 and less than or equal to U$50.000.");
        }
    }

    public void withdraw(double amount)
    {
        if(amount > balance || amount > 100.000)
        {
            throw new InvalidQuantity("You cannot attempt to withdraw an amount greater than your balance or greater than U$100.000.");
        }

        else{
            balance -= amount;
        }

    }

    public String printHolder()
    {
        return "You holder is: " + holder;
    }

    public String printBalance()
    {
        return "Your balance is: U$" + String.format("%.2f", balance);
    }

}
