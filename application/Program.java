package application;

import entities.Account;
import entities.BusinessAccount;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Date date = new Date();

        String path = "C:\\Users\\Rafaelzin7234\\Documents\\Pendrive\\bank-system-java\\data-archives\\logupdata.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true)))
        {
            System.out.println("Do you want to create a regular account or a business account?");
            System.out.println("OPTIONS:");
            System.out.println("1. Normal Account.");
            System.out.println("2. Business Account.");
            int option = sc.nextInt();

            switch (option)
            {
                case 1:
                    System.out.print("What will be your holder? (first and last name): ");
                    sc.nextLine();
                    String holder = sc.nextLine();

                    System.out.print("What will your password be? ");
                    int password = sc.nextInt();

                    Account acc = new Account(date, holder, password);

                    bw.write(holder + date);

                    break;

                case 2:
                    System.out.print("What will be your holder? (first and last name): ");
                    sc.nextLine();
                    holder = sc.nextLine();

                    System.out.print("What will your password be? ");
                    password = sc.nextInt();

                    Account bsc = new BusinessAccount(date, holder, password);

                    bw.write(holder + date);

                    break;
            }

        }

        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

        sc.close();
    }

}
