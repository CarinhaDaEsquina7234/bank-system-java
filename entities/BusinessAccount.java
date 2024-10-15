package entities;

import exception.InvalidQuantity;
import java.util.Date;
import java.util.Random;

public class BusinessAccount extends Account {

    public BusinessAccount(Date dateLogup, String holder, Integer password) {
        super(dateLogup, holder, password);
    }

    @Override
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

@Override
    public void withdraw(double amount)
    {
        if(amount > balance || amount > 500.000)
        {
            throw new InvalidQuantity("You cannot attempt to withdraw an amount greater than your balance or greater than U$500.000.");
        }

        else{
            balance -= amount;
        }

    }

@Override
    public String printHolder()
    {
        return "You holder is: " + holder;
    }

@Override
    public String printBalance()
    {
        return "Your balance is: U$" + String.format("%.2f", balance);
    }

}
