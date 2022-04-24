package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        Bank bank = new Bank();
        HashTable<Integer, String, String, Double, ArrayList<Pair>> customerList =
                new HashTable<>();

        int choice = -1;

        ArrayList<Pair> hTransactions = new ArrayList<>();
        ArrayList<Pair> pTransactions = new ArrayList<>();
        hTransactions.add(new Pair("Initial Deposit", 100.00));
        pTransactions.add(new Pair("Initial Deposit", 200.00));
        customerList.insert(1, "Henry Peeples", "214-803-5021", 100.00,
                hTransactions);
        customerList.insert(2, "Perry Williams", "214-455-4567", 200.00,
                pTransactions);

        do {
            choice = bank.showMenu();

            switch (choice) {
                case 1:
                    bank.addNewCustomer(customerList);
                    break;
                case 2:
                    System.out.print("\nEnter customers id: ");
                    int id = scnr.nextInt();
                    Double amount = bank.deposit(customerList.find(id));
                    if (amount != -1.00)
                        System.out.printf("\u001b[32;1m$%.2f deposit was " +
                                        "successful \u001b[0m\n",
                                amount);
                    else
                        System.out.println("\u001b[31;1mUnable to find " +
                                "account, please try again...\u001b[0m");
                    break;
                case 3:
                    // Withdraw
                    break;
                case 4:
                    // show specific customers transactions
                    break;
                case 5:
                    // remove customer from bank
                    break;
                case 6:
                    // edit customer account details
                    break;
                case 0:
                    System.out.println("\nGoodbye...");
                    break;
                default:
                    customerList.printCustomerList();
                    break;
            }
        } while (choice != 0);
    }
}
