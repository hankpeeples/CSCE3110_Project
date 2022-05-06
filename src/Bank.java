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
        System.out.println("[7] Show list of all customers");
        System.out.println("[0] Exit");

        System.out.print("Option: ");

        try {
            return scnr.nextInt();
        } catch (Exception e) {
            scnr.next();
            System.out.println("\u001b[31;1mInvalid input... Please " +
                    "enter a number from 0 - 7\u001b[0m");
            return -1;
        }
    }

    // make deposit for a customer
    public void deposit(HashNode<Integer, String, String, Double,
            ArrayList<Pair>> customer) {

        if (customer != null) {
            System.out.print("Enter deposit amount: $");
            Double amount = scnr.nextDouble();

            customer.balance += amount;

            customer.transactions.add(new Pair("Deposit", amount));

            System.out.printf("\u001b[32;1m$%.2f deposit was " +
                    "successful \u001b[0m\n", amount);
            return;
        }
        System.out.println("\u001b[31;1mUnable to find " +
                "account, please try again...\u001b[0m");
    }

    // withdraw from customers account
    public void withdraw(HashNode<Integer, String, String, Double,
            ArrayList<Pair>> customer) {

        if (customer != null) {
            System.out.print("Enter withdraw amount: $");
            Double amount = scnr.nextDouble();

            if (customer.balance >= amount) {
                customer.balance -= amount;

                customer.transactions.add(new Pair("Withdraw", amount));

                System.out.printf("\u001b[32;1m$%.2f withdraw was " +
                        "successful \u001b[0m\n", amount);
                return;
            }
            // not enough money in account
            System.out.println("\u001b[31;1mInsufficient funds.." +
                    ".\u001b[0m");
            return;
        }
        System.out.println("\u001b[31;1mUnable to find " +
                "account, please try again...\u001b[0m");
    }

    // show specific customers transactions
    public void showCustomerTransactions(HashNode<Integer, String, String,
            Double, ArrayList<Pair>> customer) {
        System.out.printf("\n\t\u001b[33mTransactions for %s: \u001b[0m\n",
                customer.name);
        if (!customer.transactions.isEmpty())
            for (int j = 0; j < customer.transactions.size(); j++)
                Pair.showList(customer.transactions.get(j));
    }

    // edit specific customer account details
    public void editAccountDetails(HashNode<Integer, String, String,
            Double, ArrayList<Pair>> customer) {
        System.out.println("What item do you want to edit?");
        System.out.println("[1] Name");
        System.out.println("[2] Phone Number");
        System.out.print("Option: ");
        int c = scnr.nextInt();

        switch (c) {
            case 1:
                try {
                    scnr.nextLine();
                    System.out.print("Enter new name: ");
                    customer.name = scnr.nextLine();
                    System.out.println("\u001b[32;1mAccount name was successfully" +
                            " updated \u001b[0m");
                } catch (Exception e) {
                    System.out.println("\u001b[31;1mUnable to update account " +
                            "name...\u001b[0m");
//                    throw new RuntimeException(e);
                }
                break;
            case 2:
                try {
                    scnr.nextLine();
                    System.out.print("Enter new phone number: ");
                    customer.phoneNumber = scnr.nextLine();
                    System.out.println("\u001b[32;1mAccount phone number was " +
                            "successfully updated \u001b[0m");
                } catch (Exception e) {
                    System.out.println("\u001b[31;1mUnable to update account " +
                            "phone number...\u001b[0m");
//                    throw new RuntimeException(e);
                }
                break;
            default:
                System.out.println("\u001b[31;1mInvalid option...\u001b[0m\n");
                editAccountDetails(customer);
                break;
        }
    }

    // get customers id
    public int getId() {
        System.out.print("\nEnter customers ID: ");
        return scnr.nextInt();
    }
}
