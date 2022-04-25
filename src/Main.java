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
                    try {
                        bank.addNewCustomer(customerList);
                    } catch (Exception e) {
                        System.out.println("\u001b[31;1mUnable to add " +
                                "customer, please try again...\u001b[0m");
//                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    System.out.print("\nEnter customers ID: ");
                    int id = scnr.nextInt();
                    // make deposit
                    bank.deposit(customerList.find(id));
                    break;
                case 3:
                    System.out.print("\nEnter customers ID: ");
                    id = scnr.nextInt();
                    // make withdraw
                    bank.withdraw(customerList.find(id));
                    break;
                case 4:
                    System.out.print("\nEnter customers ID: ");
                    id = scnr.nextInt();
                    // show specific customers transactions
                    bank.showCustomerTransactions(customerList.find(id));
                    break;
                case 5:
                    System.out.print("\nEnter customers ID: ");
                    id = scnr.nextInt();
                    // remove customer from bank
                    int rm = customerList.remove(id);
                    if (rm == -1)
                        System.out.println("\u001b[31;1mNo customers found " +
                                "with ID: " + id + "\u001b[0m");
                    else
                        System.out.printf("\u001b[32;1m[%d] was successfully " +
                                "removed.\u001b[0m\n", id);
                    break;
                case 6:
                    System.out.print("\nEnter customers ID: ");
                    id = scnr.nextInt();
                    // edit customer account details
                    bank.editAccountDetails(customerList.find(id));
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
