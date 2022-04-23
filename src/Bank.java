/*
 * The Bank class will do the following:
 *      - Add a customer/user
 *      - Add transactions based on the customer
 *      - Show a list of customers
 *      - Show a specific customers transactions
 *      - Show a menu that allows for user to perform operations
 */
package src;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Bank {
    private final String bankName;

    // Bank constructor
    public Bank(String bankName) {
        this.bankName = bankName;
    }

    // add new customer
    public void addNewCustomer(HashTable<Integer, String, String, Double,
            ArrayList<Pair>> customerList) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<Pair> transactions = new ArrayList<>();

        System.out.println();

        System.out.print("Enter customers name: ");
        String name = scnr.nextLine();

        System.out.print("Enter customers phone number: ");
        String phoneNumber = scnr.nextLine();

        System.out.print("Are they making an initial deposit? (y/n): ");
        String c = scnr.nextLine();

        Double balance = 0.00;
        if (c.equals("y")) {
            System.out.print("Enter the deposit amount: ");
            balance = scnr.nextDouble();
            // add initial deposit amount to transaction list
            transactions.add(new Pair("Initial Deposit", balance));
        }

        System.out.println();
        // generate ID
        int id = ThreadLocalRandom.current().nextInt(0, 999);
        // add customer to hash table
        customerList.insert(id, name, phoneNumber, balance, transactions);
    }
}
