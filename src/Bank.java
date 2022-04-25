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
    Scanner scnr = new Scanner(System.in);

    // add new customer
    public void addNewCustomer(HashTable<Integer, String, String, Double,
            ArrayList<Pair>> customerList) {
        ArrayList<Pair> transactions = new ArrayList<>();

        scnr.nextLine();
        System.out.print("\nEnter customers name: ");
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

        // generate ID
        int id = ThreadLocalRandom.current().nextInt(0, 999);
        // add customer to hash table
        customerList.insert(id, name, phoneNumber, balance, transactions);
        System.out.printf("\u001b[32;1mCustomer " +
                "successfully added with ID: %d\u001b[0m\n", id);
    }

    // show bank system menu
    public int showMenu() {
        System.out.println("\n-----------  Bank System  -----------");
        System.out.println("[1] Add new customer");
        System.out.println("[2] Deposit");
        System.out.println("[3] Withdraw");
        System.out.println("[4] Show customer transactions");
        System.out.println("[5] Close account");
        System.out.println("[6] Edit account details");
        System.out.println("[0] Exit");

        System.out.print("Option: ");

        return scnr.nextInt();
    }

    // make deposit for a customer
    public Double deposit(HashNode<Integer, String, String, Double,
            ArrayList<Pair>> customer) {

        if (customer != null) {
            System.out.print("Enter deposit amount: $");
            Double amount = scnr.nextDouble();

            customer.balance += amount;

            customer.transactions.add(new Pair("Deposit", amount));

            return amount;
        }
        return -1.00;
    }

    // withdraw from customers account
    public Double withdraw(HashNode<Integer, String, String, Double,
            ArrayList<Pair>> customer) {

        if (customer != null) {
            System.out.print("Enter withdraw amount: $");
            Double amount = scnr.nextDouble();

            if (customer.balance >= amount) {
                customer.balance -= amount;

                customer.transactions.add(new Pair("Withdraw", amount));

                return amount;
            }
            // not enough money in account
            return -2.00;
        }
        return -1.00;
    }
}
